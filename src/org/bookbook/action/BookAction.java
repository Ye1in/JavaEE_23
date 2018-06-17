package org.bookbook.action;

import java.util.List;
import java.util.Map;
import org.bookbook.service.IBookService;
import org.bookbook.model.Book;
import org.bookbook.service.ICatalogService;
import org.bookbook.util.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	protected ICatalogService catalogService;
	protected IBookService bookService;
	protected Book book;
	private int catalogid = 1;
	private int currentPage = 1;
	private String bookname;

	

	public String browseBookPaging() {
		Pager pager = new Pager(currentPage, bookService
				.getTotalByCatalog(catalogid));
		List books = bookService.getBookByCatalogidPaging(catalogid,
				currentPage, 3);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager", pager);
		return SUCCESS;
	}

	public String searchBook() {
		List books = bookService.getBookByBookName(bookname);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
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

	public int getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
}
