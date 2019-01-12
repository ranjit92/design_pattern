package com.singleton.test;

public class SingletonDemo
{
	private static  SingletonDemo  instance = null;

	private SingletonDemo() 
	{
		if(instance != null)
		{
			throw new RuntimeException("Please use get instance method..!");
		}
	}
	
	public static SingletonDemo getinstance()
	{
		if(instance == null)
		{
			synchronized (SingletonDemo.class) 
			{
				if(instance == null) 
				{
					instance = new SingletonDemo();
				}
			}
		}
		return instance;
	}
}