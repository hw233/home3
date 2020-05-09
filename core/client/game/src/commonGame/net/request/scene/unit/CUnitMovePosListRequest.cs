using ShineEngine;

/// <summary>
/// 客户端单位移动到点组消息(generated by shine)
/// </summary>
public class CUnitMovePosListRequest:CUnitRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.CUnitMovePosList;
	
	/// <summary>
	/// 移动类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 当前位置
	/// </summary>
	public PosData nowPos;
	
	/// <summary>
	/// 位置组
	/// </summary>
	public SList<PosData> targets;
	
	public CUnitMovePosListRequest()
	{
		_dataID=GameRequestType.CUnitMovePosList;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CUnitMovePosListRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("nowPos");
		writer.sb.Append(':');
		if(this.nowPos!=null)
		{
			this.nowPos.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("PosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("targets");
		writer.sb.Append(':');
		writer.sb.Append("List<PosData>");
		if(this.targets!=null)
		{
			SList<PosData> targetsT=this.targets;
			int targetsLen=targetsT.size();
			writer.sb.Append('(');
			writer.sb.Append(targetsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int targetsI=0;targetsI<targetsLen;++targetsI)
			{
				PosData targetsV=targetsT.get(targetsI);
				writer.writeTabs();
				writer.sb.Append(targetsI);
				writer.sb.Append(':');
				if(targetsV!=null)
				{
					targetsV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("PosData=null");
				}
				
				writer.writeEnter();
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
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.type);
		
		if(this.nowPos!=null)
		{
			stream.writeBoolean(true);
			this.nowPos.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.targets!=null)
		{
			stream.writeLen(this.targets.size());
			if(!this.targets.isEmpty())
			{
				PosData[] targetsVValues=this.targets.getValues();
				for(int targetsVI=0,targetsVLen=this.targets.length();targetsVI<targetsVLen;++targetsVI)
				{
					PosData targetsV=targetsVValues[targetsVI];
					if(targetsV!=null)
					{
						targetsV.writeBytesFull(stream);
					}
					else
					{
						nullObjError("targetsV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("targets");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.type);
		
		if(this.nowPos!=null)
		{
			stream.writeBoolean(true);
			this.nowPos.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.targets!=null)
		{
			stream.writeLen(this.targets.size());
			if(!this.targets.isEmpty())
			{
				PosData[] targetsVValues=this.targets.getValues();
				for(int targetsVI=0,targetsVLen=this.targets.length();targetsVI<targetsVLen;++targetsVI)
				{
					PosData targetsV=targetsVValues[targetsVI];
					if(targetsV!=null)
					{
						targetsV.writeBytesSimple(stream);
					}
					else
					{
						nullObjError("targetsV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("targets");
		}
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.type=0;
		if(this.nowPos!=null)
		{
			this.nowPos.release(pool);
			this.nowPos=null;
		}
		if(this.targets!=null)
		{
			if(!this.targets.isEmpty())
			{
				PosData[] targetsVValues=this.targets.getValues();
				for(int targetsVI=0,targetsVLen=this.targets.length();targetsVI<targetsVLen;++targetsVI)
				{
					PosData targetsV=targetsVValues[targetsVI];
					targetsV.release(pool);
					targetsV=null;
					targetsVValues[targetsVI]=null;
				}
			}
			this.targets.justClearSize();
		}
	}
	
	protected override void copyData()
	{
		base.copyData();
		PosData nowPosTemp=nowPos;
		if(nowPosTemp!=null)
		{
			this.nowPos=(PosData)BytesControl.createData(PosData.dataID);
			this.nowPos.copy(nowPosTemp);
		}
		else
		{
			this.nowPos=null;
		}
		
		SList<PosData> targetsTemp=targets;
		if(targetsTemp!=null)
		{
			this.targets=new SList<PosData>();
			SList<PosData> targetsT=this.targets;
			if(!targetsTemp.isEmpty())
			{
				PosData[] targetsVValues=targetsTemp.getValues();
				for(int targetsVI=0,targetsVLen=targetsTemp.length();targetsVI<targetsVLen;++targetsVI)
				{
					PosData targetsV=targetsVValues[targetsVI];
					PosData targetsU;
					if(targetsV!=null)
					{
						targetsU=(PosData)BytesControl.createData(PosData.dataID);
						targetsU.copy(targetsV);
					}
					else
					{
						targetsU=null;
						nullObjError("targetsU");
					}
					
					targetsT.add(targetsU);
				}
			}
		}
		else
		{
			this.targets=null;
			nullObjError("targets");
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static CUnitMovePosListRequest create(int instanceID,int type,PosData nowPos,SList<PosData> targets)
	{
		CUnitMovePosListRequest re=(CUnitMovePosListRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.type=type;
		re.nowPos=nowPos;
		re.targets=targets;
		return re;
	}
	
}
