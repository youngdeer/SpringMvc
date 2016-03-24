package springTest.beans;

public class CircleC {
	private CircleA circleA;

	public CircleA getCircleA() {
		return circleA;
	}

	public void setCircleA(CircleA circleA) {
		this.circleA = circleA;
	}

	public CircleC(CircleA circleA) {
		super();
		this.circleA = circleA;
	}

	public CircleC() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void c(){
		circleA.a();
	}
}
