package org.bookbook.service.impl;

import java.util.List;
import org.bookbook.dao.ICatalogDAO;
import org.bookbook.service.ICatalogService;

public class CatalogService implements ICatalogService {
	private ICatalogDAO catalogDAO;
	public List getAllCatalogs(){
		return catalogDAO.getAllCatalogs();
	}
	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}
}
