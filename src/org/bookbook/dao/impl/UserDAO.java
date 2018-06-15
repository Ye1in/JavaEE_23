package org.bookbook.dao.impl;

import java.util.List;

import org.bookbook.dao.IUserDAO;
import org.bookbook.model.Usertable;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAO extends HibernateDaoSupport implements IUserDAO {

	public void saveUser(Usertable user) {
		this.getHibernateTemplate().save(user);
	}

	public Usertable validateUser(String userName, String userPassword) {
		String hql = "from Usertable as user where user.username='" + userName
				+ "' and user.password='" + userPassword + "'";
		Usertable user = null;
		try {
			List<Usertable> userlist = this.getHibernateTemplate().find(hql);
			if (userlist.size() > 0) {
				user = new Usertable();
				user = userlist.get(0);
			}
		} catch (RuntimeException e) {
			throw e;
		}
		return user;
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
