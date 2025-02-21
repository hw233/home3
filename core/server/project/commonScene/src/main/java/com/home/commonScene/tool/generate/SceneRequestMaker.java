package com.home.commonScene.tool.generate;
import com.home.commonScene.constlist.generate.SceneRequestType;
import com.home.commonScene.net.sceneRequest.scene.EnterSceneForSceneRequest;
import com.home.commonScene.net.sceneRequest.scene.LeaveSceneForSceneRequest;
import com.home.commonScene.net.sceneRequest.scene.PreEnterSceneForSceneRequest;
import com.home.commonScene.net.sceneRequest.scene.PreEnterSceneNextForSceneRequest;
import com.home.shine.data.BaseData;
import com.home.shine.tool.CreateDataFunc;
import com.home.shine.tool.DataMaker;

/** (generated by shine) */
public class SceneRequestMaker extends DataMaker
{
	public SceneRequestMaker()
	{
		offSet=SceneRequestType.off;
		list=new CreateDataFunc[SceneRequestType.count-offSet];
		list[SceneRequestType.EnterSceneForScene-offSet]=this::createEnterSceneForSceneRequest;
		list[SceneRequestType.LeaveSceneForScene-offSet]=this::createLeaveSceneForSceneRequest;
		list[SceneRequestType.PreEnterSceneForScene-offSet]=this::createPreEnterSceneForSceneRequest;
		list[SceneRequestType.PreEnterSceneNextForScene-offSet]=this::createPreEnterSceneNextForSceneRequest;
	}
	
	private BaseData createPreEnterSceneForSceneRequest()
	{
		return new PreEnterSceneForSceneRequest();
	}
	
	private BaseData createPreEnterSceneNextForSceneRequest()
	{
		return new PreEnterSceneNextForSceneRequest();
	}
	
	private BaseData createEnterSceneForSceneRequest()
	{
		return new EnterSceneForSceneRequest();
	}
	
	private BaseData createLeaveSceneForSceneRequest()
	{
		return new LeaveSceneForSceneRequest();
	}
	
}
