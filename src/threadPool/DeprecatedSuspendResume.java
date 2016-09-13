package threadPool;

public class DeprecatedSuspendResume implements Runnable {

	//volatile关键字，表示该变量可能在被一个线程使用的同时，被另一个线程修改
	private volatile int firstVal;
	private volatile int secondVal;
	private volatile boolean suspended;
	
	public boolean areValusEqual(){
		return (firstVal == secondVal);
	}
	
	@Override
	public void run() {
		try {
			firstVal = 0;
			secondVal = 0;
			workMethod ();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in workMethod()");
		}
	}
	
	private void workMethod () throws InterruptedException{
		int val = 1;
		while(true){
			//仅当线程挂起时才执行这段代码
			waitWhileSuspended();
			
			stepOne(val);
			stepTwo(val);
			val++;
			
			//仅当线程挂起时才执行这段代码
			waitWhileSuspended();
			
			Thread.sleep(200);//再次循环前休眠200豪秒
		}
	}
	
	//赋值后，休眠300豪秒，从而使线程有机会在stepone操作和steptwo操作之间被挂起
	private void stepOne(int newVal) throws InterruptedException{
		firstVal = newVal;
		Thread.sleep(300);//模拟长时间运行情况
	}
	
	private void stepTwo(int newVal){
		secondVal = newVal;
	}

	public void suspendRequest(){
		suspended = true;
	}
	
	public void resumeRequest(){
		suspended = false;
	}
	
	private void waitWhileSuspended() throws InterruptedException{
		//这是一个“繁忙等待”技术的事例
		//它是非等待条件的最佳途径，因为它会不断请求处理器周期的执行检查
		//更佳的实现是java内置的“通知-等待”机制
		while(suspended){
			Thread.sleep(200);
		}
	}
	
	public static void main(String args[]){
		DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
		Thread t = new Thread(dsr);
		t.start();
		
		
		for(int i = 0; i < 10; i++){
			//挂起线程
			dsr.suspendRequest();
			
			//让线程有机会注意到挂起请求
            //注意：这里休眠时间一定要大于
            //stepOne操作对firstVal赋值后的休眠时间，即300ms，
            //目的是为了防止在执行dsr.areValuesEqual（）进行比较时,
            //恰逢stepOne操作执行完，而stepTwo操作还没执行
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				
			}
			System.out.println("dsr.areValusEqual(): "+dsr.areValusEqual());
			//恢复线程
			dsr.resumeRequest();
			
			try {
				Thread.sleep((long)(Math.random()*2000.0));
			} catch (InterruptedException e1) {
				
			}
		}
	}
}
