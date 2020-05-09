package com.home.commonGame.net.request.login;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 初始化客户端消息(ClientListData)(此处需要使用copy,因工具已改为潜拷,为了逻辑层避开深拷问题)(generated by shine) */
public class InitClientRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.InitClient;
	
	/** 配置热更数据 */
	public byte[] configHotfix;
	
	/** 客户端列表数据 */
	public BaseData listData;
	
	public InitClientRequest()
	{
		_dataID=GameRequestType.InitClient;
		setLongMessage();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		BaseData listDataTemp=listData;
		if(listDataTemp!=null)
		{
			this.listData=(BaseData)listDataTemp.clone();
		}
		else
		{
			this.listData=null;
			nullObjError("listData");
		}
		
		byte[] configHotfixTemp=configHotfix;
		if(configHotfixTemp!=null)
		{
			this.configHotfix=BytesControl.byteArrCopy(configHotfixTemp);
		}
		else
		{
			this.configHotfix=null;
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "InitClientRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("listData");
		writer.sb.append(':');
		if(this.listData!=null)
		{
			this.listData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("BaseData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("configHotfix");
		writer.sb.append(':');
		writer.sb.append("Array<byte>");
		if(this.configHotfix!=null)
		{
			byte[] configHotfixT=this.configHotfix;
			int configHotfixLen=configHotfixT.length;
			writer.sb.append('(');
			writer.sb.append(configHotfixLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int configHotfixI=0;configHotfixI<configHotfixLen;++configHotfixI)
			{
				byte configHotfixV=configHotfixT[configHotfixI];
				writer.writeTabs();
				writer.sb.append(configHotfixI);
				writer.sb.append(':');
				writer.sb.append(configHotfixV);
				
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.listData!=null)
		{
			stream.writeDataFullNotNull(this.listData);
		}
		else
		{
			nullObjError("listData");
		}
		
		if(this.configHotfix!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.configHotfix.length);
			stream.writeByteArr(this.configHotfix);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.listData!=null)
		{
			stream.writeDataSimpleNotNull(this.listData);
		}
		else
		{
			nullObjError("listData");
		}
		
		if(this.configHotfix!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.configHotfix.length);
			stream.writeByteArr(this.configHotfix);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	protected void doWriteToStream(BytesWriteStream stream)
	{
		int pos=stream.getPosition();
		
		super.doWriteToStream(stream);
		
		//stream.writeByteArr(_aa);
		
		//Ctrl.log("InitClient消息长度",stream.getPosition()-pos);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.listData.release(pool);
		this.listData=null;
	}
	
	/** 创建实例 */
	public static InitClientRequest create(BaseData listData,byte[] configHotfix)
	{
		InitClientRequest re=(InitClientRequest)BytesControl.createRequest(dataID);
		re.listData=listData;
		re.configHotfix=configHotfix;
		return re;
	}
	
}
