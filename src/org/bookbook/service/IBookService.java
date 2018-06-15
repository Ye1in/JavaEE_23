package org.bookbook.service;

import java.util.List;

public interface IBookService {
	// ��ҳ��ѯ
	public List getBookByCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize);

	// �õ�������ͼ�������
	public int getTotalByCatalog(Integer catalogid);

	public List getBookByBookName(String name);

}
