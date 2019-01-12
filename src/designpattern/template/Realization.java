package designpattern.template;

public class Realization extends Specialization {

	@Override
	void stepTwo() {
		System.out.println("stepTwo in Realization");
	}
	
	@Override
	void step3_2() {
		System.out.println("step3_2 in Realization");
	}
	
	protected void stepFor(){
		System.out.println("stepFor in Realization");
		super.stepFor();
	}


}
