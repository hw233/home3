package com.home.commonClient.tool.generate;
import com.home.commonClient.constlist.generate.CenterResponseType;
import com.home.commonClient.net.centerResponse.func.base.FuncFromCenterSResponse;
import com.home.commonClient.net.centerResponse.func.match.FuncMatchSuccessFromCenterResponse;
import com.home.commonClient.net.centerResponse.func.match.FuncSendAcceptMatchFromCenterResponse;
import com.home.commonClient.net.centerResponse.func.match.FuncSendReAddMatchFromCenterResponse;
import com.home.commonClient.net.centerResponse.system.SendCenterReceiptToClientResponse;
import com.home.commonClient.net.centerResponse.system.SendInfoCodeFromCenterResponse;
import com.home.commonClient.net.centerResponse.system.SendInfoCodeWithArgsFromCenterResponse;
import com.home.shine.data.BaseData;
import com.home.shine.tool.CreateDataFunc;
import com.home.shine.tool.DataMaker;

/** (generated by shine) */
public class CenterResponseMaker extends DataMaker
{
	public CenterResponseMaker()
	{
		offSet=CenterResponseType.off;
		list=new CreateDataFunc[CenterResponseType.count-offSet];
		list[CenterResponseType.FuncFromCenterS-offSet]=this::createFuncFromCenterSResponse;
		list[CenterResponseType.FuncMatchSuccessFromCenter-offSet]=this::createFuncMatchSuccessFromCenterResponse;
		list[CenterResponseType.FuncSendAcceptMatchFromCenter-offSet]=this::createFuncSendAcceptMatchFromCenterResponse;
		list[CenterResponseType.FuncSendReAddMatchFromCenter-offSet]=this::createFuncSendReAddMatchFromCenterResponse;
		list[CenterResponseType.SendCenterReceiptToClient-offSet]=this::createSendCenterReceiptToClientResponse;
		list[CenterResponseType.SendInfoCodeFromCenter-offSet]=this::createSendInfoCodeFromCenterResponse;
		list[CenterResponseType.SendInfoCodeWithArgsFromCenter-offSet]=this::createSendInfoCodeWithArgsFromCenterResponse;
	}
	
	private BaseData createFuncMatchSuccessFromCenterResponse()
	{
		return new FuncMatchSuccessFromCenterResponse();
	}
	
	private BaseData createFuncSendAcceptMatchFromCenterResponse()
	{
		return new FuncSendAcceptMatchFromCenterResponse();
	}
	
	private BaseData createSendInfoCodeFromCenterResponse()
	{
		return new SendInfoCodeFromCenterResponse();
	}
	
	private BaseData createFuncSendReAddMatchFromCenterResponse()
	{
		return new FuncSendReAddMatchFromCenterResponse();
	}
	
	private BaseData createFuncFromCenterSResponse()
	{
		return new FuncFromCenterSResponse();
	}
	
	private BaseData createSendInfoCodeWithArgsFromCenterResponse()
	{
		return new SendInfoCodeWithArgsFromCenterResponse();
	}
	
	private BaseData createSendCenterReceiptToClientResponse()
	{
		return new SendCenterReceiptToClientResponse();
	}
	
}
