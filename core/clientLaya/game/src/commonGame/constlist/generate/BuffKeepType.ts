namespace Shine
{
	/** buff保留类型(CD保留类型也用这个)(generated by shine) */
	export class BuffKeepType
	{
		/** 一直存在,并存库(双倍经验药水类)(CD道具技能类,长CD类) */
		public static Always:number=1;
		
		/** 在线存在(下线删除)(被动技能类)(CD道具技能类) */
		public static Online:number=2;
		
		/** 在主城类场景中存在(离开主城类场景删除)(中长时间buff类)(中长时间CD类) */
		public static InTown:number=3;
		
		/** 在当前场景中存在(副本类)(离开当前类场景时删除)(当前场景战斗buff,dot类)(当前场景战斗CD类) */
		public static InCurrentScene:number=4;
		
		/** 长度 */
		public static size:number=5;
		
	}
}
