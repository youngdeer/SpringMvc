package springTest.beans;
/**
 * 类上定义静态属性保持该实例
 * @author luyang
 */
public class Singleton {
	//私有化构造器
	private Singleton(){};
	//单例缓存者，惰性初始化，第一次使用时初始化
	private static class InstanceHloder{
		private static Singleton INSTANCE = new Singleton();
	}
	//全局访问点
	public static Singleton getInstance(){
		return InstanceHloder.INSTANCE;
	}
	//提供一个计数器来验证一个ClassLoader一个实例
	private int counter = 0;
}
