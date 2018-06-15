package org.bookbook.action;

import java.util.List;
import java.util.Map;
import org.bookbook.service.IBookService;
import org.bookstore.util.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	protected IBookService BookService;
	private int catalogid;
	private int currentPage = 1;
	private String bookname = null;
	private Pager pager = new Pager(currentPage, BookService
			.getTotalByCatalog(catalogid));

	public void setBookService(IBookService bookService) {
		BookService = bookService;
	}

	public String browseBookPaging() {
		pager.setCurrentPage(currentPage);
		List books = BookService.getBookByCatalogidPaging(catalogid,
				currentPage, 3);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager", pager);
		return SUCCESS;
	}

	public String searchBook() {
		List books;
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}
}
