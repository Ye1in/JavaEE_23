package org.bookbook.dao;

import java.util.List;
import org.bookbook.model.Book;

public interface IBookDAO {
	public List getNewBook();

	public void savebook(Book book);

	public Book getBookById(Integer bookid);
}
