package org.bookbook.action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.bookbook.model.Book;
import org.bookbook.service.impl.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	protected Book book;
	protected BookService bookservice;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBookservice(BookService bookservice) {
		this.bookservice = bookservice;
	}

}
