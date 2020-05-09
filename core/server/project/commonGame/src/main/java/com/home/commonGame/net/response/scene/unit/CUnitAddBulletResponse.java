package com.home.commonGame.net.response.scene.unit;
import com.home.commonBase.data.scene.base.BulletData;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.CUnitRResponse;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端主控单位添加子弹(generated by shine) */
public class CUnitAddBulletResponse extends CUnitRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitAddBullet;
	
	/** 子弹数据 */
	public BulletData bullet;
	
	public CUnitAddBulletResponse()
	{
		_dataID=GameResponseType.CUnitAddBullet;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		//不给自己广播
		unit.fight.addBullet(bullet,true,false);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitAddBulletResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData bulletT=stream.readDataFullNotNull();
		if(bulletT!=null)
		{
			if(bulletT instanceof BulletData)
			{
				this.bullet=(BulletData)bulletT;
			}
			else
			{
				this.bullet=new BulletData();
				if(!(bulletT.getClass().isAssignableFrom(BulletData.class)))
				{
					stream.throwTypeReadError(BulletData.class,bulletT.getClass());
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
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.bullet=(BulletData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("bullet");
		writer.sb.append(':');
		if(this.bullet!=null)
		{
			this.bullet.writeDataString(writer);
		}
		else
		{
			writer.sb.append("BulletData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.bullet=null;
	}
	
}
