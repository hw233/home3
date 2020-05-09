using ShineEngine;

/// <summary>
/// 场景势力类型(generated by shine)
/// </summary>
public class SceneForceTypeConfig:BaseConfig
{
	/** 存储集合 */
	private static SceneForceTypeConfig[] _dic;
	
	/// <summary>
	/// 敌对势力组
	/// </summary>
	public int[] enemies;
	
	/// <summary>
	/// 敌对关系组T
	/// </summary>
	public int[] againstSet;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 友好势力组
	/// </summary>
	public int[] friends;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static SceneForceTypeConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(SceneForceTypeConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(SceneForceTypeConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static SceneForceTypeConfig[] getDic()
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
		
		int enemiesLen=stream.readLen();
		if(this.enemies==null || this.enemies.Length!=enemiesLen)
		{
			this.enemies=new int[enemiesLen];
		}
		int[] enemiesT=this.enemies;
		for(int enemiesI=0;enemiesI<enemiesLen;++enemiesI)
		{
			int enemiesV;
			enemiesV=stream.readInt();
			
			enemiesT[enemiesI]=enemiesV;
		}
		
		int friendsLen=stream.readLen();
		if(this.friends==null || this.friends.Length!=friendsLen)
		{
			this.friends=new int[friendsLen];
		}
		int[] friendsT=this.friends;
		for(int friendsI=0;friendsI<friendsLen;++friendsI)
		{
			int friendsV;
			friendsV=stream.readInt();
			
			friendsT[friendsI]=friendsV;
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		if(this.enemies!=null)
		{
			int[] enemiesT=this.enemies;
			stream.writeLen(enemiesT.Length);
			for(int enemiesVI=0,enemiesVLen=enemiesT.Length;enemiesVI<enemiesVLen;++enemiesVI)
			{
				int enemiesV=enemiesT[enemiesVI];
				stream.writeInt(enemiesV);
				
			}
		}
		else
		{
			nullObjError("enemies");
		}
		
		if(this.friends!=null)
		{
			int[] friendsT=this.friends;
			stream.writeLen(friendsT.Length);
			for(int friendsVI=0,friendsVLen=friendsT.Length;friendsVI<friendsVLen;++friendsVI)
			{
				int friendsV=friendsT[friendsVI];
				stream.writeInt(friendsV);
				
			}
		}
		else
		{
			nullObjError("friends");
		}
		
	}
	
	protected override void afterReadConfig()
	{
		base.afterReadConfig();

		againstSet=new int[SceneForceType.size];

		foreach(int v in friends)
		{
			againstSet[v]=UnitAgainstType.Friend;
		}

		foreach(int v in enemies)
		{
			againstSet[v]=UnitAgainstType.Enemy;
		}
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
}
