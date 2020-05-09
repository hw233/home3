package com.home.commonGame.net.request.func.match;
import com.home.commonBase.data.scene.match.PlayerMatchData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 匹配成功消息(generated by shine) */
public class FuncMatchSuccessRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncMatchSuccess;
	
	/** 匹配序号 */
	public int index;
	
	/** 匹配数据组 */
	public PlayerMatchData[] matchDatas;
	
	public FuncMatchSuccessRequest()
	{
		_dataID=GameRequestType.FuncMatchSuccess;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PlayerMatchData[] matchDatasTemp=matchDatas;
		if(matchDatasTemp!=null)
		{
			PlayerMatchData[] matchDatasR=matchDatasTemp;
			int matchDatasLen=matchDatasR.length;
			this.matchDatas=new PlayerMatchData[matchDatasLen];
			PlayerMatchData[] matchDatasT=this.matchDatas;
			for(int matchDatasI=0;matchDatasI<matchDatasLen;++matchDatasI)
			{
				PlayerMatchData matchDatasV=matchDatasR[matchDatasI];
				PlayerMatchData matchDatasU;
				if(matchDatasV!=null)
				{
					matchDatasU=(PlayerMatchData)matchDatasV.clone();
				}
				else
				{
					matchDatasU=null;
					nullObjError("matchDatasU");
				}
				
				matchDatasT[matchDatasI]=matchDatasU;
			}
		}
		else
		{
			this.matchDatas=null;
			nullObjError("matchDatas");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncMatchSuccessRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("matchDatas");
		writer.sb.append(':');
		writer.sb.append("Array<PlayerMatchData>");
		if(this.matchDatas!=null)
		{
			PlayerMatchData[] matchDatasT=this.matchDatas;
			int matchDatasLen=matchDatasT.length;
			writer.sb.append('(');
			writer.sb.append(matchDatasLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int matchDatasI=0;matchDatasI<matchDatasLen;++matchDatasI)
			{
				PlayerMatchData matchDatasV=matchDatasT[matchDatasI];
				writer.writeTabs();
				writer.sb.append(matchDatasI);
				writer.sb.append(':');
				if(matchDatasV!=null)
				{
					matchDatasV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("PlayerMatchData=null");
				}
				
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.index);
		
		if(this.matchDatas!=null)
		{
			PlayerMatchData[] matchDatasT=this.matchDatas;
			stream.writeLen(matchDatasT.length);
			for(int matchDatasVI=0,matchDatasVLen=matchDatasT.length;matchDatasVI<matchDatasVLen;++matchDatasVI)
			{
				PlayerMatchData matchDatasV=matchDatasT[matchDatasVI];
				if(matchDatasV!=null)
				{
					stream.writeDataFullNotNull(matchDatasV);
				}
				else
				{
					nullObjError("matchDatasV");
				}
				
			}
		}
		else
		{
			nullObjError("matchDatas");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.index);
		
		if(this.matchDatas!=null)
		{
			PlayerMatchData[] matchDatasT=this.matchDatas;
			stream.writeLen(matchDatasT.length);
			for(int matchDatasVI=0,matchDatasVLen=matchDatasT.length;matchDatasVI<matchDatasVLen;++matchDatasVI)
			{
				PlayerMatchData matchDatasV=matchDatasT[matchDatasVI];
				if(matchDatasV!=null)
				{
					stream.writeDataSimpleNotNull(matchDatasV);
				}
				else
				{
					nullObjError("matchDatasV");
				}
				
			}
		}
		else
		{
			nullObjError("matchDatas");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
		this.matchDatas=null;
	}
	
	/** 创建实例 */
	public static FuncMatchSuccessRequest create(int funcID,int index,PlayerMatchData[] matchDatas)
	{
		FuncMatchSuccessRequest re=(FuncMatchSuccessRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.index=index;
		re.matchDatas=matchDatas;
		return re;
	}
	
}
