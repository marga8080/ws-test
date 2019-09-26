package cn.ws;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import cn.ws.cxf.IUserService;
import cn.ws.model.User;

public class CxfClient {
	
	// 接口地址
	String address = "http://localhost:9999/test/user?wsdl";

	@Test
	public void test1() {
		try {
			// 代理工厂
			JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
			// 设置代理地址
			jaxWsProxyFactoryBean.setAddress(address);
			// 设置接口类型
			jaxWsProxyFactoryBean.setServiceClass(IUserService.class);
			// 创建一个代理接口实现
			IUserService userService = (IUserService) jaxWsProxyFactoryBean.create();
			String json = userService.getUserJson("1111");
			System.out.println(json);
			System.err.println("------------------------------------");
			System.out.println(userService.getUserName("121212"));
			System.err.println("------------------------------------");
			User user = userService.getUser("xcxcxcxc");
			System.out.println(user.getId() + "-----" + user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient(address);
		Object[] objects = new Object[0];
		try {
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("getUserName", "43434343");
			System.out.println("返回数据:" + objects[0]);
			objects = client.invoke("getUserJson", "43434343");
			System.out.println("返回数据:" + objects[0].toString());
			objects = client.invoke("getUserXml", "43434343");
			System.out.println("返回数据:" + objects[0].toString());
			objects = client.invoke("getUser", "43434343");
			System.out.println("返回数据:" + objects[0].toString());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
