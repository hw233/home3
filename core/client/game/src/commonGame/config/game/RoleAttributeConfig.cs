using ShineEngine;

/// <summary>
/// 角色属性类型表(generated by shine)
/// </summary>
public class RoleAttributeConfig:BaseConfig
{
	/** 存储集合 */
	private static RoleAttributeConfig[] _dic;
	
	/// <summary>
	/// 属性id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 显示名
	/// </summary>
	public string showName;
	
	/// <summary>
	/// 公式类型
	/// </summary>
	public int[] formula;
	
	/// <summary>
	/// 是否为千分比属性
	/// </summary>
	public bool isPercent;
	
	/// <summary>
	/// 自增属性对应ID
	/// </summary>
	public int increaseID;
	
	/// <summary>
	/// 当前属性的上限值ID
	/// </summary>
	public int currentMaxID;
	
	/// <summary>
	/// 当前属性默认空满
	/// </summary>
	public bool isCurrentDefaultFull;
	
	/// <summary>
	/// 推送角色自己方式
	/// </summary>
	public int sendSelfType;
	
	/** 显示名原值 */
	private string _showName;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static RoleAttributeConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(RoleAttributeConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(RoleAttributeConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static RoleAttributeConfig[] getDic()
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
		
		this.name=stream.readUTF();
		
		this.showName=stream.readUTF();
		
		int formulaLen=stream.readLen();
		if(this.formula==null || this.formula.Length!=formulaLen)
		{
			this.formula=new int[formulaLen];
		}
		int[] formulaT=this.formula;
		for(int formulaI=0;formulaI<formulaLen;++formulaI)
		{
			int formulaV;
			formulaV=stream.readInt();
			
			formulaT[formulaI]=formulaV;
		}
		
		this.isPercent=stream.readBoolean();
		
		this.increaseID=stream.readInt();
		
		this.currentMaxID=stream.readInt();
		
		this.isCurrentDefaultFull=stream.readBoolean();
		
		this.sendSelfType=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.name);
		
		stream.writeUTF(this.showName);
		
		if(this.formula!=null)
		{
			int[] formulaT=this.formula;
			stream.writeLen(formulaT.Length);
			for(int formulaVI=0,formulaVLen=formulaT.Length;formulaVI<formulaVLen;++formulaVI)
			{
				int formulaV=formulaT[formulaVI];
				stream.writeInt(formulaV);
				
			}
		}
		else
		{
			nullObjError("formula");
		}
		
		stream.writeBoolean(this.isPercent);
		
		stream.writeInt(this.increaseID);
		
		stream.writeInt(this.currentMaxID);
		
		stream.writeBoolean(this.isCurrentDefaultFull);
		
		stream.writeInt(this.sendSelfType);
		
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		if(_showName==null)
			_showName=showName;
		showName=LanguageConfig.getText(_showName);
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		SList<AttributeOneInfo> list=new SList<AttributeOneInfo>();

		foreach(RoleAttributeConfig config in _dic)
		{
			if(config!=null)
				list.add(config.createInfo());
		}

		AttributeControl.roleAttribute.init(list,RoleAttributeType.size);
	}
	
	public AttributeOneInfo createInfo()
	{
		AttributeOneInfo re=new AttributeOneInfo();
		re.id=id;
		re.formula=formula;
		re.isPercent=isPercent;
		re.increaseID=increaseID;
		re.currentMaxID=currentMaxID;
		re.isCurrentDefaultFull=isCurrentDefaultFull;
		re.sendSelfType=sendSelfType;
		return re;
	}
	
}
