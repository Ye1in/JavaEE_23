package org.bookbook.dao;

import java.util.List;
import org.bookbook.model.Book;

public interface IBookDAO {
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
