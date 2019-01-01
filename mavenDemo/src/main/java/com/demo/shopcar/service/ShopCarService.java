package com.demo.shopcar.service;

import java.util.List;

import com.demo.meal.entity.Meal;
import com.demo.shopcar.entity.ShopCar;
import com.demo.user.entity.User;

public interface ShopCarService {
	public User queryByUserId(Integer userID);
	
	public ShopCar queryShopCarByUserId(Integer userID);
	
	public List<Meal> queryMealByMealId(String mealID);
	
	public void saveMeal(Integer userID , Integer mealID , Integer mealCount);
	
	public void deleteFromShopCar(Integer userID , Integer mealID);
}
