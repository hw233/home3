package com.home.commonGame.net.response.scene.unit;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.unit.CUnitUseSkillResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 玩家单位使用技能拓展(generated by shine) */
public class CUnitUseSkillExResponse extends CUnitUseSkillResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitUseSkillEx;
	
	/** 使用技能ID */
	public int useSkillID;
	
	/** 随机种子序号 */
	public int seedIndex;
	
	public CUnitUseSkillExResponse()
	{
		_dataID=GameResponseType.CUnitUseSkillEx;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		unit.fight.onClientUseSkill(skillID,targetData,posDir,useSkillID,seedIndex,socket.getPing());
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitUseSkillExResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.useSkillID=stream.readInt();
		
		this.seedIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.useSkillID=stream.readInt();
		
		this.seedIndex=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("useSkillID");
		writer.sb.append(':');
		writer.sb.append(this.useSkillID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("seedIndex");
		writer.sb.append(':');
		writer.sb.append(this.seedIndex);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.useSkillID=0;
		this.seedIndex=0;
	}
	
}
