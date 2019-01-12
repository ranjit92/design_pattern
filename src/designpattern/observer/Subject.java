package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers = new ArrayList<>();
	private int state;
	
	public void add(Observer observer){
		observers.add(observer);
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int value){
		this.state = value;
		execute();
	}

	private void execute() {
		for(Observer observer : observers){
			observer.update();
		}
		
	}
	
}
