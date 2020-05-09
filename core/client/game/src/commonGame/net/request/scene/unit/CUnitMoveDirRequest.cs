using ShineEngine;

/// <summary>
/// 客户端单位朝向移动消息(generated by shine)
/// </summary>
public class CUnitMoveDirRequest:CUnitRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.CUnitMoveDir;
	
	/// <summary>
	/// 移动类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 当前位置
	/// </summary>
	public PosData pos;
	
	/// <summary>
	/// 实际移动方向
	/// </summary>
	public DirData realDir;
	
	/// <summary>
	/// 实际速度比率
	/// </summary>
	public int realSpeedRatio=-1;
	
	/// <summary>
	/// 目标朝向
	/// </summary>
	public DirData dir;
	
	public CUnitMoveDirRequest()
	{
		_dataID=GameRequestType.CUnitMoveDir;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CUnitMoveDirRequest";
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
		writer.sb.Append("pos");
		writer.sb.Append(':');
		if(this.pos!=null)
		{
			this.pos.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("PosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("dir");
		writer.sb.Append(':');
		if(this.dir!=null)
		{
			this.dir.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("DirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("realDir");
		writer.sb.Append(':');
		if(this.realDir!=null)
		{
			this.realDir.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("DirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("realSpeedRatio");
		writer.sb.Append(':');
		writer.sb.Append(this.realSpeedRatio);
		
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
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			this.pos.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.dir!=null)
		{
			this.dir.writeBytesFull(stream);
		}
		else
		{
			nullObjError("dir");
		}
		
		if(this.realDir!=null)
		{
			stream.writeBoolean(true);
			this.realDir.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.realSpeedRatio);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.type);
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			this.pos.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.dir!=null)
		{
			this.dir.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("dir");
		}
		
		if(this.realDir!=null)
		{
			stream.writeBoolean(true);
			this.realDir.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.realSpeedRatio);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.type=0;
		if(this.pos!=null)
		{
			this.pos.release(pool);
			this.pos=null;
		}
		this.dir.release(pool);
		this.dir=null;
		if(this.realDir!=null)
		{
			this.realDir.release(pool);
			this.realDir=null;
		}
		this.realSpeedRatio=0;
	}
	
	protected override void copyData()
	{
		base.copyData();
		PosData posTemp=pos;
		if(posTemp!=null)
		{
			this.pos=(PosData)BytesControl.createData(PosData.dataID);
			this.pos.copy(posTemp);
		}
		else
		{
			this.pos=null;
		}
		
		DirData dirTemp=dir;
		if(dirTemp!=null)
		{
			this.dir=(DirData)BytesControl.createData(DirData.dataID);
			this.dir.copy(dirTemp);
		}
		else
		{
			this.dir=null;
			nullObjError("dir");
		}
		
		DirData realDirTemp=realDir;
		if(realDirTemp!=null)
		{
			this.realDir=(DirData)BytesControl.createData(DirData.dataID);
			this.realDir.copy(realDirTemp);
		}
		else
		{
			this.realDir=null;
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static CUnitMoveDirRequest create(int instanceID,int type,PosData pos,DirData dir,DirData realDir,int realSpeedRatio)
	{
		CUnitMoveDirRequest re=(CUnitMoveDirRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.type=type;
		re.pos=pos;
		re.dir=dir;
		re.realDir=realDir;
		re.realSpeedRatio=realSpeedRatio;
		return re;
	}
	
}
