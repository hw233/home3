using ShineEngine;

/// <summary>
/// 特殊移动表(generated by shine)
/// </summary>
public class SpecialMoveConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SpecialMoveConfig> _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 动作id
	/// </summary>
	public int motionID;
	
	/// <summary>
	/// 参数组
	/// </summary>
	public float[] args;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static SpecialMoveConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<SpecialMoveConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<SpecialMoveConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<SpecialMoveConfig> getDic()
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
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.Length!=argsLen)
		{
			this.args=new float[argsLen];
		}
		float[] argsT=this.args;
		for(int argsI=0;argsI<argsLen;++argsI)
		{
			float argsV;
			argsV=stream.readFloat();
			
			argsT[argsI]=argsV;
		}
		
		this.motionID=stream.readInt();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.type);
		
		if(this.args!=null)
		{
			float[] argsT=this.args;
			stream.writeLen(argsT.Length);
			for(int argsVI=0,argsVLen=argsT.Length;argsVI<argsVLen;++argsVI)
			{
				float argsV=argsT[argsVI];
				stream.writeFloat(argsV);
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
		stream.writeInt(this.motionID);
		
	}
	
}
