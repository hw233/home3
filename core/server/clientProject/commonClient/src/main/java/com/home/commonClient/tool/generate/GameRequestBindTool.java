package com.home.commonClient.tool.generate;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.shine.data.BaseData;
import com.home.shine.tool.MessageBindTool;

/** (generated by shine) */
public class GameRequestBindTool extends MessageBindTool
{
	public GameRequestBindTool()
	{
		offSet=GameRequestType.off;
		list=new int[GameRequestType.count-offSet][];
		list[GameRequestType.AddAllFriend-offSet]=new int[]{};
		list[GameRequestType.AddFriend-offSet]=new int[]{};
		list[GameRequestType.AgreeAddFriend-offSet]=new int[]{};
		list[GameRequestType.ApplyChangeRoleName-offSet]=new int[]{};
		list[GameRequestType.CreatePlayer-offSet]=new int[]{};
		list[GameRequestType.DeleteMail-offSet]=new int[]{};
		list[GameRequestType.RefuseApplyAddFriend-offSet]=new int[]{};
		list[GameRequestType.RemoveFriend-offSet]=new int[]{};
		list[GameRequestType.SearchPlayer-offSet]=new int[]{};
		list[GameRequestType.TakeMail-offSet]=new int[]{};
	}
	
}
