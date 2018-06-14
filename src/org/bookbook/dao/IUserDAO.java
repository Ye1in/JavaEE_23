package org.bookbook.dao;

import org.bookbook.model.Usertable;

public interface IUserDAO {

	public void saveUser(Usertable user);

	public boolean exitUser(String username);

}
