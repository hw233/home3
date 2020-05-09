package com.home.commonCenter.net.serverResponse.game.func.rank;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.serverResponse.game.func.base.FuncPlayerToCenterServerResponse;
import com.home.commonCenter.tool.func.CenterPlayerRankTool;
import com.home.commonCenter.tool.func.CenterRankTool;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 排行榜提交排行值到中心服(generated by shine) */
public class FuncCommitRankValueToCenterServerResponse extends FuncPlayerToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncCommitRankValueToCenter;
	
	/** 版本号 */
	public int version;
	
	/** 参数组 */
	public long[] args;
	
	/** 排行值 */
	public long value;
	
	public FuncCommitRankValueToCenterServerResponse()
	{
		_dataID=ServerMessageType.FuncCommitRankValueToCenter;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.version=stream.readInt();
		
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
		CenterRankTool rankTool=CenterC.global.func.getRankTool(funcID);
		
		if(rankTool!=null)
		{
			rankTool.commitRank(version,playerID,value,args);
		}
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncCommitRankValueToCenterServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("version");
		writer.sb.append(':');
		writer.sb.append(this.version);
		
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
		
		this.version=0;
		this.value=0L;
		this.args=null;
	}
	
}
