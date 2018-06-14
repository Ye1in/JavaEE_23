package org.bookbook.dao.impl;

import java.util.List;

import org.bookbook.dao.IBookDAO;
import org.bookbook.model.Book;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BookDAO extends HibernateDaoSupport implements IBookDAO {

	public void savebook(Book book) {
		this.getHibernateTemplate().save(book);
	}

	public Book getBookById(Integer bookid) {
		List<Book> list = this.getHibernateTemplate().find(
				"from book where bookid=?", bookid);
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
