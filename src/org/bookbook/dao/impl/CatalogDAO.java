package org.bookbook.dao.impl;

import java.util.List;

import org.bookbook.dao.ICatalogDAO;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CatalogDAO extends HibernateDaoSupport implements ICatalogDAO {

	public List getAllCatalogs() {
		List catalogs=this.getHibernateTemplate().find("from Catalog");
		return catalogs;
	}

}
