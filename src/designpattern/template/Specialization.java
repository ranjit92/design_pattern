package designpattern.template;

abstract class Specialization extends Generalization{

	protected void stepThr(){
		step3_1();
		step3_2();
		step3_3();
	}

	private void step3_1() {
		System.out.println("step_3_1 in Specialization");
	}
	
	abstract void step3_2();
	
	private void step3_3() {
		System.out.println("step_3_3 in Specialization");
	}

	
}
