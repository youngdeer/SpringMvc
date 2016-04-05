package springTest.aop.service;

public interface IHelloWorldService {
	public void sayHello(String param);
	
	public boolean sayAfterReturning();
	
	public void sayAfterThrowing();
	
	public void sayAround(String value);
}
