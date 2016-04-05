package springTest.aop.service.impl;

import springTest.aop.service.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService{

	@Override
	public void sayHello(String param) {
		System.out.println("*********************deer Hello***************"+param);
	}

	@Override
	public boolean sayAfterReturning() {
		System.out.println("***********say afterReturning");
		return false;
	}

	@Override
	public void sayAfterThrowing() {
		System.out.println("**********befor throwing");
		throw new RuntimeException();
	}

	@Override
	public void sayAround(String value) {
		System.out.println("********************say around :"+value);
		
	}

}
