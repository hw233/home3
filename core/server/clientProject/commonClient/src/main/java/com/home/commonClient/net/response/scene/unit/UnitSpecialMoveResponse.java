package com.home.commonClient.net.response.scene.unit;
import com.home.commonBase.data.scene.base.PosData;
import com.home.commonBase.data.scene.base.PosDirData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.scene.base.UnitSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位特殊移动消息(generated by shine) */
public class UnitSpecialMoveResponse extends UnitSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.UnitSpecialMove;
	
	/** 特殊移动ID */
	public int id;
	
	/** 当前位置 */
	public PosDirData posDir;
	
	/** 基元移动点位置 */
	public PosData baseMovePos;
	
	/** 特殊移动剩余时间 */
	public int specialMoveLastTime;
	
	/** 参数组 */
	public int[] args;
	
	public UnitSpecialMoveResponse()
	{
		_dataID=GameResponseType.UnitSpecialMove;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		scene.getFightUnitAbs(instanceID).move.onServerSpecialMove(posDir,id,args,specialMoveLastTime,baseMovePos);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitSpecialMoveResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.posDir=new PosDirData();
		this.posDir.readBytesFull(stream);
		
		if(stream.readBoolean())
		{
			int argsLen=stream.readLen();
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new int[argsLen];
			}
			int[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				int argsV;
				argsV=stream.readInt();
				
				argsT[argsI]=argsV;
			}
		}
		else
		{
			this.args=null;
		}
		
		this.specialMoveLastTime=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.baseMovePos=new PosData();
			this.baseMovePos.readBytesFull(stream);
		}
		else
		{
			this.baseMovePos=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.posDir=new PosDirData();
		this.posDir.readBytesSimple(stream);
		
		if(stream.readBoolean())
		{
			int argsLen=stream.readLen();
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new int[argsLen];
			}
			int[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				int argsV;
				argsV=stream.readInt();
				
				argsT[argsI]=argsV;
			}
		}
		else
		{
			this.args=null;
		}
		
		this.specialMoveLastTime=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.baseMovePos=new PosData();
			this.baseMovePos.readBytesSimple(stream);
		}
		else
		{
			this.baseMovePos=null;
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("posDir");
		writer.sb.append(':');
		if(this.posDir!=null)
		{
			this.posDir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosDirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("args");
		writer.sb.append(':');
		writer.sb.append("Array<int>");
		if(this.args!=null)
		{
			int[] argsT=this.args;
			int argsLen=argsT.length;
			writer.sb.append('(');
			writer.sb.append(argsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				int argsV=argsT[argsI];
				writer.writeTabs();
				writer.sb.append(argsI);
				writer.sb.append(':');
				writer.sb.append(argsV);
				
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
		writer.sb.append("specialMoveLastTime");
		writer.sb.append(':');
		writer.sb.append(this.specialMoveLastTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("baseMovePos");
		writer.sb.append(':');
		if(this.baseMovePos!=null)
		{
			this.baseMovePos.writeDataString(writer);
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
		
		this.id=0;
		this.posDir=null;
		this.args=null;
		this.specialMoveLastTime=0;
		this.baseMovePos=null;
	}
	
}
