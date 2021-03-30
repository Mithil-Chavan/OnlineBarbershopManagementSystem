package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Shops;
@Repository
@Transactional
public class  AdminDaoImpl implements IAdminDao{

	@Autowired
	private EntityManager mgr;
	@Override
	public List<Shops> getShops() {
	
		String jpql = "select s from Shops s";
		List<Shops> slist=new ArrayList<Shops>();
		slist=mgr.createQuery(jpql, Shops.class).getResultList();
		
		return slist;
	}

	@Override
	public String removeShop(int shopId) {
		
		
		Shops s = mgr.find(Shops.class, shopId);
		if (s != null) {
			mgr.remove(s);
			return "shop un-subscribed with ID " + s.getShopId();
		}
		return "Shop deletion failed : Invalid Vendor ID";
	}

	

	@Override
	public String addNewShop(Shops s) {
		mgr.persist(s);
		return "Shop registered successfully : ID "+s.getShopId();
	}

	@Override
	public String updateShop(Shops s) {
		
		mgr.merge(s);
		return "Shop Updated successfully : ID "+s.getShopId();
	}

	@Override
	public Shops getShopByShopId(int shopId) {
		
		String jpql="select s from Shops s where s.shopId=:shopid";
		return mgr.createQuery(jpql,Shops.class).setParameter("shopid",shopId).getSingleResult();
	}


}
