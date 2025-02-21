using ShineEngine;

/// <summary>
/// 单位发出子弹消息(generated by shine)
/// </summary>
public class AddBulletResponse:UnitSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=SceneBaseResponseType.AddBullet;
	
	/// <summary>
	/// 子弹数据
	/// </summary>
	public BulletData bullet;
	
	public AddBulletResponse()
	{
		_dataID=SceneBaseResponseType.AddBullet;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		unit.fight.addBullet(bullet);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "AddBulletResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData bulletT=stream.readDataFullNotNull();
		if(bulletT!=null)
		{
			if(bulletT is BulletData)
			{
				this.bullet=(BulletData)bulletT;
			}
			else
			{
				this.bullet=new BulletData();
				if(!(bulletT.GetType().IsAssignableFrom(typeof(BulletData))))
				{
					stream.throwTypeReadError(typeof(BulletData),bulletT.GetType());
				}
				this.bullet.shadowCopy(bulletT);
			}
		}
		else
		{
			this.bullet=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.bullet=(BulletData)stream.readDataSimpleNotNull();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("bullet");
		writer.sb.Append(':');
		if(this.bullet!=null)
		{
			this.bullet.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("BulletData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.bullet=null;
	}
	
}
