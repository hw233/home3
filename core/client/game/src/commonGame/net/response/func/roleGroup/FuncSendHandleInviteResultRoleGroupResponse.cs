using ShineEngine;

/// <summary>
/// 推送处理邀请结果到邀请者(generated by shine)
/// </summary>
public class FuncSendHandleInviteResultRoleGroupResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncSendHandleInviteResultRoleGroup;
	
	/// <summary>
	/// 被邀请者
	/// </summary>
	public RoleShowData showData;
	
	public int result;
	
	public FuncSendHandleInviteResultRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncSendHandleInviteResultRoleGroup;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncSendHandleInviteResultRoleGroupResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData showDataT=stream.readDataFullNotNull();
		if(showDataT!=null)
		{
			if(showDataT is RoleShowData)
			{
				this.showData=(RoleShowData)showDataT;
			}
			else
			{
				this.showData=new RoleShowData();
				if(!(showDataT.GetType().IsAssignableFrom(typeof(RoleShowData))))
				{
					stream.throwTypeReadError(typeof(RoleShowData),showDataT.GetType());
				}
				this.showData.shadowCopy(showDataT);
			}
		}
		else
		{
			this.showData=null;
		}
		
		this.result=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.showData=(RoleShowData)stream.readDataSimpleNotNull();
		
		this.result=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("showData");
		writer.sb.Append(':');
		if(this.showData!=null)
		{
			this.showData.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("RoleShowData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("result");
		writer.sb.Append(':');
		writer.sb.Append(this.result);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.func.getRoleGroupTool(funcID).onInviteResult(showData,result);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.showData=null;
		this.result=0;
	}
	
}
