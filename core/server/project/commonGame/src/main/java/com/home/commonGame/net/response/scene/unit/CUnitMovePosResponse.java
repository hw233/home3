package com.home.commonGame.net.response.scene.unit;
import com.home.commonBase.data.scene.base.PosData;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.CUnitRResponse;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端单位移动到点消息(generated by shine) */
public class CUnitMovePosResponse extends CUnitRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitMovePos;
	
	/** 移动类型 */
	public int type;
	
	/** 当前位置 */
	public PosData nowPos;
	
	/** 目标位置 */
	public PosData targetPos;
	
	public CUnitMovePosResponse()
	{
		_dataID=GameResponseType.CUnitMovePos;
	}
	
	/** 执行 */
	protected void execute()
	{
		unit.move.onClientMovePos(nowPos,type,targetPos);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitMovePosResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.type=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.nowPos=new PosData();
			this.nowPos.readBytesFull(stream);
		}
		else
		{
			this.nowPos=null;
		}
		
		this.targetPos=new PosData();
		this.targetPos.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.type=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.nowPos=new PosData();
			this.nowPos.readBytesSimple(stream);
		}
		else
		{
			this.nowPos=null;
		}
		
		this.targetPos=new PosData();
		this.targetPos.readBytesSimple(stream);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("type");
		writer.sb.append(':');
		writer.sb.append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nowPos");
		writer.sb.append(':');
		if(this.nowPos!=null)
		{
			this.nowPos.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("targetPos");
		writer.sb.append(':');
		if(this.targetPos!=null)
		{
			this.targetPos.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.type=0;
		this.nowPos=null;
		this.targetPos=null;
	}
	
}
