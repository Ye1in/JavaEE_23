package org.bookbook.dao.impl;

import java.util.List;
import org.bookbook.dao.IBookDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.bookbook.model.Book;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BookDAO extends HibernateDaoSupport implements IBookDAO {

	public List getNewBook() {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session.createQuery("from Book b");
		query.setFirstResult(0);
		query.setMaxResults(5);
		List books = query.list();
		session.close();
		return books;
	}

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
