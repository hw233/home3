using ShineEngine;

/// <summary>
/// 客户端本地角色缓存数据(generated by shine)
/// </summary>
public class ClientPlayerLocalCacheData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.ClientPlayerLocalCache;
	
	/// <summary>
	/// 标准保存数据
	/// </summary>
	public KeepSaveData keep;
	
	public ClientPlayerLocalCacheData()
	{
		_dataID=BaseDataType.ClientPlayerLocalCache;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ClientPlayerLocalCacheData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.keep=(KeepSaveData)stream.createData(KeepSaveData.dataID);
		this.keep.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.keep!=null)
		{
			this.keep.writeBytesFull(stream);
		}
		else
		{
			nullObjError("keep");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.keep=(KeepSaveData)stream.createData(KeepSaveData.dataID);
		this.keep.readBytesSimple(stream);
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.keep!=null)
		{
			this.keep.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("keep");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is ClientPlayerLocalCacheData))
			return;
		
		ClientPlayerLocalCacheData mData=(ClientPlayerLocalCacheData)data;
		
		this.keep=mData.keep;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is ClientPlayerLocalCacheData))
			return;
		
		ClientPlayerLocalCacheData mData=(ClientPlayerLocalCacheData)data;
		
		if(mData.keep!=null)
		{
			this.keep=(KeepSaveData)BytesControl.createData(KeepSaveData.dataID);
			this.keep.copy(mData.keep);
		}
		else
		{
			this.keep=null;
			nullObjError("keep");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		ClientPlayerLocalCacheData mData=(ClientPlayerLocalCacheData)data;
		if(mData.keep!=null)
		{
			if(this.keep==null)
				return false;
			if(!this.keep.dataEquals(mData.keep))
				return false;
		}
		else
		{
			if(this.keep!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("keep");
		writer.sb.Append(':');
		if(this.keep!=null)
		{
			this.keep.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("KeepSaveData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.keep=new KeepSaveData();
		this.keep.initDefault();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.keep=null;
	}
	
}
