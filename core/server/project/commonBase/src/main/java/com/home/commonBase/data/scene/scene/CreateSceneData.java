package com.home.commonBase.data.scene.scene;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建场景数据(generated by shine) */
public class CreateSceneData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.CreateScene;
	
	public int sceneID;
	
	public CreateSceneData()
	{
		_dataID=BaseDataType.CreateScene;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CreateSceneData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.sceneID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.sceneID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.sceneID=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.sceneID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof CreateSceneData))
			return;
		
		CreateSceneData mData=(CreateSceneData)data;
		
		this.sceneID=mData.sceneID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof CreateSceneData))
			return;
		
		CreateSceneData mData=(CreateSceneData)data;
		
		this.sceneID=mData.sceneID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		CreateSceneData mData=(CreateSceneData)data;
		if(this.sceneID!=mData.sceneID)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("sceneID");
		writer.sb.append(':');
		writer.sb.append(this.sceneID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.sceneID=0;
	}
	
}
