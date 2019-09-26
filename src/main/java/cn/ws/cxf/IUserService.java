package cn.ws.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cn.ws.model.User;

@WebService
public interface IUserService {

	@WebMethod
	public String getUserName(@WebParam(name = "id") String id);
	
    @WebMethod
    public String getUserJson(String id);
    
    @WebMethod
    public String getUserXml(String id);
    
    @WebMethod
    public User getUser(String id);
}
