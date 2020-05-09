package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.constlist.generate.ClientRandomSeedType;
import com.home.commonBase.constlist.generate.RandomItemListType;
import com.home.commonBase.data.item.ItemData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.global.CommonSetting;
import com.home.commonBase.logic.LogicEntity;
import com.home.commonBase.tool.func.RandomWeightTool;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SList;
import com.home.shine.utils.MathUtils;

/** 随机物品组配置(generated by shine) */
public class RandomItemListConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<RandomItemListConfig> _dic;
	
	/** id */
	public int id;
	
	/** 类型 */
	public int type;
	
	/** 种子随机类型 */
	public int seedType;
	
	/** 参数组 */
	public int[][] args;
	
	/** 权重随机插件 */
	private RandomWeightTool _weightTool;
	
	/** 是否统计过 */
	private boolean _counted=false;
	
	/** 需要格子数 */
	protected int _needGridNum=0;
	
	/** 获取 */
	public static RandomItemListConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<RandomItemListConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<RandomItemListConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.type=stream.readInt();
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.length!=argsLen)
		{
			this.args=new int[argsLen][];
		}
		int[][] argsT=this.args;
		for(int argsI=0;argsI<argsLen;++argsI)
		{
			int[] argsV;
			int argsVLen=stream.readLen();
			argsV=new int[argsVLen];
			int[] argsVT=argsV;
			for(int argsVI=0;argsVI<argsVLen;++argsVI)
			{
				int argsVV;
				argsVV=stream.readInt();
				
				argsVT[argsVI]=argsVV;
			}
			
			argsT[argsI]=argsV;
		}
		
		this.seedType=stream.readInt();
		
	}
	
	/** 读完表后处理 */
	@Override
	protected void afterReadConfig()
	{
		super.afterReadConfig();
		
		switch(type)
		{
			case RandomItemListType.WeightRandomList:
			{
				_weightTool=new RandomWeightTool(args);
			}
				break;
		}
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		if(_dic==null)
			return;
		
		RandomItemListConfig[] values;
		RandomItemListConfig v;
		
		for(int i=(values=_dic.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				switch(v.type)
				{
					case RandomItemListType.SingleItem:
					{
						int itemID=v.args[0][0];
						if(itemID>0 && ItemConfig.get(itemID)==null)
						{
							Ctrl.throwError("找不到物品ID",itemID);
							return;
						}
					}
						break;
					case RandomItemListType.SingleRandomItem:
					{
						int randomItemID=v.args[0][0];
						
						if(randomItemID>0 && RandomItemConfig.get(randomItemID)==null)
						{
							Ctrl.throwError("找不到随机物品ID",randomItemID);
							return;
						}
					}
						break;
					case RandomItemListType.SumProbRandomItem:
					{
						for(int[] v2:v.args)
						{
							if(v2[1]>0 && RandomItemConfig.get(v2[1])==null)
							{
								Ctrl.throwError("找不到随机物品ID",v2[1]);
								return;
							}
						}
					}
						break;
					case RandomItemListType.WeightRandomList:
					{
						for(int[] v2:v.args)
						{
							if(v2[1]>0 && RandomItemListConfig.get(v2[1])==null)
							{
								Ctrl.throwError("找不到随机物品组ID",v2[1]);
								return;
							}
						}
					}
						break;
				}
				
				//直接算出统计
				v.getNeedGridNum();
			}
		}
	}
	
	/** 获取所占格子数 */
	public int getNeedGridNum()
	{
		if(!_counted)
		{
			_counted=true;
			
			toCountGridNum();
		}
		
		return _needGridNum;
	}
	
	/** 统计占用格子数目 */
	protected void toCountGridNum()
	{
		switch(type)
		{
			case RandomItemListType.SingleItem:
			{
				if(args[0][0]>0)
				{
					_needGridNum=1;
				}
			}
				break;
			case RandomItemListType.SingleRandomItem:
			{
				if(args[0][0]>0)
				{
					_needGridNum=1;
				}
			}
				break;
			case RandomItemListType.SumProbRandomItem:
			{
				_needGridNum=args.length;
			}
				break;
			case RandomItemListType.WeightRandomList:
			{
				int max=0;
				int temp;
				
				for(int[] v:args)
				{
					if((temp=get(v[1]).getNeedGridNum())>max)
					{
						max=temp;
					}
				}
				
				_needGridNum=max;
				
			}
				break;
		}
	}
	
	/** 随机一组物品 */
	public void randomList(SList<ItemData> list,LogicEntity entity)
	{
		//list 不需要在这里clear ，最外层调用者负责维护
		if (seedType == ClientRandomSeedType.Client)
		{
			Ctrl.throwError("此随机组不支持服务器随机");
			return;
		}

		if (seedType == ClientRandomSeedType.Seed && !CommonSetting.needClientRandomSeeds)
		{
			Ctrl.throwError("此随机组模式需要开启客户端随机种子模式");
			return;
		}

		switch(type)
		{
			case RandomItemListType.SingleItem:
			{
				int[] arr=args[0];
				
				if(arr[0]>0)
				{
					list.add(BaseC.logic.createItem(arr[0],arr.length>1 ? arr[1] : 1,entity));
				}
			}
				break;
			case RandomItemListType.SingleRandomItem:
			{
				int[] arr=args[0];
				
				if(arr[0]>0)
				{
					ItemData data=RandomItemConfig.get(arr[0]).randomOne(entity,seedType);
					
					if(data!=null)
					{
						data.num*=(arr.length>1 ? arr[1] : 1);
						
						list.add(data);
					}
				}
			}
				break;
			case RandomItemListType.SumProbRandomItem:
			{
				for(int[] arr:args)
				{
					boolean randomProb = false;

					//万分位
					if (seedType == ClientRandomSeedType.Server)
						randomProb = MathUtils.randomProb(arr[0], 10000);
					else
						randomProb = entity.randomProb(arr[0], 10000);

					//万分位
					if(randomProb)
					{
						ItemData data=RandomItemConfig.get(arr[1]).randomOne(entity,seedType);
						
						if(data!=null)
						{
							int min=arr.length>2 ? arr[2] : 1;
							int max=arr.length>3 ? arr[3] : min;
							
							if(min==max)
							{
								data.num*=min;
							}
							else
							{
								if (seedType == ClientRandomSeedType.Server)
									data.num*=MathUtils.randomRange2(min,max);
								else
									data.num*=entity.randomRange2(min,max);
							}
							
							list.add(data);
						}
					}
				}
			}
				break;
			case RandomItemListType.WeightRandomList:
			{
				int[] arr=_weightTool.randomForIntArr(entity,seedType);
				
				if(arr!=null && arr[1]>0)
				{
					get(arr[1]).randomList(list,entity);
				}
			}
				break;
		}
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.type);
		
		if(this.args!=null)
		{
			int[][] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				int[] argsV=argsT[argsVI];
				if(argsV!=null)
				{
					int[] argsVT=argsV;
					stream.writeLen(argsVT.length);
					for(int argsVVI=0,argsVVLen=argsVT.length;argsVVI<argsVVLen;++argsVVI)
					{
						int argsVV=argsVT[argsVVI];
						stream.writeInt(argsVV);
						
					}
				}
				else
				{
					nullObjError("argsV");
				}
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
		stream.writeInt(this.seedType);
		
	}
	
}
