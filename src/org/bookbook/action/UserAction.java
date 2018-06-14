package org.bookbook.action;

import java.util.Map;

import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.bookbook.model.Usertable;
import org.bookbook.service.IUserService;
import org.omg.CORBA.Request;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	protected Usertable user;
	protected IUserService userService;

	public Usertable getUser() {
		return this.user;
	}

	public void setUser(Usertable user) {
		this.user = user;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String register() throws Exception {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAge());
		System.out.println(user.getSex());
		Usertable user1 = new Usertable();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setSex(user.getSex());
		user1.setAge(user.getAge());
		userService.saveUser(user1);
		return SUCCESS;
	}
	
	public String login()throws Exception{
		Usertable user1 = new Usertable();
		user1=userService.validateUser(user.getUsername(),user.getPassword());
		
		Map session=ActionContext.getContext().getSession();
		
		if(user1==null){
			return ERROR;
		}else{
			session.put("user", user1);
			session.put("cart", null);
			return SUCCESS;
		}
		
	}
	
	public String logout(){
		Map session=ActionContext.getContext().getSession();
		session.remove("user");
		session.remove("cart");
		return SUCCESS;
	}
}
