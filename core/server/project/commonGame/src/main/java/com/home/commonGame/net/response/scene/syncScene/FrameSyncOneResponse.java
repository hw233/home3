package com.home.commonGame.net.response.scene.syncScene;
import com.home.commonBase.data.scene.fight.FrameSyncCommandData;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.commonGame.scene.scene.BattleSceneSyncPlayLogic;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 帧同步单个玩家消息(generated by shine) */
public class FrameSyncOneResponse extends SceneRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FrameSyncOne;
	
	/** 指令 */
	public FrameSyncCommandData command;
	
	public FrameSyncOneResponse()
	{
		_dataID=GameResponseType.FrameSyncOne;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		((BattleSceneSyncPlayLogic)scene.gamePlay).receiveCommand(me.role.playerID,command);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FrameSyncOneResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData commandT=stream.readDataFullNotNull();
		if(commandT!=null)
		{
			if(commandT instanceof FrameSyncCommandData)
			{
				this.command=(FrameSyncCommandData)commandT;
			}
			else
			{
				this.command=new FrameSyncCommandData();
				if(!(commandT.getClass().isAssignableFrom(FrameSyncCommandData.class)))
				{
					stream.throwTypeReadError(FrameSyncCommandData.class,commandT.getClass());
				}
				this.command.shadowCopy(commandT);
			}
		}
		else
		{
			this.command=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.command=(FrameSyncCommandData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("command");
		writer.sb.append(':');
		if(this.command!=null)
		{
			this.command.writeDataString(writer);
		}
		else
		{
			writer.sb.append("FrameSyncCommandData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.command=null;
	}
	
}
