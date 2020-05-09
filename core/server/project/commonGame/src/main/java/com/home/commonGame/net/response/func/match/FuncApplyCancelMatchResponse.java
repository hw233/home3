package com.home.commonGame.net.response.func.match;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.base.GameResponse;
import com.home.commonGame.net.response.func.base.FuncRResponse;
import com.home.shine.bytes.BytesReadStream;

/** 申请取消匹配(generated by shine) */
public class FuncApplyCancelMatchResponse extends FuncRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncApplyCancelMatch;
	
	public FuncApplyCancelMatchResponse()
	{
		_dataID=GameResponseType.FuncApplyCancelMatch;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.scene.cancelMatch(me,funcID);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncApplyCancelMatchResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
}
