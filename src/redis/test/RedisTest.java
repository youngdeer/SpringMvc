package redis.test;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		//设置redis appendonly属性  为"yes" 开启aof快照，默认生成的appendonly.aof有只读属性，去掉才可正常启动redis
		
		Jedis jedis = new Jedis("localhost");
		System.out.println("server is running:"+jedis.ping());
		
		//读写字符串
//		jedis.set("deer", "young");
//		jedis.set("luyang", "lalala");
		System.out.println("deer's value: "+jedis.get("luyang"));
		
		//列表数据读写
//		jedis.lpush("deerList", "listvalue1");
//		jedis.lpush("deerList", "listvalue2");
//		jedis.lpush("deerList", "listvalue3");
		List<String> deerList = jedis.lrange("deerList", 0, 2);
		for(String value:deerList){
			System.out.println("deerList's value: "+value);
		}
		
		//set(无序且值唯一)读写
//		System.out.println("return status: "+jedis.sadd("deerSet", "setValue1"));
//		System.out.println("return status: "+jedis.sadd("deerSet", "setValue1"));
//		System.out.println("return status: "+jedis.sadd("deerSet", "setValue2"));
//		System.out.println("return status: "+jedis.sadd("deerSet", "setValue3"));
		Set<String> setValues = jedis.smembers("deerSet");
		for(String key:setValues){
			System.out.println("deerSet: "+key);
		}
		
		//zset(有序且值唯一)读写
//		System.out.println("return status: "+jedis.zadd("deerZset", 0, "deerZset0"));
//		System.out.println("return status: "+jedis.zadd("deerZset", 0, "deerZset0"));
//		System.out.println("return status: "+jedis.zadd("deerZset", 3, "deerZset1"));
//		System.out.println("return status: "+jedis.zadd("deerZset", 1, "deerZset2"));
//		System.out.println("return status: "+jedis.zadd("deerZset", 2, "deerZset3"));
		Set<String> zsetValues = jedis.zrangeByScore("deerZset", 0, 100);
		for(String key:zsetValues){
			System.out.println("deerZset: "+key);
		}
		
		//输出keys
		Set<String> keys = jedis.keys("*");
		for(String key:keys){
			System.out.println("keys: "+key);
		}
	}
}
