using ShineEngine;

/// <summary>
/// 单位移动点组消息(generated by shine)
/// </summary>
public class UnitMovePosListResponse:UnitSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=SceneBaseResponseType.UnitMovePosList;
	
	/// <summary>
	/// 移动类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 服务器首点移动时间(同步用)
	/// </summary>
	public int moveTime;
	
	/// <summary>
	/// 位置组
	/// </summary>
	public SList<PosData> targets;
	
	public UnitMovePosListResponse()
	{
		_dataID=SceneBaseResponseType.UnitMovePosList;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		unit.move.onServerMovePosList(type,targets,moveTime);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitMovePosListResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.type=stream.readInt();
		
		int targetsLen=stream.readLen();
		if(this.targets!=null)
		{
			this.targets.clear();
			this.targets.ensureCapacity(targetsLen);
		}
		else
		{
			this.targets=new SList<PosData>();
		}
		
		SList<PosData> targetsT=this.targets;
		for(int targetsI=targetsLen-1;targetsI>=0;--targetsI)
		{
			PosData targetsV;
			targetsV=(PosData)stream.createData(PosData.dataID);
			targetsV.readBytesFull(stream);
			
			targetsT.add(targetsV);
		}
		
		this.moveTime=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.type=stream.readInt();
		
		int targetsLen=stream.readLen();
		if(this.targets!=null)
		{
			this.targets.clear();
			this.targets.ensureCapacity(targetsLen);
		}
		else
		{
			this.targets=new SList<PosData>();
		}
		
		SList<PosData> targetsT=this.targets;
		for(int targetsI=targetsLen-1;targetsI>=0;--targetsI)
		{
			PosData targetsV;
			targetsV=(PosData)stream.createData(PosData.dataID);
			targetsV.readBytesSimple(stream);
			
			targetsT.add(targetsV);
		}
		
		this.moveTime=stream.readInt();
		
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
		writer.writeTabs();
		writer.sb.Append("moveTime");
		writer.sb.Append(':');
		writer.sb.Append(this.moveTime);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.type=0;
		this.targets=null;
		this.moveTime=0;
	}
	
}
