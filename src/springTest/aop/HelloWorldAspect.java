package springTest.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloWorldAspect {
	//前置通知
	public void beforeAdvice(String param){
		System.out.println("***********before advice**************"+param);
	}
	
	//结束后通知
	public void afterFinallyAdvice(String value){
		System.out.println("*************after advice**************"+value);
	}
	
	public void afterReturningAdvice(Object retVal){
		System.out.println("*************after returnging relVal: "+retVal);
	}
	
	public void afterThrowingAdvice(Exception exception){
		System.out.println("after throwing exception: "+exception);
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("*********before around");
		Object retVal = pjp.proceed(new Object[] {"resplace"});
		System.out.println("*********after around");
		return retVal;
	}
}
