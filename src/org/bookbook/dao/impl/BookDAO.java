package org.bookbook.dao.impl;

import java.util.List;
import org.bookbook.dao.IBookDAO;
import org.bookbook.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BookDAO extends HibernateDaoSupport implements IBookDAO {

	public List getBookByCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session
				.createQuery("from Book b where b.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List books = query.list();
		session.close();
		return books;
	}

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

	public int getTotalByCatalog(Integer catalogid) {
		List books = this.getHibernateTemplate().find(
				"from Book b where b.catalog.catalogid=?", catalogid);
		return books.size();
	}

	public List getBookByBookName(String name) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session
				.createQuery("from Book b where LOWER(b.bookname) like LOWER(:name)");
		query.setString("name", "" + name + "%");
		List books = query.list();
		session.close();
		return books;

	}

	public void savebook(Book book) {
		this.getHibernateTemplate().save(book);
	}

	public Book getBookById(Integer bookid) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session.createQuery("from Book b where b.bookid=?");
		query.setParameter(0, bookid);
		Book result = (Book) query.uniqueResult();
		return result;
	}

}
