﻿using System;
using System.Collections;
using System.Collections.Generic;

namespace ShineEngine
{
	/// <summary>
	/// 
	/// </summary>
	public class LongObjectMap<V>:BaseHash,IEnumerable<V>
	{
		private long _freeValue;

		private long[] _set;

		private V[] _values;

		private EntrySet _entrySet;

		public LongObjectMap()
		{
			init(_minSize);
		}

		public LongObjectMap(int capacity)
		{
			init(countCapacity(capacity));
		}

		public long getFreeValue()
		{
			return _freeValue;
		}

		public long[] getKeys()
		{
			return _set;
		}

		public V[] getValues()
		{
			return _values;
		}

		protected override void init(int capacity)
		{
			_capacity=capacity;

			_set=new long[capacity<<1];

			if(_freeValue!=0)
			{
				ObjectUtils.arrayFill(_set,_freeValue);
			}

			_values=new V[capacity<<1];
		}

		private int index(long key)
		{
			long free;
			if(key!=(free=_freeValue))
			{
				long[] keys=_set;
				int capacityMask;
				int index;
				long cur;
				if((cur=keys[(index=(hashLong(key)) & (capacityMask=(keys.Length) - 1))])==key)
				{
					return index;
				}
				else
				{
					if(cur==free)
					{
						return -1;
					}
					else
					{
						while(true)
						{
							if((cur=keys[(index=(index - 1) & capacityMask)])==key)
							{
								return index;
							}
							else if(cur==free)
							{
								return -1;
							}
						}
					}
				}
			}
			else
			{
				return -1;
			}
		}

		private long findNewFreeOrRemoved()
		{
			long free=_freeValue;

			int newFree;
			{
				do
				{
					newFree=MathUtils.randomInt();
				}
				while((newFree==free) || ((index(newFree))>=0));
			}

			return newFree;
		}

		private long changeFree()
		{
			long newFree=findNewFreeOrRemoved();

			ObjectUtils.arrayReplace(_set,_freeValue,newFree);

			_freeValue=newFree;
			return newFree;
		}

		protected override int toGetLastFreeIndex()
		{
			long free=_freeValue;
			long[] keys=_set;

			for(int i=keys.Length-1;i >= 0;--i)
			{
				if(keys[i]==free)
				{
					return i;
				}
			}

			getLastFreeIndexError();

			return -1;
		}

		protected override void rehash(int newCapacity)
		{
			++_version;
			long free=_freeValue;
			long[] keys=_set;
			V[] vals=_values;
			init(newCapacity);
			long[] newKeys=_set;
			int capacityMask=(newKeys.Length) - 1;
			V[] newVals=_values;
			for(int i=(keys.Length) - 1;i>=0;i--)
			{
				long key;
				if((key=keys[i])!=free)
				{
					int index;
					if((newKeys[(index=(hashLong(key)) & capacityMask)])!=free)
					{
						while(true)
						{
							if((newKeys[(index=(index - 1) & capacityMask)])==free)
							{
								break;
							}
						}
					}

					newKeys[index]=key;
					newVals[index]=vals[i];
				}
			}
		}

		private int insert(long key,V value)
		{
			long free;
			if(key==(free=_freeValue))
			{
				free=changeFree();
			}
			long[] keys=_set;
			int capacityMask;
			int index;
			long cur;

			if((cur=keys[(index=(hashLong(key)) & (capacityMask=(keys.Length) - 1))])!=free)
			{
				if(cur==key)
				{
					return index;
				}
				else
				{
					while(true)
					{
						if((cur=keys[(index=(index - 1) & capacityMask)])==free)
						{
							break;
						}
						else if(cur==key)
						{
							return index;
						}
					}
				}
			}

			keys[index]=key;
			_values[index]=value;
			postInsertHook(index);
			return -1;
		}

		public void put(long key,V value)
		{
			int index=insert(key,value);

			if(index<0)
			{
				return;
			}
			else
			{
				_values[index]=value;
				return;
			}
		}

		/** 是否存在 */
		public bool contains(long key)
		{
			if(_size==0)
				return false;

			return index(key)>=0;
		}

		public V get(long key)
		{
			if(_size==0)
				return default(V);

			int idx=index(key);
			if(idx>=0)
			{
				return _values[idx];
			}
			else
			{
				return default(V);
			}
		}

		public V this[long key]
		{
			get {return this.get(key);}
			set {this.put(key,value);}
		}

		public V getOrDefault(long key,V defaultValue)
		{
			if(_size==0)
				return defaultValue;

			int idx=index(key);

			if(idx>=0)
			{
				return _values[idx];
			}
			else
			{
				return defaultValue;
			}
		}

		public V remove(long key)
		{
			if(_size==0)
				return default(V);

			long free;
			if(key!=(free=_freeValue))
			{
				long[] keys=_set;
				int capacityMask=(keys.Length) - 1;
				int index;
				long cur;

				if((cur=keys[(index=(hashLong(key)) & capacityMask)])!=key)
				{
					if(cur==free)
					{
						return default(V);
					}
					else
					{
						while(true)
						{
							if((cur=keys[(index=(index - 1) & capacityMask)])==key)
							{
								break;
							}
							else if(cur==free)
							{
								return default(V);
							}
						}
					}
				}

				V[] vals=_values;
				V val=vals[index];
				int indexToRemove=index;
				int indexToShift=indexToRemove;
				int shiftDistance=1;
				while(true)
				{
					indexToShift=(indexToShift - 1) & capacityMask;
					long keyToShift;
					if((keyToShift=keys[indexToShift])==free)
					{
						break;
					}

					if((((keyToShift) - indexToShift) & capacityMask)>=shiftDistance)
					{
						keys[indexToRemove]=keyToShift;
						vals[indexToRemove]=vals[indexToShift];
						indexToRemove=indexToShift;
						shiftDistance=1;
					}
					else
					{
						shiftDistance++;

						if(indexToShift==(1 + index))
						{
							Ctrl.throwError("不能在遍历中删除");
						}
					}
				}

				keys[indexToRemove]=free;
				vals[indexToRemove]=default(V);
				postRemoveHook(indexToRemove);

				return val;
			}
			else
			{
				return default(V);
			}
		}

		/** 清空 */
		public override void clear()
		{
			if(_size==0)
				return;

			base.clear();

			long fv=_freeValue;
			long[] set=_set;
			V[] values=_values;

			for(int i=set.Length - 1;i>=0;--i)
			{
				set[i]=fv;
				values[i]=default(V);
			}
		}

		/** 遍历并清空 */
		public void forEachValueAndClear(Action<V> consumer)
		{
			if(_size==0)
			{
				return;
			}

			justClearSize();

			long fv=_freeValue;
			long[] set=_set;
			V[] values=_values;

			for(int i=set.Length - 1;i >= 0;--i)
			{
				if(set[i]!=fv)
				{
					consumer(values[i]);
					set[i]=fv;
					values[i]=default(V);
				}
			}
		}

		public V putIfAbsent(long key,V value)
		{
			int index=insert(key,value);

			if(index<0)
			{
				return default(V);
			}
			else
			{
				return _values[index];
			}
		}

		public V computeIfAbsent(long key,Func<long,V> mappingFunction)
		{
			long free;
			if(key==(free=_freeValue))
			{
				free=changeFree();
			}
			long[] keys=_set;
			V[] vals=_values;
			int capacityMask;
			int index;
			long cur;

			if((cur=keys[(index=(hashLong(key)) & (capacityMask=(keys.Length) - 1))])!=key)
			{
				bool goOn=true;

				if(cur!=free)
				{
					while(true)
					{
						if((cur=keys[(index=(index - 1) & capacityMask)])==key)
						{
							goOn=false;
							break;
						}
						else if(cur==free)
						{
							break;
						}
					}
				}

				if(goOn)
				{
					V value=mappingFunction(key);

					if(value!=null)
					{
						keys[index]=key;
						vals[index]=value;
						postInsertHook(index);
						return value;
					}
					else
					{
						return default(V);
					}
				}
			}

			V val;

			if((val=vals[index])!=null)
			{
				return val;
			}
			else
			{
				V value=mappingFunction(key);
				if(value!=null)
				{
					vals[index]=value;
					return value;
				}
				else
				{
					return default(V);
				}
			}
		}

		public void putAll(LongObjectMap<V> dic)
		{
			if(dic.isEmpty())
				return;

			long[] keys=dic.getKeys();
			V[] values=dic.getValues();
			long fv=dic.getFreeValue();
			long k;

			for(int i=keys.Length-1;i>=0;--i)
			{
				if((k=keys[i])!=fv)
				{
					put(k,values[i]);
				}
			}
		}

		public LongObjectMap<V> clone()
		{
			if(_size==0)
				return new LongObjectMap<V>();

			LongObjectMap<V> re=new LongObjectMap<V>(capacity());
			//双拷贝
			Array.Copy(_set,0,re._set,0,_set.Length);
			Array.Copy(_values,0,re._values,0,_values.Length);
			re.copyBase(this);
			re._freeValue=_freeValue;

			return re;
		}

		/** 获取key对应set */
		public LongSet getKeySet()
		{
			if(_size==0)
				return new LongSet();

			LongSet re=new LongSet(capacity());
			re.copyBase(this);
			re.setFreeValue(_freeValue);
			Array.Copy(_set,0,re.getKeys(),0,_set.Length);
			return re;
		}

		/** 获取排序好的List */
		public LongList getSortedKeyList()
		{
			LongList list=new LongList(size());

			if(_size==0)
				return list;

			long[] values=list.getValues();
			int j=0;

			long free=_freeValue;
			long[] keys=_set;
			for(int i=(keys.Length) - 1;i >= 0;--i)
			{
				long key;
				if((key=keys[i])!=free)
				{
					values[j++]=key;
				}
			}

			list.justSetSize(size());

			list.sort();

			return list;
		}

		/** 转化为原生集合 */
		public Dictionary<long,V> toNatureMap()
		{
			Dictionary<long,V> re=new Dictionary<long,V>(size());

			long free=_freeValue;
			long[] keys=_set;
			V[] vals=_values;
			for(int i=(keys.Length) - 1;i >= 0;--i)
			{
				long key;
				if((key=keys[i])!=free)
				{
					re.Add(key,vals[i]);
				}
			}

			return re;
		}

		public void addAll(Dictionary<long,V> map)
		{
			ensureCapacity(map.Count);

			foreach(KeyValuePair<long,V> kv in map)
			{
				this.put(kv.Key,kv.Value);
			}
		}

		/** 遍历 */
		public void forEach(Action<long,V> consumer)
		{
			if(_size==0)
				return;

			int version=_version;
			long free=_freeValue;
			long[] keys=_set;
			V[] vals=_values;
			for(int i=(keys.Length) - 1;i>=0;--i)
			{
				long key;
				if((key=keys[i])!=free)
				{
					consumer(key,vals[i]);
				}
			}

			if(version!=_version)
			{
				Ctrl.throwError("ForeachModificationException");
			}
		}

		/** 可修改遍历 */
		public void forEachS(Action<long,V> consumer)
		{
			if(_size==0)
				return;

			long free=_freeValue;
			long[] keys=_set;
			V[] vals=_values;
			long key;
			int safeIndex=getLastFreeIndex();

			for(int i=safeIndex-1;i>=0;--i)
			{
				if((key=keys[i])!=free)
				{
					consumer(key,vals[i]);

					if(key!=keys[i])
					{
						++i;
					}
				}
			}

			for(int i=keys.Length-1;i>safeIndex;--i)
			{
				if((key=keys[i])!=free)
				{
					consumer(key,vals[i]);

					if(key!=keys[i])
					{
						++i;
					}
				}
			}
		}

		/** 遍历值(null的不传) */
		public void forEachValue(Action<V> consumer)
		{
			if(_size==0)
				return;

			int version=_version;
			V[] vals=_values;
			V v;
			for(int i=vals.Length - 1;i>=0;--i)
			{
				if((v=vals[i])!=null)
				{
					consumer(v);
				}
			}

			if(version!=_version)
			{
				Ctrl.throwError("ForeachModificationException");
			}
		}

		/** 可修改遍历值 */
		public void forEachValueS(Action<V> consumer)
		{
			if(_size==0)
				return;

			long free=_freeValue;
			long[] keys=_set;
			V[] vals=_values;
			long key;
			int safeIndex=getLastFreeIndex();

			for(int i=safeIndex-1;i>=0;--i)
			{
				if((key=keys[i])!=free)
				{
					consumer(vals[i]);

					if(key!=keys[i])
					{
						++i;
					}
				}
			}

			for(int i=keys.Length-1;i>safeIndex;--i)
			{
				if((key=keys[i])!=free)
				{
					consumer(vals[i]);

					if(key!=keys[i])
					{
						++i;
					}
				}
			}
		}

		/** 获取值组 */
		public SList<V> getValueList()
		{
			SList<V> list=new SList<V>(_size);

			if(_size==0)
				return list;

			V[] vals=_values;
			V v;
			for(int i=vals.Length - 1;i>=0;--i)
			{
				if((v=vals[i])!=null)
				{
					list.add(v);
				}
			}

			return list;
		}

		/** 获取值数组 */
		public V[] getValueArr()
		{
			V[] re=new V[_size];

			if(_size==0)
				return re;

			int j=0;

			V[] vals=_values;
			V v;
			for(int i=vals.Length - 1;i>=0;--i)
			{
				if((v=vals[i])!=null)
				{
					re[j++]=v;
				}
			}

			return re;
		}

		public ForEachIterator GetEnumerator()
		{
			return new ForEachIterator(this);
		}

		IEnumerator<V> IEnumerable<V>.GetEnumerator()
		{
			return new ForEachIterator(this);
		}

		IEnumerator IEnumerable.GetEnumerator()
		{
			return new ForEachIterator(this);
		}

		public struct ForEachIterator:IEnumerator<V>
		{
			private int _index;
			private int _tSafeIndex;

			private long _tFv;
			private long[] _tSet;
			private V[] _tValues;

			private long _k;
			private V _v;

			public ForEachIterator(LongObjectMap<V> map)
			{
				_index=_tSafeIndex=map.getLastFreeIndex();
				if(map._size==0)
					_index=_tSafeIndex+1;

				_tSet=map._set;
				_tValues=map._values;
				_v=default(V);
				_k=_tFv=map._freeValue;
			}

			public void Reset()
			{
			}

			public void Dispose()
			{
			}

			public bool MoveNext()
			{
				if(_k!=_tFv && _k!=_tSet[_index])
				{
					++_index;
				}

				long key;

				if(_index<=_tSafeIndex)
				{
					while(--_index >= 0)
					{
						if((key=_tSet[_index])!=_tFv)
						{
							_k=key;
							_v=_tValues[_index];
							return true;
						}
					}

					_k=_tFv;
					_index=_tSet.Length;
					return MoveNext();
				}
				else
				{
					while(--_index > _tSafeIndex)
					{
						if((key=_tSet[_index])!=_tFv)
						{
							_k=key;
							_v=_tValues[_index];
							return true;
						}
					}

					_v=default(V);
					return false;
				}
			}

			public V Current
			{
				get {return _v;}
			}

			object IEnumerator.Current
			{
				get {return _v;}
			}
		}

		public EntrySet entrySet()
		{
			if(_entrySet!=null)
				return _entrySet;

			return _entrySet=new EntrySet(this);
		}

		public struct Entry<V>
		{
			public long key;
			public V value;
		}

		public class EntrySet:IEnumerable<Entry<V>>
		{
			private LongObjectMap<V> _map;

			public EntrySet(LongObjectMap<V> map)
			{
				_map=map;
			}

			public EntryIterator GetEnumerator()
			{
				return new EntryIterator(_map);
			}

			IEnumerator<Entry<V>> IEnumerable<Entry<V>>.GetEnumerator()
			{
				return new EntryIterator(_map);
			}

			IEnumerator IEnumerable.GetEnumerator()
			{
				return new EntryIterator(_map);
			}
		}

		public struct EntryIterator:IEnumerator<Entry<V>>
		{
			private int _index;
			private int _tSafeIndex;

			private long _tFv;
			private long[] _tSet;
			private V[] _tValues;
			private Entry<V> _entry;

			public EntryIterator(LongObjectMap<V> map)
			{
				_index=_tSafeIndex=map.getLastFreeIndex();
				if(map._size==0)
					_index=_tSafeIndex+1;

				_tSet=map._set;
				_tValues=map._values;
				_entry=new Entry<V>();
				_entry.key=_tFv=map._freeValue;
			}

			public void Reset()
			{
			}

			public void Dispose()
			{
			}

			public bool MoveNext()
			{
				if(_entry.key!=_tFv && _entry.key!=_tSet[_index])
				{
					++_index;
				}

				long key;

				if(_index<=_tSafeIndex)
				{
					while(--_index >= 0)
					{
						if((key=_tSet[_index])!=_tFv)
						{
							_entry.key=key;
							_entry.value=_tValues[_index];
							return true;
						}
					}

					_entry.key=_tFv;
					_index=_tSet.Length;
					return MoveNext();
				}
				else
				{
					while(--_index > _tSafeIndex)
					{
						if((key=_tSet[_index])!=_tFv)
						{
							_entry.key=key;
							_entry.value=_tValues[_index];
							return true;
						}
					}

					_entry.value=default(V);
					return false;
				}
			}

			public Entry<V> Current
			{
				get {return _entry;}
			}

			object IEnumerator.Current
			{
				get {return _entry;}
			}
		}
	}
}