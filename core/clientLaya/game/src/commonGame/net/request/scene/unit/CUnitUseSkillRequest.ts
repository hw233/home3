namespace Shine
{
	/** 玩家单位使用技能(generated by shine) */
	export class CUnitUseSkillRequest extends CUnitRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.CUnitUseSkill;
		
		/** 技能ID */
		public skillID:number;
		
		/** 目标数据 */
		public targetData:SkillTargetData;
		
		/** 当前单位位置数据 */
		public posDir:PosDirData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.CUnitUseSkill;
		}
		
		protected copyData():void
		{
			super.copyData();
			var targetDataTemp:SkillTargetData=this.targetData;
			this.targetData=targetDataTemp.clone() as SkillTargetData;
			
			var posDirTemp:PosDirData=this.posDir;
			this.posDir=new PosDirData();
			this.posDir.copy(posDirTemp);
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CUnitUseSkillRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.skillID);
			
			stream.writeDataSimpleNotNull(this.targetData);
			
			this.posDir.writeBytesSimple(stream);
			
		}
		
		/** 创建实例 */
		public static createCUnitUseSkill(instanceID:number,skillID:number,targetData:SkillTargetData,posDir:PosDirData):CUnitUseSkillRequest
		{
			var re:CUnitUseSkillRequest=new CUnitUseSkillRequest();
			re.instanceID=instanceID;
			re.skillID=skillID;
			re.targetData=targetData;
			re.posDir=posDir;
			return re;
		}
		
	}
}
