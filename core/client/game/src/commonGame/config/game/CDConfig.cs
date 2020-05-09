using ShineEngine;

/// <summary>
/// CD表(generated by shine)
/// </summary>
public class CDConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<CDConfig> _dic;
	
	/// <summary>
	/// 所属组号
	/// </summary>
	public int[] groups;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 保留类型
	/// </summary>
	public int keepType;
	
	/// <summary>
	/// 冷却时间(ms)
	/// </summary>
	public int cd;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static CDConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<CDConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<CDConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<CDConfig> getDic()
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
		
		int groupsLen=stream.readLen();
		if(this.groups==null || this.groups.Length!=groupsLen)
		{
			this.groups=new int[groupsLen];
		}
		int[] groupsT=this.groups;
		for(int groupsI=0;groupsI<groupsLen;++groupsI)
		{
			int groupsV;
			groupsV=stream.readInt();
			
			groupsT[groupsI]=groupsV;
		}
		
		this.cd=stream.readInt();
		
		this.keepType=stream.readInt();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 是否包含某组
	/// </summary>
	public bool hasGroup(int groupID)
	{
     		int[] groups;

     		for(int i=(groups=this.groups).Length-1;i>=0;--i)
     		{
     			if(groups[i]==groupID)
     				return true;
     		}

     		return false;
     	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		if(this.groups!=null)
		{
			int[] groupsT=this.groups;
			stream.writeLen(groupsT.Length);
			for(int groupsVI=0,groupsVLen=groupsT.Length;groupsVI<groupsVLen;++groupsVI)
			{
				int groupsV=groupsT[groupsVI];
				stream.writeInt(groupsV);
				
			}
		}
		else
		{
			nullObjError("groups");
		}
		
		stream.writeInt(this.cd);
		
		stream.writeInt(this.keepType);
		
	}
	
}
