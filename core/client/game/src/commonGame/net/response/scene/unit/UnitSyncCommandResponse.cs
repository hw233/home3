using ShineEngine;

/// <summary>
/// 单位同步指令消息(generated by shine)
/// </summary>
public class UnitSyncCommandResponse:UnitSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.UnitSyncCommand;
	
	/// <summary>
	/// 当前位置
	/// </summary>
	public PosDirData posDir;
	
	/// <summary>
	/// 指令
	/// </summary>
	public int type;
	
	/// <summary>
	/// 整形参数组
	/// </summary>
	public int[] ints;
	
	/// <summary>
	/// float参数组
	/// </summary>
	public float[] floats;
	
	public UnitSyncCommandResponse()
	{
		_dataID=GameResponseType.UnitSyncCommand;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		unit.move.onServerSyncCommand(posDir,type,ints,floats);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitSyncCommandResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.posDir=(PosDirData)stream.createData(PosDirData.dataID);
		this.posDir.readBytesFull(stream);
		
		this.type=stream.readInt();
		
		int intsLen=stream.readLen();
		if(this.ints==null || this.ints.Length!=intsLen)
		{
			this.ints=new int[intsLen];
		}
		int[] intsT=this.ints;
		for(int intsI=0;intsI<intsLen;++intsI)
		{
			int intsV;
			intsV=stream.readInt();
			
			intsT[intsI]=intsV;
		}
		
		int floatsLen=stream.readLen();
		if(this.floats==null || this.floats.Length!=floatsLen)
		{
			this.floats=new float[floatsLen];
		}
		float[] floatsT=this.floats;
		for(int floatsI=0;floatsI<floatsLen;++floatsI)
		{
			float floatsV;
			floatsV=stream.readFloat();
			
			floatsT[floatsI]=floatsV;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.posDir=(PosDirData)stream.createData(PosDirData.dataID);
		this.posDir.readBytesSimple(stream);
		
		this.type=stream.readInt();
		
		int intsLen=stream.readLen();
		if(this.ints==null || this.ints.Length!=intsLen)
		{
			this.ints=new int[intsLen];
		}
		int[] intsT=this.ints;
		for(int intsI=0;intsI<intsLen;++intsI)
		{
			int intsV;
			intsV=stream.readInt();
			
			intsT[intsI]=intsV;
		}
		
		int floatsLen=stream.readLen();
		if(this.floats==null || this.floats.Length!=floatsLen)
		{
			this.floats=new float[floatsLen];
		}
		float[] floatsT=this.floats;
		for(int floatsI=0;floatsI<floatsLen;++floatsI)
		{
			float floatsV;
			floatsV=stream.readFloat();
			
			floatsT[floatsI]=floatsV;
		}
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("posDir");
		writer.sb.Append(':');
		if(this.posDir!=null)
		{
			this.posDir.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("PosDirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("ints");
		writer.sb.Append(':');
		writer.sb.Append("Array<int>");
		if(this.ints!=null)
		{
			int[] intsT=this.ints;
			int intsLen=intsT.Length;
			writer.sb.Append('(');
			writer.sb.Append(intsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int intsI=0;intsI<intsLen;++intsI)
			{
				int intsV=intsT[intsI];
				writer.writeTabs();
				writer.sb.Append(intsI);
				writer.sb.Append(':');
				writer.sb.Append(intsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("floats");
		writer.sb.Append(':');
		writer.sb.Append("Array<float>");
		if(this.floats!=null)
		{
			float[] floatsT=this.floats;
			int floatsLen=floatsT.Length;
			writer.sb.Append('(');
			writer.sb.Append(floatsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int floatsI=0;floatsI<floatsLen;++floatsI)
			{
				float floatsV=floatsT[floatsI];
				writer.writeTabs();
				writer.sb.Append(floatsI);
				writer.sb.Append(':');
				writer.sb.Append(floatsV);
				
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
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.posDir=null;
		this.type=0;
		this.ints=null;
		this.floats=null;
	}
	
}
