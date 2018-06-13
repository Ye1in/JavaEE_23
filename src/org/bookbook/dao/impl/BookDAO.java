package org.bookbook.dao.impl;

import org.bookbook.dao.IBookDAO;
import org.bookbook.model.Book;
import org.bookbook.model.Orderitem;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BookDAO extends HibernateDaoSupport implements IBookDAO {

	public void savebook(Book book) {
		this.getHibernateTemplate().save(book);
	}

}
