package org.bookbook.dao;

import java.util.List;

public interface IBookDAO {
	// 分页查询
	public List getBookByCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize);

	// 得到该类别的图书的总数
	public int getTotalByCatalog(Integer catalogid);

	public List getBookByBookName(String name);

}
