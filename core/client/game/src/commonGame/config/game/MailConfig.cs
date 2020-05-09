using ShineEngine;

/// <summary>
/// 邮件表(generated by shine)
/// </summary>
public class MailConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<MailConfig> _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 标题
	/// </summary>
	public string title;
	
	/// <summary>
	/// 是否新获得时出现红点
	/// </summary>
	public bool needRedPoint;
	
	/// <summary>
	/// 奖励id
	/// </summary>
	public int rewardID;
	
	/// <summary>
	/// 内容
	/// </summary>
	public string content;
	
	/** 标题原值 */
	private string _title;
	
	/** 内容原值 */
	private string _content;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static MailConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<MailConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<MailConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<MailConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.type=stream.readInt();
		
		this.title=stream.readUTF();
		
		this.content=stream.readUTF();
		
		this.needRedPoint=stream.readBoolean();
		
		this.rewardID=stream.readInt();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		if(_title==null)
			_title=title;
		title=LanguageConfig.getText(_title);
		
		if(_content==null)
			_content=content;
		content=LanguageConfig.getText(_content);
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.type);
		
		stream.writeUTF(this.title);
		
		stream.writeUTF(this.content);
		
		stream.writeBoolean(this.needRedPoint);
		
		stream.writeInt(this.rewardID);
		
	}
	
}
