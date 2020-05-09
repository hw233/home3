package com.home.commonBase.data.scene.base;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 区域数据(generated by shine) */
public class RegionData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.Region;
	
	/** 实例ID */
	public int instanceID;
	
	/** id */
	public int id;
	
	/** 参数组 */
	public float[] args;
	
	public RegionData()
	{
		_dataID=BaseDataType.Region;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RegionData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		this.id=stream.readInt();
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.length!=argsLen)
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
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.id);
		
		if(this.args!=null)
		{
			float[] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				float argsV=argsT[argsVI];
				stream.writeFloat(argsV);
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.instanceID=stream.readInt();
		
		this.id=stream.readInt();
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.length!=argsLen)
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
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.id);
		
		if(this.args!=null)
		{
			float[] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				float argsV=argsT[argsVI];
				stream.writeFloat(argsV);
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof RegionData))
			return;
		
		RegionData mData=(RegionData)data;
		
		this.instanceID=mData.instanceID;
		this.id=mData.id;
		this.args=mData.args;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof RegionData))
			return;
		
		RegionData mData=(RegionData)data;
		
		this.instanceID=mData.instanceID;
		
		this.id=mData.id;
		
		if(mData.args!=null)
		{
			float[] argsR=mData.args;
			int argsLen=argsR.length;
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new float[argsLen];
			}
			BytesControl.arrayCopy(mData.args,this.args,argsLen);
		}
		else
		{
			this.args=null;
			nullObjError("args");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		RegionData mData=(RegionData)data;
		if(this.instanceID!=mData.instanceID)
			return false;
		
		if(this.id!=mData.id)
			return false;
		
		if(mData.args!=null)
		{
			if(this.args==null)
				return false;
			if(this.args.length!=mData.args.length)
				return false;
			float[] argsT=this.args;
			float[] argsR=mData.args;
			int argsLen=argsT.length;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				float argsU=argsT[argsI];
				float argsV=argsR[argsI];
				if(argsU!=argsV)
					return false;
				
			}
		}
		else
		{
			if(this.args!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("args");
		writer.sb.append(':');
		writer.sb.append("Array<float>");
		if(this.args!=null)
		{
			float[] argsT=this.args;
			int argsLen=argsT.length;
			writer.sb.append('(');
			writer.sb.append(argsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				float argsV=argsT[argsI];
				writer.writeTabs();
				writer.sb.append(argsI);
				writer.sb.append(':');
				writer.sb.append(argsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.args=new float[0];
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.instanceID=0;
		this.id=0;
		this.args=null;
	}
	
}
