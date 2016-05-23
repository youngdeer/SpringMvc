package deerSYS.common;

import redis.clients.jedis.Jedis;

public class RedisUtil {

	private static Jedis jedis = null;
	
	public static Jedis getJedis(){
		if(jedis == null){
			System.out.println("******************create jedis***********************");
			jedis = new Jedis("localhost");
		}
		return jedis;
	}
}
