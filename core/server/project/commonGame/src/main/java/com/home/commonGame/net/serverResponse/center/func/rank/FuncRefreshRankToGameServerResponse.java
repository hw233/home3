package com.home.commonGame.net.serverResponse.center.func.rank;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送更新排行榜数据消息(generated by shine) */
public class FuncRefreshRankToGameServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRefreshRankToGame;
	
	/** 功能ID */
	public int funcID;
	
	/** 主键 */
	public long key;
	
	/** 排行值 */
	public long value;
	
	/** 参数组 */
	public long[] args;
	
	/** 排行 */
	public int rank;
	
	public FuncRefreshRankToGameServerResponse()
	{
		_dataID=ServerMessageType.FuncRefreshRankToGame;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.funcID=stream.readInt();
		
		this.key=stream.readLong();
		
		this.rank=stream.readInt();
		
		this.value=stream.readLong();
		
		if(stream.readBoolean())
		{
			int argsLen=stream.readLen();
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new long[argsLen];
			}
			long[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				long argsV;
				argsV=stream.readLong();
				
				argsT[argsI]=argsV;
			}
		}
		else
		{
			this.args=null;
		}
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.func.getRankToolForCenter(funcID).onRefreshRankFromCenter(key,value,rank);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRefreshRankToGameServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("funcID");
		writer.sb.append(':');
		writer.sb.append(this.funcID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("key");
		writer.sb.append(':');
		writer.sb.append(this.key);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("rank");
		writer.sb.append(':');
		writer.sb.append(this.rank);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("value");
		writer.sb.append(':');
		writer.sb.append(this.value);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("args");
		writer.sb.append(':');
		writer.sb.append("Array<long>");
		if(this.args!=null)
		{
			long[] argsT=this.args;
			int argsLen=argsT.length;
			writer.sb.append('(');
			writer.sb.append(argsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				long argsV=argsT[argsI];
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
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
		this.key=0L;
		this.rank=0;
		this.value=0L;
		this.args=null;
	}
	
}
