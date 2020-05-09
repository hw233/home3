package com.home.shine.data;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.constlist.generate.ShineDataType;
import com.home.shine.control.DateControl;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.global.ShineSetting;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 时间经过数据(generated by shine) */
public class TimePassData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=ShineDataType.TimePass;
	
	/** 上次检查时间 */
	protected long _lastCheckTime;
	
	/** 走过的时间 */
	public int timePass;
	
	/** 时间上限 */
	public int timeMax;
	
	/** 是否暂停(不写入) */
	private boolean _isPause=false;
	
	/** 是否将超出的经过时间回归 */
	private boolean _needCut=true;
	
	public TimePassData()
	{
		_dataID=ShineDataType.TimePass;
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.timePass=stream.readInt();
		
		this.timeMax=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.timePass);
		
		stream.writeInt(this.timeMax);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.timePass=stream.readInt();
		
		this.timeMax=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.timePass);
		
		stream.writeInt(this.timeMax);
		
	}
	
	/** 写前 */
	protected void beforeWrite()
	{
		runTime();
	}
	
	/** 读后 */
	protected void afterRead()
	{
		//修复逻辑
		if(timePass<0)
		{
			timePass=0;
		}
		
		_lastCheckTime=DateControl.getTimeMillis();
	}
	
	/** 重新设置个值起跑 */
	public void init(int timeMax)
	{
		this.timeMax=timeMax;
		reStart();
	}
	
	@Override
	public void clear()
	{
		timeMax=-1;
		reStart();
	}
	
	/** 是否为空 */
	public boolean isNone()
	{
		return timeMax==-1;
	}
	
	/** 重新走(不改变速度) */
	public void reStart()
	{
		timePass=0;
		_lastCheckTime=DateControl.getTimeMillis();
	}
	
	/** 设置为已结束 */
	public void setOver()
	{
		addTimePass(getLastTime());
	}
	
	/** 暂停 */
	public void pause(boolean bool)
	{
		if(_isPause==bool)
		{
			return;
		}
		
		runTime();
		
		_isPause=bool;
	}
	
	/** 设置是否需要截断 */
	public void setNeedCut(boolean bool)
	{
		if(_needCut==bool)
		{
			return;
		}
		
		_needCut=bool;
		
		runTime();
		
		checkAddMax();
	}
	
	/** 添加时间上限 */
	public void addTimeMax(int addTimeMax)
	{
		setTimeMax(timeMax + addTimeMax);
	}
	
	/** 设定时间上限 */
	public void setTimeMax(int timeMax)
	{
		runTime();
		
		this.timeMax=timeMax;
		
		checkAddMax();
	}
	
	/** 获取经过时间(整形) */
	public int getTimePass()
	{
		runTime();
		
		return timePass;
	}
	
	/** 增加经过时间 */
	public void addTimePass(int time)
	{
		runTime();
		
		if(!isNone())
		{
			timePass+=time;
			
			checkAddMax();
		}
	}
	
	/** 减少经过时间 */
	public void disTimePass(int time)
	{
		runTime();
		
		if(!isNone())
		{
			timePass-=time;
			
			checkAddMax();
		}
	}
	
	/** 获取剩余时间 */
	public int getLastTime()
	{
		runTime();
		
		if(isNone())
		{
			return 0;
		}
		
		//超时返回0
		if(timePass >= timeMax)
		{
			return 0;
		}
		
		return timeMax - timePass;
	}
	
	/** 获取是否结束 */
	public boolean isOver()
	{
		runTime();
		
		if(isNone())
		{
			return false;
		}
		
		return timePass >= timeMax;
	}
	
	/** 客户端是否结束(时间验证系数) */
	public boolean isClientOver()
	{
		runTime();
		
		if(isNone())
		{
			return false;
		}
		
		return timePass >= timeMax - ShineSetting.timeCheckDeviation;
	}
	
	/** 将时间校对到现在时刻 */
	public void runTime()
	{
		long time=DateControl.getTimeMillis();
		
		if(!isNone())
		{
			//未暂停
			if(!_isPause)
			{
				int delay=(int)(time - _lastCheckTime);
				
				if(delay>0)
				{
					toAddTime(delay);
					checkAddMax();
				}
			}
		}
		
		_lastCheckTime=time;
	}
	
	/** 增加时间(计算过速度了) */
	protected void toAddTime(int delay)
	{
		timePass+=delay;
	}
	
	private void checkAddMax()
	{
		if(_needCut && timeMax>0 && timePass>timeMax)
		{
			timePass=timeMax;
		}
	}
	
	public void fullTime()
	{
		if(timeMax<0)
		{
			return;
		}
		
		addTimePass(timeMax);
	}
	
	/** 创建并开始计时 */
	public static TimePassData create(int timeMax)
	{
		TimePassData re=new TimePassData();
		re.timeMax=timeMax;
		re.reStart();
		
		return re;
	}
	
	/** 创建一个结束计时的 */
	public static TimePassData createForOver(int timeMax)
	{
		TimePassData re=new TimePassData();
		re.timeMax=timeMax;
		re.timePass=timeMax;
		re._lastCheckTime=DateControl.getTimeMillis();
		
		return re;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "TimePassData";
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof TimePassData))
			return;
		
		TimePassData mData=(TimePassData)data;
		
		this.timePass=mData.timePass;
		this.timeMax=mData.timeMax;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof TimePassData))
			return;
		
		TimePassData mData=(TimePassData)data;
		
		this.timePass=mData.timePass;
		
		this.timeMax=mData.timeMax;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		TimePassData mData=(TimePassData)data;
		if(this.timePass!=mData.timePass)
			return false;
		
		if(this.timeMax!=mData.timeMax)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("timePass");
		writer.sb.append(':');
		writer.sb.append(this.timePass);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("timeMax");
		writer.sb.append(':');
		writer.sb.append(this.timeMax);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.timePass=0;
		this.timeMax=0;
	}
	
}
