package cn.ws.cxf;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import cn.hutool.json.JSONObject;
import cn.ws.model.User;

//name暴露的服务名称, targetNamespace:命名空间,设置为接口的包名倒写(默认是本类包名倒写). endpointInterface接口地址
@WebService(name = "user" ,targetNamespace ="http://cxf.ws.cn/" ,endpointInterface = "cn.ws.cxf.IUserService")
@Component
public class UserService implements IUserService {

	@Override
	public String getUserName(String id) {
		return id + "---张三";
	}

	@Override
	public String getUserJson(String id) {
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("name", "张三");
		return json.toString();
	}

	@Override
	public String getUserXml(String id) {
		User user = new User();
		user.setId(id);
		user.setName("张三");
		XStream xStream = new XStream(new DomDriver());
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xStream.toXML(user);
	}

	@Override
	public User getUser(String id) {
		User user = new User();
		user.setId(id);
		user.setName("张三");
		return user;
	}
}
