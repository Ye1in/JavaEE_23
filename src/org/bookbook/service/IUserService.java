package org.bookbook.service;

import org.bookbook.model.Usertable;

public interface IUserService {

	public void saveUser(Usertable user);
	public Usertable validateUser(String userName,String userPassword);

	public boolean exitUser(String username);
}
