package org.bookbook.action;

import java.util.Map;
import org.bookbook.model.Book;
import org.bookbook.model.Cart;
import org.bookbook.model.Orderitem;
import org.bookbook.model.Usertable;
import org.bookbook.service.impl.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingAction extends ActionSupport {
	protected Book book;
	protected BookService bookService;
	private Integer bookid;
	private Integer quantity;

	public String addToCart() throws Exception {
		// 获得购物车对象
		Map session = ActionContext.getContext().getSession();
		if (session.get("user") == null) {
			return LOGIN;
		}
		// 得到要购买的图书
		Book book = bookService.getBookById(bookid);
		// 创建一个订单项
		Orderitem orderitem = new Orderitem();
		// 把要购买的书籍添加到订单项
		orderitem.setBook(book);
		// 设置要购买图书数量
		orderitem.setQuantity(quantity);
		Cart cart = (Cart) session.get("cart");
		// 如果没有就创建一个
		if (cart == null) {
			cart = new Cart();
		}
		// 把图书的ID和订单项添加入购物车
		cart.addBook(bookid, orderitem);
		// 把购物车放入Session中
		session.put("cart", cart);
		return SUCCESS;
	}

	public String updateCart() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		// 直接调用购物车模型中的方法实现修改图书数量
		cart.updateCart(bookid, this.getQuantity());
		session.put("cart", cart);
		return SUCCESS;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
