package org.bookbook.service.impl;

import java.util.List;

import org.bookbook.dao.IBookDAO;
import org.bookbook.service.IBookService;

public class BookService implements IBookService {

	protected IBookDAO bookDAO;
	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
     public List getNewBook(){
    		return bookDAO.getNewBook();
	}


}
