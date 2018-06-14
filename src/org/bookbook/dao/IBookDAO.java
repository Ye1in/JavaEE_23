package org.bookbook.dao;

import org.bookbook.model.Book;

public interface IBookDAO {

	public void savebook(Book book);

	public Book getBookById(Integer bookid);
}
