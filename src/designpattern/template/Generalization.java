package designpattern.template;

abstract class Generalization {
	void findSolution(){
		stepOne();
		stepTwo();
		stepThr();
		stepFor();
	}

	private void stepOne() {
		System.out.println("step one in Generalization");
	}
	
	abstract void stepTwo();
	abstract void stepThr();
	
	void stepFor() {
		System.out.println("step for in Generalization");
	}

	
}
