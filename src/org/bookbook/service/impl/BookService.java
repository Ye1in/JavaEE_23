package org.bookbook.service.impl;

import java.util.List;

import org.bookbook.dao.IBookDAO;
import org.bookbook.dao.impl.BookDAO;
import org.bookbook.service.IBookService;

public class BookService implements IBookService {
	protected IBookDAO BookDAO;

	public void setBookDao(IBookDAO bookDao) {
		BookDAO = bookDao;
	}

	public List getBookByCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize) {
		return BookDAO.getBookByCatalogidPaging(catalogid, currentPage,
				pageSize);
	}

	public int getTotalByCatalog(Integer catalogid) {
		return BookDAO.getTotalByCatalog(catalogid);
	}

	public List getBookByBookName(String name) {

		return BookDAO.getBookByBookName(name);

	}

}
