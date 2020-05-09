using ShineEngine;

/// <summary>
/// 功能-回复查询每页排行(generated by shine)
/// </summary>
public class FuncReGetPageShowResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncReGetPageShow;
	
	/// <summary>
	/// 参数
	/// </summary>
	public int arg;
	
	/// <summary>
	/// 页码
	/// </summary>
	public int page;
	
	/// <summary>
	/// 数据组
	/// </summary>
	public IntObjectMap<KeyData> dic;
	
	/// <summary>
	/// 改变页码组
	/// </summary>
	public IntSet changePageSet;
	
	public FuncReGetPageShowResponse()
	{
		_dataID=GameResponseType.FuncReGetPageShow;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.func.getPageShowTool(funcID).onReceivePage(page,dic,changePageSet);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncReGetPageShowResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.page=stream.readInt();
		
		this.arg=stream.readInt();
		
		if(stream.readBoolean())
		{
			int dicLen=stream.readLen();
			if(this.dic!=null)
			{
				this.dic.clear();
				this.dic.ensureCapacity(dicLen);
			}
			else
			{
				this.dic=new IntObjectMap<KeyData>(dicLen);
			}
			
			IntObjectMap<KeyData> dicT=this.dic;
			for(int dicI=dicLen-1;dicI>=0;--dicI)
			{
				int dicK;
				KeyData dicV;
				dicK=stream.readInt();
				
				if(stream.readBoolean())
				{
					BaseData dicVT=stream.readDataFullNotNull();
					if(dicVT!=null)
					{
						if(dicVT is KeyData)
						{
							dicV=(KeyData)dicVT;
						}
						else
						{
							dicV=new KeyData();
							if(!(dicVT.GetType().IsAssignableFrom(typeof(KeyData))))
							{
								stream.throwTypeReadError(typeof(KeyData),dicVT.GetType());
							}
							dicV.shadowCopy(dicVT);
						}
					}
					else
					{
						dicV=null;
					}
				}
				else
				{
					dicV=null;
				}
				
				dicT.put(dicK,dicV);
			}
		}
		else
		{
			this.dic=null;
		}
		
		if(stream.readBoolean())
		{
			int changePageSetLen=stream.readLen();
			if(this.changePageSet!=null)
			{
				this.changePageSet.clear();
				this.changePageSet.ensureCapacity(changePageSetLen);
			}
			else
			{
				this.changePageSet=new IntSet();
			}
			
			IntSet changePageSetT=this.changePageSet;
			for(int changePageSetI=changePageSetLen-1;changePageSetI>=0;--changePageSetI)
			{
				int changePageSetV;
				changePageSetV=stream.readInt();
				
				changePageSetT.add(changePageSetV);
			}
		}
		else
		{
			this.changePageSet=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.page=stream.readInt();
		
		this.arg=stream.readInt();
		
		if(stream.readBoolean())
		{
			int dicLen=stream.readLen();
			if(this.dic!=null)
			{
				this.dic.clear();
				this.dic.ensureCapacity(dicLen);
			}
			else
			{
				this.dic=new IntObjectMap<KeyData>(dicLen);
			}
			
			IntObjectMap<KeyData> dicT=this.dic;
			for(int dicI=dicLen-1;dicI>=0;--dicI)
			{
				int dicK;
				KeyData dicV;
				dicK=stream.readInt();
				
				if(stream.readBoolean())
				{
					dicV=(KeyData)stream.readDataSimpleNotNull();
				}
				else
				{
					dicV=null;
				}
				
				dicT.put(dicK,dicV);
			}
		}
		else
		{
			this.dic=null;
		}
		
		if(stream.readBoolean())
		{
			int changePageSetLen=stream.readLen();
			if(this.changePageSet!=null)
			{
				this.changePageSet.clear();
				this.changePageSet.ensureCapacity(changePageSetLen);
			}
			else
			{
				this.changePageSet=new IntSet();
			}
			
			IntSet changePageSetT=this.changePageSet;
			for(int changePageSetI=changePageSetLen-1;changePageSetI>=0;--changePageSetI)
			{
				int changePageSetV;
				changePageSetV=stream.readInt();
				
				changePageSetT.add(changePageSetV);
			}
		}
		else
		{
			this.changePageSet=null;
		}
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("page");
		writer.sb.Append(':');
		writer.sb.Append(this.page);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("arg");
		writer.sb.Append(':');
		writer.sb.Append(this.arg);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("dic");
		writer.sb.Append(':');
		writer.sb.Append("Map<int,KeyData>");
		if(this.dic!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.dic.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.dic.isEmpty())
			{
				int dicKFreeValue=this.dic.getFreeValue();
				int[] dicKKeys=this.dic.getKeys();
				KeyData[] dicVValues=this.dic.getValues();
				for(int dicKI=dicKKeys.Length-1;dicKI>=0;--dicKI)
				{
					int dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						KeyData dicV=dicVValues[dicKI];
						writer.writeTabs();
						writer.sb.Append(dicK);
						
						writer.sb.Append(':');
						if(dicV!=null)
						{
							dicV.writeDataString(writer);
						}
						else
						{
							writer.sb.Append("KeyData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("changePageSet");
		writer.sb.Append(':');
		writer.sb.Append("Set<int>");
		if(this.changePageSet!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.changePageSet.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.changePageSet.isEmpty())
			{
				int changePageSetVFreeValue=this.changePageSet.getFreeValue();
				int[] changePageSetVKeys=this.changePageSet.getKeys();
				for(int changePageSetVI=changePageSetVKeys.Length-1;changePageSetVI>=0;--changePageSetVI)
				{
					int changePageSetV=changePageSetVKeys[changePageSetVI];
					if(changePageSetV!=changePageSetVFreeValue)
					{
						writer.writeTabs();
						writer.sb.Append(changePageSetV);
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.page=0;
		this.arg=0;
		this.dic=null;
		this.changePageSet=null;
	}
	
}
