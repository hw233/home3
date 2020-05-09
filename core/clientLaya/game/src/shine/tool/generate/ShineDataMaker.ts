namespace Shine
{
	/** (generated by shine) */
	export class ShineDataMaker extends DataMaker
	{
		constructor()
		{
			super();
			this.offSet=ShineDataType.off;
			this.list=new Array<Function>(ShineDataType.count-this.offSet);
			this.list[ShineDataType.DInt-this.offSet]=this.createDIntData;
			this.list[ShineDataType.Date-this.offSet]=this.createDateData;
			this.list[ShineDataType.SecondPass-this.offSet]=this.createSecondPassData;
			this.list[ShineDataType.TimePass-this.offSet]=this.createTimePassData;
			this.list[ShineDataType.TriggerBoolean-this.offSet]=this.createTriggerBooleanData;
			this.list[ShineDataType.TriggerConfig-this.offSet]=this.createTriggerConfigData;
			this.list[ShineDataType.TriggerFloat-this.offSet]=this.createTriggerFloatData;
			this.list[ShineDataType.TriggerFunc-this.offSet]=this.createTriggerFuncData;
			this.list[ShineDataType.TriggerFuncList-this.offSet]=this.createTriggerFuncListData;
			this.list[ShineDataType.TriggerInt-this.offSet]=this.createTriggerIntData;
			this.list[ShineDataType.TriggerList-this.offSet]=this.createTriggerListData;
			this.list[ShineDataType.TriggerLong-this.offSet]=this.createTriggerLongData;
			this.list[ShineDataType.TriggerObj-this.offSet]=this.createTriggerObjData;
			this.list[ShineDataType.TriggerString-this.offSet]=this.createTriggerStringData;
			this.list[ShineDataType.UIObject-this.offSet]=this.createUIObjectData;
			this.list[ShineDataType.BigNumber-this.offSet]=this.createBigNumberData;
		}
		
		private createTriggerConfigData():BaseData
		{
			return new TriggerConfigData();
		}
		
		private createTriggerListData():BaseData
		{
			return new TriggerListData();
		}
		
		private createTriggerBooleanData():BaseData
		{
			return new TriggerBooleanData();
		}
		
		private createTriggerFuncData():BaseData
		{
			return new TriggerFuncData();
		}
		
		private createTriggerIntData():BaseData
		{
			return new TriggerIntData();
		}
		
		private createTriggerFloatData():BaseData
		{
			return new TriggerFloatData();
		}
		
		private createTriggerStringData():BaseData
		{
			return new TriggerStringData();
		}
		
		private createTriggerLongData():BaseData
		{
			return new TriggerLongData();
		}
		
		private createTriggerObjData():BaseData
		{
			return new TriggerObjData();
		}
		
		private createTriggerFuncListData():BaseData
		{
			return new TriggerFuncListData();
		}
		
		private createDateData():BaseData
		{
			return new DateData();
		}
		
		private createTimePassData():BaseData
		{
			return new TimePassData();
		}
		
		private createUIObjectData():BaseData
		{
			return new UIObjectData();
		}
		
		private createSecondPassData():BaseData
		{
			return new SecondPassData();
		}
		
		private createDIntData():BaseData
		{
			return new DIntData();
		}
		
		private createBigNumberData():BaseData
		{
			return new BigNumberData();
		}
		
	}
}
