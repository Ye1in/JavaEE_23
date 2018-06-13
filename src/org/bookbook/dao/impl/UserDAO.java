package org.bookbook.dao.impl;

import org.bookbook.dao.IUserDAO;
import org.bookbook.model.Usertable;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAO extends HibernateDaoSupport implements IUserDAO{

	public void saveUser(Usertable user) {
		this.getHibernateTemplate().save(user);
	}
}
