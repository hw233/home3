using ShineEngine;

/// <summary>
/// 技能步骤表(generated by shine)
/// </summary>
public class SkillStepConfig:BaseConfig
{
	/** 存储集合 */
	private static LongObjectMap<SkillStepConfig> _dic;
	
	/// <summary>
	/// 技能id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 步骤
	/// </summary>
	public int step;
	
	/// <summary>
	/// 攻击组
	/// </summary>
	public DIntData[] attacks;
	
	/// <summary>
	/// 步骤时间(ms)
	/// </summary>
	public int time;
	
	/// <summary>
	/// 子弹组
	/// </summary>
	public DIntData[] bullets;
	
	/// <summary>
	/// 动作ID
	/// </summary>
	public int motionID;
	
	/// <summary>
	/// 是否滞空(对于空中动作)
	/// </summary>
	public bool isStayAir;
	
	/// <summary>
	/// 切换方式
	/// </summary>
	public int[] switchType;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static SkillStepConfig get(int id,int step)
	{
		return _dic.get((long)id << 8 | (long)step);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(LongObjectMap<SkillStepConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(LongObjectMap<SkillStepConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static LongObjectMap<SkillStepConfig> getDic()
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
		
		this.step=stream.readByte();
		
		int attacksLen=stream.readLen();
		if(this.attacks==null || this.attacks.Length!=attacksLen)
		{
			this.attacks=new DIntData[attacksLen];
		}
		DIntData[] attacksT=this.attacks;
		for(int attacksI=0;attacksI<attacksLen;++attacksI)
		{
			DIntData attacksV;
			attacksV=(DIntData)stream.createData(DIntData.dataID);
			attacksV.readBytesSimple(stream);
			
			attacksT[attacksI]=attacksV;
		}
		
		int bulletsLen=stream.readLen();
		if(this.bullets==null || this.bullets.Length!=bulletsLen)
		{
			this.bullets=new DIntData[bulletsLen];
		}
		DIntData[] bulletsT=this.bullets;
		for(int bulletsI=0;bulletsI<bulletsLen;++bulletsI)
		{
			DIntData bulletsV;
			bulletsV=(DIntData)stream.createData(DIntData.dataID);
			bulletsV.readBytesSimple(stream);
			
			bulletsT[bulletsI]=bulletsV;
		}
		
		this.time=stream.readInt();
		
		int switchTypeLen=stream.readLen();
		if(this.switchType==null || this.switchType.Length!=switchTypeLen)
		{
			this.switchType=new int[switchTypeLen];
		}
		int[] switchTypeT=this.switchType;
		for(int switchTypeI=0;switchTypeI<switchTypeLen;++switchTypeI)
		{
			int switchTypeV;
			switchTypeV=stream.readInt();
			
			switchTypeT[switchTypeI]=switchTypeV;
		}
		
		this.motionID=stream.readInt();
		
		this.isStayAir=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		if(_dic==null)
			return;

		SkillStepConfig[] values;
		SkillStepConfig v;

		for(int i=(values=_dic.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				//空的
				if(v.switchType==null || v.switchType.Length==0)
				{
					//有下一个
					if(get(v.id,v.step+1)!=null)
					{
						v.switchType=new int[]{SkillStepSwitchType.Auto,v.step+1};
					}
					else
					{
						if(v.switchType==null)
						{
							v.switchType=new int[0];
						}
					}
				}
			}
		}
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeByte(this.step);
		
		if(this.attacks!=null)
		{
			DIntData[] attacksT=this.attacks;
			stream.writeLen(attacksT.Length);
			for(int attacksVI=0,attacksVLen=attacksT.Length;attacksVI<attacksVLen;++attacksVI)
			{
				DIntData attacksV=attacksT[attacksVI];
				if(attacksV!=null)
				{
					attacksV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("attacksV");
				}
				
			}
		}
		else
		{
			nullObjError("attacks");
		}
		
		if(this.bullets!=null)
		{
			DIntData[] bulletsT=this.bullets;
			stream.writeLen(bulletsT.Length);
			for(int bulletsVI=0,bulletsVLen=bulletsT.Length;bulletsVI<bulletsVLen;++bulletsVI)
			{
				DIntData bulletsV=bulletsT[bulletsVI];
				if(bulletsV!=null)
				{
					bulletsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("bulletsV");
				}
				
			}
		}
		else
		{
			nullObjError("bullets");
		}
		
		stream.writeInt(this.time);
		
		if(this.switchType!=null)
		{
			int[] switchTypeT=this.switchType;
			stream.writeLen(switchTypeT.Length);
			for(int switchTypeVI=0,switchTypeVLen=switchTypeT.Length;switchTypeVI<switchTypeVLen;++switchTypeVI)
			{
				int switchTypeV=switchTypeT[switchTypeVI];
				stream.writeInt(switchTypeV);
				
			}
		}
		else
		{
			nullObjError("switchType");
		}
		
		stream.writeInt(this.motionID);
		
		stream.writeBoolean(this.isStayAir);
		
	}
	
}
