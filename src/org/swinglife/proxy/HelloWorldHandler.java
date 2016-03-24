package org.swinglife.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler{
	//要代理的原始对象
	private Object obj;
	
	public HelloWorldHandler(Object obj){
		super();
		this.obj = obj;
	}

	/**
	* 在代理实例上处理方法调用并返回结果
	* 
	* @param proxy 代理类
	* @param method 被代理的方法
	* @param args 该方法的参数数组
	*/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		doBefore();
		result = method.invoke(obj, args);
		doAfter();
		return result;
	}
	
	private void doBefore(){
		System.out.println("before method invoke");
	}
		
	private void doAfter(){
		System.out.println("after method invoke");
	}

}
