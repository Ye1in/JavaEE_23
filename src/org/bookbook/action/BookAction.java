package org.bookbook.action;

import java.util.List;
import java.util.Map;
import org.bookbook.model.Book;
import org.bookbook.service.IBookService;
import org.bookbook.service.ICatalogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	protected ICatalogService catalogService;
	protected IBookService bookService;
	protected Book book;

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String browseCatalog() throws Exception {
		List catalogs = catalogService.getAllCatalogs();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;
	}

	public String newBook() throws Exception {
		List books = bookService.getNewBook();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

}
