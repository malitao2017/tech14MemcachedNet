package com.hl.memcached.cache;

import org.junit.Test;

import com.danga.MemCached.MemCachedClient;
import com.hl.memcached.cache.client.Client;
import com.hl.memcached.cache.client.TestBean;

public class CacheTest {

	@Test
	public void getCache(){
		MemCachedClient client=Client.getInstance();
//		Date date=new Date(2000000);
//		client.set("test","dfas", date);
//		client.set("test","tangjinjing", 2);
//		É¾³ý
//		client.delete("test");
//		String str =(String)client.get("test");
//		System.out.println(str);
		
		
		TestBean bean=new TestBean();
		bean.setName("name1");
		bean.setAge(25);
		client.add("bean1", bean);
		
		TestBean beanClient=(TestBean)client.get("bean1");
		System.out.println(beanClient.getName());
	}
}
