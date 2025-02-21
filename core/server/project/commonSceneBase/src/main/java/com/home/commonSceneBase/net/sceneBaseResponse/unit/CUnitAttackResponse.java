package com.home.commonSceneBase.net.sceneBaseResponse.unit;
import com.home.commonBase.data.scene.fight.SkillTargetData;
import com.home.commonSceneBase.constlist.generate.SceneBaseResponseType;
import com.home.commonSceneBase.net.sceneBaseResponse.base.CUnitRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntList;
import com.home.shine.support.pool.DataPool;

/** 控制单位使用Attack(客户端驱动attack时用)(generated by shine) */
public class CUnitAttackResponse extends CUnitRResponse
{
	/** 数据类型ID */
	public static final int dataID=SceneBaseResponseType.CUnitAttack;
	
	/** 攻击ID */
	public int attackID;
	
	/** 攻击等级 */
	public int attackLevel;
	
	/** 目标数据 */
	public SkillTargetData targetData;
	
	/** 目标组 */
	public IntList targets;
	
	/** 是否子弹第一次攻击 */
	public boolean isBulletFirstHit;
	
	public CUnitAttackResponse()
	{
		_dataID=SceneBaseResponseType.CUnitAttack;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		unit.fight.clientAttack(attackID,attackLevel,targetData,targets,isBulletFirstHit);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitAttackResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.attackID=stream.readInt();
		
		this.attackLevel=stream.readInt();
		
		BaseData targetDataT=stream.readDataFullNotNull();
		if(targetDataT!=null)
		{
			if(targetDataT instanceof SkillTargetData)
			{
				this.targetData=(SkillTargetData)targetDataT;
			}
			else
			{
				this.targetData=new SkillTargetData();
				if(!(targetDataT.getClass().isAssignableFrom(SkillTargetData.class)))
				{
					stream.throwTypeReadError(SkillTargetData.class,targetDataT.getClass());
				}
				this.targetData.shadowCopy(targetDataT);
			}
		}
		else
		{
			this.targetData=null;
		}
		
		int targetsLen=stream.readLen();
		if(this.targets!=null)
		{
			this.targets.clear();
			this.targets.ensureCapacity(targetsLen);
		}
		else
		{
			this.targets=new IntList(targetsLen);
		}
		
		IntList targetsT=this.targets;
		for(int targetsI=targetsLen-1;targetsI>=0;--targetsI)
		{
			int targetsV;
			targetsV=stream.readInt();
			
			targetsT.add(targetsV);
		}
		
		this.isBulletFirstHit=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.attackID=stream.readInt();
		
		this.attackLevel=stream.readInt();
		
		this.targetData=(SkillTargetData)stream.readDataSimpleNotNull();
		
		int targetsLen=stream.readLen();
		if(this.targets!=null)
		{
			this.targets.clear();
			this.targets.ensureCapacity(targetsLen);
		}
		else
		{
			this.targets=new IntList(targetsLen);
		}
		
		IntList targetsT=this.targets;
		for(int targetsI=targetsLen-1;targetsI>=0;--targetsI)
		{
			int targetsV;
			targetsV=stream.readInt();
			
			targetsT.add(targetsV);
		}
		
		this.isBulletFirstHit=stream.readBoolean();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("attackID");
		writer.sb.append(':');
		writer.sb.append(this.attackID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("attackLevel");
		writer.sb.append(':');
		writer.sb.append(this.attackLevel);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("targetData");
		writer.sb.append(':');
		if(this.targetData!=null)
		{
			this.targetData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SkillTargetData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("targets");
		writer.sb.append(':');
		writer.sb.append("List<int>");
		if(this.targets!=null)
		{
			IntList targetsT=this.targets;
			int targetsLen=targetsT.size();
			writer.sb.append('(');
			writer.sb.append(targetsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int targetsI=0;targetsI<targetsLen;++targetsI)
			{
				int targetsV=targetsT.get(targetsI);
				writer.writeTabs();
				writer.sb.append(targetsI);
				writer.sb.append(':');
				writer.sb.append(targetsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isBulletFirstHit");
		writer.sb.append(':');
		writer.sb.append(this.isBulletFirstHit);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.attackID=0;
		this.attackLevel=0;
		this.targetData=null;
		this.targets=null;
		this.isBulletFirstHit=false;
	}
	
}
