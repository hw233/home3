package com.home.commonBase.tool.generate;
import com.home.commonBase.constlist.generate.CenterGlobalPartDataType;
import com.home.commonBase.part.centerGlobal.data.CenterActivityPartData;
import com.home.commonBase.part.centerGlobal.data.CenterFuncPartData;
import com.home.commonBase.part.centerGlobal.data.CenterMailPartData;
import com.home.commonBase.part.centerGlobal.data.CenterSocialPartData;
import com.home.commonBase.part.centerGlobal.data.CenterSystemPartData;
import com.home.commonBase.part.centerGlobal.data.CenterUnionPartData;
import com.home.shine.data.BaseData;
import com.home.shine.tool.CreateDataFunc;
import com.home.shine.tool.DataMaker;

/** (generated by shine) */
public class CenterGlobalPartDataMaker extends DataMaker
{
	public CenterGlobalPartDataMaker()
	{
		offSet=CenterGlobalPartDataType.off;
		list=new CreateDataFunc[CenterGlobalPartDataType.count-offSet];
		list[CenterGlobalPartDataType.CenterActivity-offSet]=this::createCenterActivityPartData;
		list[CenterGlobalPartDataType.CenterFunc-offSet]=this::createCenterFuncPartData;
		list[CenterGlobalPartDataType.CenterMail-offSet]=this::createCenterMailPartData;
		list[CenterGlobalPartDataType.CenterSocial-offSet]=this::createCenterSocialPartData;
		list[CenterGlobalPartDataType.CenterSystem-offSet]=this::createCenterSystemPartData;
		list[CenterGlobalPartDataType.CenterUnion-offSet]=this::createCenterUnionPartData;
	}
	
	private BaseData createCenterSystemPartData()
	{
		return new CenterSystemPartData();
	}
	
	private BaseData createCenterFuncPartData()
	{
		return new CenterFuncPartData();
	}
	
	private BaseData createCenterSocialPartData()
	{
		return new CenterSocialPartData();
	}
	
	private BaseData createCenterMailPartData()
	{
		return new CenterMailPartData();
	}
	
	private BaseData createCenterActivityPartData()
	{
		return new CenterActivityPartData();
	}
	
	private BaseData createCenterUnionPartData()
	{
		return new CenterUnionPartData();
	}
	
}
