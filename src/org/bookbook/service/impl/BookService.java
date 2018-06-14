package org.bookbook.service.impl;

import org.bookbook.dao.IBookDAO;
import org.bookbook.model.Book;
import org.bookbook.service.IBookService;

public class BookService implements IBookService {

	private IBookDAO bookDAO;

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public void savebook(Book book) {
		this.bookDAO.savebook(book);
	}

	public Book getBookById(Integer bookid) {
		return this.bookDAO.getBookById(bookid);
	}
}
