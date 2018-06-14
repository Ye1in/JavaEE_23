package org.bookbook.dao.impl;

import java.util.List;

import org.bookbook.dao.IUserDAO;
import org.bookbook.model.Usertable;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAO extends HibernateDaoSupport implements IUserDAO {

	public void saveUser(Usertable user) {
		this.getHibernateTemplate().save(user);
	}

	public boolean exitUser(String username) {
		List list = this.getHibernateTemplate().find(
				"from User where username=?", username);
		if (list.size() > 0)
			return true;
		else
			return false;
	}

}
