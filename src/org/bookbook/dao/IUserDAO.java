package org.bookbook.dao;

import org.bookbook.model.Usertable;

public interface IUserDAO {

	public void saveUser(Usertable user);
	public Usertable validateUser(String userName,String userPassword);

	public boolean exitUser(String username);

}
