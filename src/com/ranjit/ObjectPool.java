package com.ranjit;

import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T> {
	
	private long expirationTime;	
	private Hashtable<T, Long> locked, unlocked;
	
	
	public ObjectPool(){
		expirationTime = 30000;
		locked = new Hashtable<T,Long>();
		unlocked = new Hashtable<T,Long>();
	}
	
	protected abstract T create();
	public abstract boolean validate(T t);
	public abstract void expire(T t);
	
	public synchronized T checkout(){
		
		long now = System.currentTimeMillis();	
		T t;
		
		if(unlocked.size() > 0){
			 Enumeration<T> e = unlocked.keys();
			 while(e.hasMoreElements()){
				 t = e.nextElement();
				 if((now - unlocked.get(t) > expirationTime)){
//					 in case object expired
					 unlocked.remove(t);
					 expire(t);
					 t = null;
				 }
				 else{
					 if(validate(t)){
						 unlocked.remove(t);
						 locked.put(t, now);
						 return t;
					 }
					 else{
						 unlocked.remove(t);
						 expire(t);
						 t = null;
					 }
					 
				 }
			 }
		}
		
		t = create();
		locked.put(t, now);
		return t;
	}
	
	public synchronized void checkIn(T t){
		locked.remove(t);
		unlocked.put(t, System.currentTimeMillis());
	}
}
