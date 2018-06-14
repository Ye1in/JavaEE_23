package org.bookbook.service;

import java.util.List;
import org.bookbook.model.Book;
import org.bookbook.model.Orderitem;

public interface IBookService {
	public List getNewBook();

	public void savebook(Book book);

	public Book getBookById(Integer bookid);

}
