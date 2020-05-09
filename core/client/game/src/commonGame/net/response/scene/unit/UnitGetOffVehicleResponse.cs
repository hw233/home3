using ShineEngine;

/// <summary>
/// 单位下载具消息(generated by shine)
/// </summary>
public class UnitGetOffVehicleResponse:UnitSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.UnitGetOffVehicle;
	
	/// <summary>
	/// 位置
	/// </summary>
	public PosData pos;
	
	public UnitGetOffVehicleResponse()
	{
		_dataID=GameResponseType.UnitGetOffVehicle;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitGetOffVehicleResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.pos=(PosData)stream.createData(PosData.dataID);
		this.pos.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.pos=(PosData)stream.createData(PosData.dataID);
		this.pos.readBytesSimple(stream);
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
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
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		unit.move.onGetOffVehicle(pos);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.pos=null;
	}
	
}
