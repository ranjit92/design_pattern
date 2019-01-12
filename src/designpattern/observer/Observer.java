package designpattern.observer;

abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
