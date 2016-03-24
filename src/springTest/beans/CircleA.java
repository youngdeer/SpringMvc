package springTest.beans;

public class CircleA {
	private CircleB circleB;

	public CircleB getCircleB() {
		return circleB;
	}

	public void setCircleB(CircleB circleB) {
		this.circleB = circleB;
	}

	public CircleA(CircleB circleB) {
		super();
		this.circleB = circleB;
	}

	public CircleA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void a(){
		circleB.b();
	}
}
