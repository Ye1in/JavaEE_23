package org.bookbook.service;

import org.bookbook.model.Book;
import org.bookbook.model.Orderitem;
import java.util.List;

public interface IBookService {
	// ��ҳ��ѯ
	public List getBookByCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize);

	// �õ�������ͼ�������
	public int getTotalByCatalog(Integer catalogid);

	public List getBookByBookName(String name);

	public List getNewBook();

	public void savebook(Book book);

	public Book getBookById(Integer bookid);

}
