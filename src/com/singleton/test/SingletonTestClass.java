package com.singleton.test;

import java.lang.reflect.Constructor;

public class SingletonTestClass {

	public static void main(String[] args) throws Exception 
	{
		SingletonDemo s1 = SingletonDemo.getinstance();
		
		SingletonDemo s2 = SingletonDemo.getinstance();
		
		System.out.println(s1.hashCode() == s2.hashCode());
		
		Class cls = Class.forName("com.test.SingletonDemo");
		
		Constructor<SingletonDemo> constructor = cls.getDeclaredConstructor();
		
		constructor.setAccessible(true);
		
		SingletonDemo s3 = constructor.newInstance();
		
		System.out.println(s1.hashCode() == s3.hashCode());
	}

}
