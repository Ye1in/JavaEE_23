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
		// ��ù��ﳵ����
		Map session = ActionContext.getContext().getSession();
		if (session.get("user") == null) {
			return LOGIN;
		}
		// �õ�Ҫ�����ͼ��
		Book book = bookService.getBookById(bookid);
		// ����һ��������
		Orderitem orderitem = new Orderitem();
		// ��Ҫ������鼮��ӵ�������
		orderitem.setBook(book);
		// ����Ҫ����ͼ������
		orderitem.setQuantity(quantity);
		Cart cart = (Cart) session.get("cart");
		// ���û�оʹ���һ��
		if (cart == null) {
			cart = new Cart();
		}
		// ��ͼ���ID�Ͷ���������빺�ﳵ
		cart.addBook(bookid, orderitem);
		// �ѹ��ﳵ����Session��
		session.put("cart", cart);
		return SUCCESS;
	}

	public String updateCart() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		// ֱ�ӵ��ù��ﳵģ���еķ���ʵ���޸�ͼ������
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
