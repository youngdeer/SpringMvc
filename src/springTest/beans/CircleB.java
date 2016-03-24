package springTest.beans;

public class CircleB {
	private CircleC circleC;

	public CircleC getCircleC() {
		return circleC;
	}

	public void setCircleC(CircleC circleC) {
		this.circleC = circleC;
	}

	public CircleB(CircleC circleC) {
		super();
		this.circleC = circleC;
	}

	public CircleB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void b(){
		circleC.c();
	}
}
