package springTest.factory;

import springTest.beans.Hello;

public class HelloInstanceFactory {
	public Hello newInstance(String name){
		return new Hello(name);
	}
}
