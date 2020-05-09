namespace Shine
{
	/** 游戏服(角色)离线事务数据(废弃)(generated by shine) */
	export class GameGlobalWorkData extends WorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.GameGlobalWork;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.GameGlobalWork;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "GameGlobalWorkData";
		}
		
	}
}
