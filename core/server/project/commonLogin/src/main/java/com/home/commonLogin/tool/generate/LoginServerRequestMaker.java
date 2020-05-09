package com.home.commonLogin.tool.generate;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonLogin.net.serverRequest.game.login.PlayerBindPlatformToGameServerRequest;
import com.home.commonLogin.net.serverRequest.game.login.UserLoginToGameServerRequest;
import com.home.commonLogin.net.serverRequest.game.system.BeLoginToGameServerRequest;
import com.home.commonLogin.net.serverRequest.game.system.ReceiptUserWorkToGameServerRequest;
import com.home.commonLogin.net.serverRequest.game.system.SendInfoCodeFromLoginServerRequest;
import com.home.commonLogin.net.serverRequest.login.login.ClientLoginTransferServerRequest;
import com.home.commonLogin.net.serverRequest.login.login.ReClientLoginErrorServerRequest;
import com.home.commonLogin.net.serverRequest.login.login.ReClientLoginTransferServerRequest;
import com.home.commonLogin.net.serverRequest.login.system.BeLoginToLoginServerRequest;
import com.home.commonLogin.net.serverRequest.login.system.ReBeLoginToLoginServerRequest;
import com.home.commonLogin.net.serverRequest.manager.system.BeLoginToManagerServerRequest;
import com.home.shine.data.BaseData;
import com.home.shine.tool.CreateDataFunc;
import com.home.shine.tool.DataMaker;

/** (generated by shine) */
public class LoginServerRequestMaker extends DataMaker
{
	public LoginServerRequestMaker()
	{
		offSet=ServerMessageType.off;
		list=new CreateDataFunc[ServerMessageType.count-offSet];
		list[ServerMessageType.BeLoginToGame-offSet]=this::createBeLoginToGameServerRequest;
		list[ServerMessageType.BeLoginToLogin-offSet]=this::createBeLoginToLoginServerRequest;
		list[ServerMessageType.ClientLoginTransfer-offSet]=this::createClientLoginTransferServerRequest;
		list[ServerMessageType.ReBeLoginToLogin-offSet]=this::createReBeLoginToLoginServerRequest;
		list[ServerMessageType.ReClientLoginError-offSet]=this::createReClientLoginErrorServerRequest;
		list[ServerMessageType.ReClientLoginTransfer-offSet]=this::createReClientLoginTransferServerRequest;
		list[ServerMessageType.ReceiptUserWorkToGame-offSet]=this::createReceiptUserWorkToGameServerRequest;
		list[ServerMessageType.SendInfoCodeFromLogin-offSet]=this::createSendInfoCodeFromLoginServerRequest;
		list[ServerMessageType.BeLoginToManager-offSet]=this::createBeLoginToManagerServerRequest;
		list[ServerMessageType.PlayerBindPlatformToGame-offSet]=this::createPlayerBindPlatformToGameServerRequest;
		list[ServerMessageType.UserLoginToGame-offSet]=this::createUserLoginToGameServerRequest;
	}
	
	private BaseData createBeLoginToGameServerRequest()
	{
		return new BeLoginToGameServerRequest();
	}
	
	private BaseData createBeLoginToLoginServerRequest()
	{
		return new BeLoginToLoginServerRequest();
	}
	
	private BaseData createClientLoginTransferServerRequest()
	{
		return new ClientLoginTransferServerRequest();
	}
	
	private BaseData createReBeLoginToLoginServerRequest()
	{
		return new ReBeLoginToLoginServerRequest();
	}
	
	private BaseData createReClientLoginErrorServerRequest()
	{
		return new ReClientLoginErrorServerRequest();
	}
	
	private BaseData createReClientLoginTransferServerRequest()
	{
		return new ReClientLoginTransferServerRequest();
	}
	
	private BaseData createReceiptUserWorkToGameServerRequest()
	{
		return new ReceiptUserWorkToGameServerRequest();
	}
	
	private BaseData createSendInfoCodeFromLoginServerRequest()
	{
		return new SendInfoCodeFromLoginServerRequest();
	}
	
	private BaseData createBeLoginToManagerServerRequest()
	{
		return new BeLoginToManagerServerRequest();
	}
	
	private BaseData createPlayerBindPlatformToGameServerRequest()
	{
		return new PlayerBindPlatformToGameServerRequest();
	}
	
	private BaseData createUserLoginToGameServerRequest()
	{
		return new UserLoginToGameServerRequest();
	}
	
}
