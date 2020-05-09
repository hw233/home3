using ShineEngine;

/// <summary>
/// 主角加buff(generated by shine)
/// </summary>
public class MUnitAddBuffResponse:MUnitSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.MUnitAddBuff;
	
	/// <summary>
	/// buff数据
	/// </summary>
	public BuffData buff;
	
	public MUnitAddBuffResponse()
	{
		_dataID=GameResponseType.MUnitAddBuff;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		mLogic.getFightLogic().buff.addBuffByServer(buff);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "MUnitAddBuffResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData buffT=stream.readDataFullNotNull();
		if(buffT!=null)
		{
			if(buffT is BuffData)
			{
				this.buff=(BuffData)buffT;
			}
			else
			{
				this.buff=new BuffData();
				if(!(buffT.GetType().IsAssignableFrom(typeof(BuffData))))
				{
					stream.throwTypeReadError(typeof(BuffData),buffT.GetType());
				}
				this.buff.shadowCopy(buffT);
			}
		}
		else
		{
			this.buff=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.buff=(BuffData)stream.readDataSimpleNotNull();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("buff");
		writer.sb.Append(':');
		if(this.buff!=null)
		{
			this.buff.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("BuffData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.buff=null;
	}
	
}
