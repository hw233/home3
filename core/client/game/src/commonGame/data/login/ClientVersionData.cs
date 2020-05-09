using ShineEngine;

/// <summary>
/// 客户端版本数据(generated by shine)
/// </summary>
public class ClientVersionData:BaseData
{
	/// <summary>
	/// 设备平台类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 当前App版本
	/// </summary>
	public int currentAppVersion;
	
	/// <summary>
	/// 最低App版本
	/// </summary>
	public int leastAppVersion;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.ClientVersion;
	
	/// <summary>
	/// 最低资源版本
	/// </summary>
	public int leastResourceVersion;
	
	/// <summary>
	/// 当前资源版本
	/// </summary>
	public int currentResourceVersion;
	
	/// <summary>
	/// 版本字符串
	/// </summary>
	public string version;
	
	public ClientVersionData()
	{
		_dataID=BaseDataType.ClientVersion;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ClientVersionData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.type=stream.readInt();
		
		this.leastAppVersion=stream.readInt();
		
		this.currentAppVersion=stream.readInt();
		
		this.leastResourceVersion=stream.readInt();
		
		this.currentResourceVersion=stream.readInt();
		
		this.version=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.type);
		
		stream.writeInt(this.leastAppVersion);
		
		stream.writeInt(this.currentAppVersion);
		
		stream.writeInt(this.leastResourceVersion);
		
		stream.writeInt(this.currentResourceVersion);
		
		stream.writeUTF(this.version);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is ClientVersionData))
			return;
		
		ClientVersionData mData=(ClientVersionData)data;
		
		this.type=mData.type;
		this.leastAppVersion=mData.leastAppVersion;
		this.currentAppVersion=mData.currentAppVersion;
		this.leastResourceVersion=mData.leastResourceVersion;
		this.currentResourceVersion=mData.currentResourceVersion;
		this.version=mData.version;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is ClientVersionData))
			return;
		
		ClientVersionData mData=(ClientVersionData)data;
		
		this.type=mData.type;
		
		this.leastAppVersion=mData.leastAppVersion;
		
		this.currentAppVersion=mData.currentAppVersion;
		
		this.leastResourceVersion=mData.leastResourceVersion;
		
		this.currentResourceVersion=mData.currentResourceVersion;
		
		this.version=mData.version;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		ClientVersionData mData=(ClientVersionData)data;
		if(this.type!=mData.type)
			return false;
		
		if(this.leastAppVersion!=mData.leastAppVersion)
			return false;
		
		if(this.currentAppVersion!=mData.currentAppVersion)
			return false;
		
		if(this.leastResourceVersion!=mData.leastResourceVersion)
			return false;
		
		if(this.currentResourceVersion!=mData.currentResourceVersion)
			return false;
		
		if(this.version!=mData.version)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("leastAppVersion");
		writer.sb.Append(':');
		writer.sb.Append(this.leastAppVersion);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("currentAppVersion");
		writer.sb.Append(':');
		writer.sb.Append(this.currentAppVersion);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("leastResourceVersion");
		writer.sb.Append(':');
		writer.sb.Append(this.leastResourceVersion);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("currentResourceVersion");
		writer.sb.Append(':');
		writer.sb.Append(this.currentResourceVersion);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("version");
		writer.sb.Append(':');
		writer.sb.Append(this.version);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.type=stream.readInt();
		
		this.leastAppVersion=stream.readInt();
		
		this.currentAppVersion=stream.readInt();
		
		this.leastResourceVersion=stream.readInt();
		
		this.currentResourceVersion=stream.readInt();
		
		this.version=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.type);
		
		stream.writeInt(this.leastAppVersion);
		
		stream.writeInt(this.currentAppVersion);
		
		stream.writeInt(this.leastResourceVersion);
		
		stream.writeInt(this.currentResourceVersion);
		
		stream.writeUTF(this.version);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.type=0;
		this.leastAppVersion=0;
		this.currentAppVersion=0;
		this.leastResourceVersion=0;
		this.currentResourceVersion=0;
		this.version="";
	}
	
}
