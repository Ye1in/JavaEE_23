package org.bookbook.service.impl;

import org.bookbook.dao.IUserDAO;
import org.bookbook.model.Usertable;
import org.bookbook.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void saveUser(Usertable user) {
		this.userDAO.saveUser(user);
	}

}
