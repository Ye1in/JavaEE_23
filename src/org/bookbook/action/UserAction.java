package org.bookbook.action;

import org.bookbook.model.Usertable;
import org.bookbook.service.IUserService;

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
//		System.out.println(user.getUsername());
		Usertable user1 = new Usertable();
		user1.setUsername(user.getUsername());
		userService.saveUser(user1);
		return SUCCESS;
	}

}
