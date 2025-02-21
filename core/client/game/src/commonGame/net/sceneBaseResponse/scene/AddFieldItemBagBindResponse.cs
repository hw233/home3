using ShineEngine;

/// <summary>
/// 添加掉落物品包绑定消息(generated by shine)
/// </summary>
public class AddFieldItemBagBindResponse:SceneSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=SceneBaseResponseType.AddFieldItemBagBind;
	
	/// <summary>
	/// 掉落物品包绑定消息
	/// </summary>
	public FieldItemBagBindData data;
	
	public AddFieldItemBagBindResponse()
	{
		_dataID=SceneBaseResponseType.AddFieldItemBagBind;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "AddFieldItemBagBindResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT is FieldItemBagBindData)
			{
				this.data=(FieldItemBagBindData)dataT;
			}
			else
			{
				this.data=new FieldItemBagBindData();
				if(!(dataT.GetType().IsAssignableFrom(typeof(FieldItemBagBindData))))
				{
					stream.throwTypeReadError(typeof(FieldItemBagBindData),dataT.GetType());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.data=(FieldItemBagBindData)stream.readDataSimpleNotNull();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("data");
		writer.sb.Append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("FieldItemBagBindData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		scene.role.onAddFieldItemBagBindByServer(data);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.data=null;
	}
	
}
