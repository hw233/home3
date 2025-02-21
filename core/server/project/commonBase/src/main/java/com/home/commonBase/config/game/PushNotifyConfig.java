package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.config.game.LanguageConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;

/** 推送表(generated by shine) */
public class PushNotifyConfig extends BaseConfig
{
	/** 存储集合 */
	private static PushNotifyConfig[] _dic;
	
	/** id */
	public int id;
	
	/** 参数1 */
	public int[] param1;
	
	/** 标题 */
	public String title="";
	
	/** 用户标签 */
	public int topicType;
	
	/** 描述 */
	public String describe2="";
	
	/** 本地还是远程推送 */
	public int pushType;
	
	/** 文字 */
	public String text="";
	
	/** 标题原值 */
	private String _title;
	
	/** 文字原值 */
	private String _text;
	
	/** 获取 */
	public static PushNotifyConfig get(int id)
	{
		return id>=0 && id<_dic.length ? _dic[id] : null;
	}
	
	/** 设置字典 */
	public static void setDic(PushNotifyConfig[] dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static PushNotifyConfig[] getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		int param1Len=stream.readLen();
		if(this.param1==null || this.param1.length!=param1Len)
		{
			this.param1=new int[param1Len];
		}
		int[] param1T=this.param1;
		for(int param1I=0;param1I<param1Len;++param1I)
		{
			int param1V;
			param1V=stream.readInt();
			
			param1T[param1I]=param1V;
		}
		
		this.title=stream.readUTF();
		
		this.text=stream.readUTF();
		
		this.topicType=stream.readInt();
		
		this.pushType=stream.readInt();
		
		this.describe2=stream.readUTF();
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		if(this.param1!=null)
		{
			int[] param1T=this.param1;
			stream.writeLen(param1T.length);
			for(int param1VI=0,param1VLen=param1T.length;param1VI<param1VLen;++param1VI)
			{
				int param1V=param1T[param1VI];
				stream.writeInt(param1V);
				
			}
		}
		else
		{
			nullObjError("param1");
		}
		
		stream.writeUTF(this.title);
		
		stream.writeUTF(this.text);
		
		stream.writeInt(this.topicType);
		
		stream.writeInt(this.pushType);
		
		stream.writeUTF(this.describe2);
		
	}
	
	/** 生成刷新配置 */
	@Override
	protected void generateRefresh()
	{
		if(_title==null)
			_title=title;
		title=LanguageConfig.getText(_title);
		
		if(_text==null)
			_text=text;
		text=LanguageConfig.getText(_text);
		
	}
	
}
