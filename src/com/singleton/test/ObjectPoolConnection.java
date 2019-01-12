package com.singleton.test;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
 

public class ObjectPoolConnection {
 
    private ObjectPool<testObj> pool;
 
    testObj obj = null;
 
    public testObj getConnClient(){
 
        PoolableObjectFactory<testObj> factory = new ObjectPoolFactory();
        pool = new GenericObjectPool<testObj>(factory);
 
            try {
                    try {
                        if(obj==null){
                            obj = (testObj)pool.borrowObject();
                            obj.getMe();
                        }
                    } catch (Exception e) {
                        obj=null;
                       // logger.error("failed to borrow object from Connection pool"+e.getMessage());
                    } finally {
                        if (obj != null) {
                            try {
                                pool.returnObject(obj);
                            } catch (Exception e) {
                                //logger.error("failed to return object from Connection"+e.getMessage());
                            }
                        }
                    }
            } finally {
                try {
                    pool.close();
                } catch (Exception e) {
                    //logger.error("failed to return pool"+e.getMessage());
                }
            }
            return obj;
    }
}
