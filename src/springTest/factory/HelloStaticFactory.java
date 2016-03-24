package springTest.factory;

import springTest.beans.Hello;

public class HelloStaticFactory {
	public static Hello newInstance(String name){
		return new Hello(name);
	}
}
