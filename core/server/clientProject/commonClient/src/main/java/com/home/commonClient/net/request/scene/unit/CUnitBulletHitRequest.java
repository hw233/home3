package com.home.commonClient.net.request.scene.unit;
import com.home.commonBase.data.scene.fight.SkillTargetData;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.scene.base.CUnitRRequest;
import com.home.commonClient.net.request.scene.base.SceneRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端控制单位子弹命中(generated by shine) */
public class CUnitBulletHitRequest extends CUnitRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.CUnitBulletHit;
	
	/** 子弹ID */
	public int bulletID;
	
	/** 子弹等级 */
	public int bulletLevel;
	
	/** 目标 */
	public SkillTargetData target;
	
	public CUnitBulletHitRequest()
	{
		_dataID=GameRequestType.CUnitBulletHit;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SkillTargetData targetTemp=target;
		if(targetTemp!=null)
		{
			this.target=(SkillTargetData)targetTemp.clone();
		}
		else
		{
			this.target=null;
			nullObjError("target");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitBulletHitRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("bulletID");
		writer.sb.append(':');
		writer.sb.append(this.bulletID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("bulletLevel");
		writer.sb.append(':');
		writer.sb.append(this.bulletLevel);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("target");
		writer.sb.append(':');
		if(this.target!=null)
		{
			this.target.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SkillTargetData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.bulletID);
		
		stream.writeInt(this.bulletLevel);
		
		if(this.target!=null)
		{
			stream.writeDataFullNotNull(this.target);
		}
		else
		{
			nullObjError("target");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.bulletID);
		
		stream.writeInt(this.bulletLevel);
		
		if(this.target!=null)
		{
			stream.writeDataSimpleNotNull(this.target);
		}
		else
		{
			nullObjError("target");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.bulletID=0;
		this.bulletLevel=0;
		this.target.release(pool);
		this.target=null;
	}
	
	/** 创建实例 */
	public static CUnitBulletHitRequest create(int instanceID,int bulletID,int bulletLevel,SkillTargetData target)
	{
		CUnitBulletHitRequest re=(CUnitBulletHitRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.bulletID=bulletID;
		re.bulletLevel=bulletLevel;
		re.target=target;
		return re;
	}
	
}
