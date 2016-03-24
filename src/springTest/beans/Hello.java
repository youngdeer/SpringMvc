package springTest.beans;

public class Hello {
	public Hello(){
		this.name = "noParam";
	}

	public Hello(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello(){
		System.out.println("Hello: "+name);
	}
	
	public void sayHi(){
		System.out.println("Hi: "+name);
	}
}
