package com.singleton.test;

import java.io.InputStream;
import java.util.Properties;
 
import org.apache.commons.pool.BasePoolableObjectFactory;


public class ObjectPoolFactory extends BasePoolableObjectFactory<testObj> {
	 
	 // for makeObject we'll simply return a new object e.g: connection object
	 @Override
	 public testObj makeObject() throws Exception {
	 
	 InputStream stream = null;
	 // Create object code here for the first time. e.g: Create connection object from other integrated system component
	 testObj connClient= new testObj();
	 return connClient;
	 }
	}