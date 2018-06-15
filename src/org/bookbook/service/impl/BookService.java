package org.bookbook.service.impl;

import java.util.List;
import org.bookbook.dao.IBookDAO;
import org.bookbook.dao.impl.BookDAO;
import org.bookbook.service.IBookService;
import org.bookbook.model.Book;

public class BookService implements IBookService {
	protected IBookDAO bookDAO;

	
	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public List getBookByCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize) {
		return bookDAO.getBookByCatalogidPaging(catalogid, currentPage,
				pageSize);
	}

	public int getTotalByCatalog(Integer catalogid) {
		return bookDAO.getTotalByCatalog(catalogid);
	}

	public List getBookByBookName(String name) {

		return bookDAO.getBookByBookName(name);

	}

	public List getNewBook() {
		return bookDAO.getNewBook();
	}

	public void savebook(Book book) {
		this.bookDAO.savebook(book);
	}

	public Book getBookById(Integer bookid) {
		return this.bookDAO.getBookById(bookid);
	}
}
