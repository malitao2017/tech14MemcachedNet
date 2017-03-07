package com.hl.memcached.cache.client;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class Client {

	private static MemCachedClient client = null;
	private Client(){
		
	}
	@SuppressWarnings({ "unused", "deprecation" })
	public static MemCachedClient getInstance(){
		if(client==null){
			client =new MemCachedClient();
			String [] addr ={"127.0.0.1:11211"};
			Integer [] weights = {3};
			SockIOPool pool = SockIOPool.getInstance();
			pool.setServers(addr);
			pool.setWeights(weights);
			pool.setInitConn(5);
			pool.setMinConn(5);
			pool.setMaxConn(200);
			pool.setMaxIdle(1000*30*30);
			pool.setMaintSleep(30);
			pool.setNagle(false);
			pool.setSocketTO(30);
			pool.setSocketConnectTO(0);
			pool.initialize();
			
			String [] s  =pool.getServers();
			client.setCompressEnable(true);
			client.setCompressThreshold(1000*1024);
		}
		return client;
	}
}
