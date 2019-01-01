package com.demo.shopcar.service;

import java.util.List;

import com.demo.meal.entity.Meal;
import com.demo.shopcar.dao.ShopCarDao;
import com.demo.shopcar.entity.ShopCar;
import com.demo.user.entity.User;

public class ShopCarServiceImpl implements ShopCarService {
	private ShopCarDao shopCarDao;
	
	
	
	public ShopCarDao getShopCarDao() {
		return shopCarDao;
	}



	public void setShopCarDao(ShopCarDao shopCarDao) {
		this.shopCarDao = shopCarDao;
	}



	@Override
	public User queryByUserId(Integer userID) {
		// TODO Auto-generated method stub
		return shopCarDao.queryByUserId(userID);
	}


	@Override
	public ShopCar queryShopCarByUserId(Integer userID) {
		// TODO Auto-generated method stub
		return shopCarDao.queryShopCarByUserId(userID);
	}


	@Override
	public List<Meal> queryMealByMealId(String mealID) {
		// TODO Auto-generated method stub
		return shopCarDao.queryMealByMealId(mealID);
	}



	@Override
	public void saveMeal(Integer userID , Integer mealID , Integer mealCount) {
		// TODO Auto-generated method stub
		shopCarDao.saveMeal(userID, mealID, mealCount);
	}



	@Override
	public void deleteFromShopCar(Integer userID, Integer mealID) {
		// TODO Auto-generated method stub
		shopCarDao.deleteFromShopCar(userID, mealID);
	}

}
