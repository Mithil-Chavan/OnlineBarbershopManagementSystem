package com.app.dao;
import java.util.List;

import com.app.pojos.Shops;

public interface IAdminDao {
	 List<Shops> getShops();
	
	String addNewShop(Shops s);
	String removeShop(int shopId);
	String updateShop(Shops s);
	Shops getShopByShopId(int shopId);
}
