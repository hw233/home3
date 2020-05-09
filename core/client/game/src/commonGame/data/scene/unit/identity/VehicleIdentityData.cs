using ShineEngine;

/// <summary>
/// 载具身份数据(generated by shine)
/// </summary>
public class VehicleIdentityData:FightUnitIdentityData
{
	/// <summary>
	/// 驾驶组
	/// </summary>
	public IntList drivers;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.VehicleIdentity;
	
	public VehicleIdentityData()
	{
		_dataID=BaseDataType.VehicleIdentity;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "VehicleIdentityData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int driversLen=stream.readLen();
		if(this.drivers!=null)
		{
			this.drivers.clear();
			this.drivers.ensureCapacity(driversLen);
		}
		else
		{
			this.drivers=new IntList();
		}
		
		IntList driversT=this.drivers;
		for(int driversI=driversLen-1;driversI>=0;--driversI)
		{
			int driversV;
			driversV=stream.readInt();
			
			driversT.add(driversV);
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.drivers!=null)
		{
			stream.writeLen(this.drivers.size());
			if(!this.drivers.isEmpty())
			{
				int[] driversVValues=this.drivers.getValues();
				for(int driversVI=0,driversVLen=this.drivers.length();driversVI<driversVLen;++driversVI)
				{
					int driversV=driversVValues[driversVI];
					stream.writeInt(driversV);
					
				}
			}
		}
		else
		{
			nullObjError("drivers");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		int driversLen=stream.readLen();
		if(this.drivers!=null)
		{
			this.drivers.clear();
			this.drivers.ensureCapacity(driversLen);
		}
		else
		{
			this.drivers=new IntList();
		}
		
		IntList driversT=this.drivers;
		for(int driversI=driversLen-1;driversI>=0;--driversI)
		{
			int driversV;
			driversV=stream.readInt();
			
			driversT.add(driversV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.drivers!=null)
		{
			stream.writeLen(this.drivers.size());
			if(!this.drivers.isEmpty())
			{
				int[] driversVValues=this.drivers.getValues();
				for(int driversVI=0,driversVLen=this.drivers.length();driversVI<driversVLen;++driversVI)
				{
					int driversV=driversVValues[driversVI];
					stream.writeInt(driversV);
					
				}
			}
		}
		else
		{
			nullObjError("drivers");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is VehicleIdentityData))
			return;
		
		VehicleIdentityData mData=(VehicleIdentityData)data;
		
		this.drivers=mData.drivers;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is VehicleIdentityData))
			return;
		
		VehicleIdentityData mData=(VehicleIdentityData)data;
		
		if(mData.drivers!=null)
		{
			if(this.drivers!=null)
			{
				this.drivers.clear();
				this.drivers.ensureCapacity(mData.drivers.size());
			}
			else
			{
				this.drivers=new IntList();
			}
			
			IntList driversT=this.drivers;
			if(!mData.drivers.isEmpty())
			{
				int[] driversVValues=mData.drivers.getValues();
				for(int driversVI=0,driversVLen=mData.drivers.length();driversVI<driversVLen;++driversVI)
				{
					int driversV=driversVValues[driversVI];
					int driversU;
					driversU=driversV;
					
					driversT.add(driversU);
				}
			}
		}
		else
		{
			this.drivers=null;
			nullObjError("drivers");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		VehicleIdentityData mData=(VehicleIdentityData)data;
		if(mData.drivers!=null)
		{
			if(this.drivers==null)
				return false;
			if(this.drivers.size()!=mData.drivers.size())
				return false;
			IntList driversT=this.drivers;
			IntList driversR=mData.drivers;
			int driversLen=driversT.size();
			for(int driversI=0;driversI<driversLen;++driversI)
			{
				int driversU=driversT.get(driversI);
				int driversV=driversR.get(driversI);
				if(driversU!=driversV)
					return false;
				
			}
		}
		else
		{
			if(this.drivers!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("drivers");
		writer.sb.Append(':');
		writer.sb.Append("List<int>");
		if(this.drivers!=null)
		{
			IntList driversT=this.drivers;
			int driversLen=driversT.size();
			writer.sb.Append('(');
			writer.sb.Append(driversLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int driversI=0;driversI<driversLen;++driversI)
			{
				int driversV=driversT.get(driversI);
				writer.writeTabs();
				writer.sb.Append(driversI);
				writer.sb.Append(':');
				writer.sb.Append(driversV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.drivers=new IntList();
	}
	
	public override int getFightUnitID()
	{
		return VehicleConfig.get(id).fightUnitID;
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.drivers=null;
	}
	
}
