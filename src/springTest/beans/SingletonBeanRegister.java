package springTest.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

public class SingletonBeanRegister implements SingletonBeanRegistry{
	//单例Bean缓存池，此处不考虑并发
	private final Map<String,Object> BEANS = new HashMap<String, Object>(); 

	@Override
	public boolean containsSingleton(String beanName) {
		// TODO Auto-generated method stub
		return BEANS.containsKey(beanName);
	}

	@Override
	public Object getSingleton(String beanName) {
		// TODO Auto-generated method stub
		return BEANS.get(beanName);
	}

	@Override
	public int getSingletonCount() {
		// TODO Auto-generated method stub
		return BEANS.size();
	}

	@Override
	public String[] getSingletonNames() {
		// TODO Auto-generated method stub
		return BEANS.keySet().toArray(new String[0]);
	}

	@Override
	public void registerSingleton(String beanName, Object bean) {
		if(containsSingleton(beanName)){
			throw new RuntimeException(beanName+"已存在");
		}else{
			BEANS.put(beanName, bean);
		}
	}

}
