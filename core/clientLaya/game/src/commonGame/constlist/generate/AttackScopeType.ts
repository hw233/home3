namespace Shine
{
	/** 攻击范围类型(generated by shine) */
	export class AttackScopeType
	{
		/** 无目标 */
		public static None:number=0;
		
		/** 自身 */
		public static Self:number=1;
		
		/** 单体 */
		public static Single:number=2;
		
		/** 2D攻击矩形(act用)(arg0-3:x,y,width,height) */
		public static AttackRect:number=3;
		
		/** 自身圆形范围(arg0:半径,[arg1:高度]) */
		public static SelfCircle:number=11;
		
		/** 目标圆形范围(arg0:半径,[arg1:高度]) */
		public static TargetCircle:number=12;
		
		/** 自身矩形范围(arg0:长(纵向),arg1:宽(横向),[arg2:高度]) */
		public static SelfRect:number=13;
		
		/** 自身扇形范围(arg0:半径,arg1:扇角,[arg2:高度]) */
		public static SelfSector:number=14;
		
		/** 自身圆形范围内最近的几个目标(arg0:半径,arg1:目标数,[arg2:高度]) */
		public static SelfCircleNear:number=15;
		
		/** 自身圆形范围内随机的几个目标(arg0:半径,arg1:目标数,[arg2:高度]) */
		public static SelfCircleRandom:number=16;
		
		/** 自身圆形范围内最近的一个目标(arg0:半径,[arg1:高度]) */
		public static SelfNearest:number=17;
		
		/** 2D周身(act用)(arg0:半径,arg1:高度) */
		public static Around2D:number=21;
		
		/** 长度 */
		public static size:number=22;
		
	}
}
