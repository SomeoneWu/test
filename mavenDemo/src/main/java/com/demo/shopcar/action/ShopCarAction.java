package com.demo.shopcar.action;

import java.util.ArrayList;
import java.util.List;

import com.demo.meal.entity.Meal;
import com.demo.mealDetail.entity.MealDetail;
import com.demo.shopcar.entity.ShopCar;
import com.demo.shopcar.service.ShopCarService;
import com.demo.tool.Data;
import com.demo.user.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class ShopCarAction {	
	/**

	 * 

	 */
	private static final long serialVersionUID = 1L;
	
	//将会被Struts2序列化为JSON字符串的对象
	private Data data;
	
	private Integer mealID;
	
	private Integer mealCount;
	
	private Integer userID;
	
	private ShopCar shopCar;
	
	private User user;
	
	private Meal meal;
	
	private ShopCarService shopCarService;
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}	
	
	public Integer getMealID() {
		return mealID;
	}

	public void setMealID(Integer mealID) {
		this.mealID = mealID;
	}

	public Integer getMealCount() {
		return mealCount;
	}

	public void setMealCount(Integer mealCount) {
		this.mealCount = mealCount;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public ShopCar getShopCar() {
		return shopCar;
	}

	public void setShopCar(ShopCar shopCar) {
		this.shopCar = shopCar;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public ShopCarService getShopCarService() {
		return shopCarService;
	}

	public void setShopCarService(ShopCarService shopCarService) {
		this.shopCarService = shopCarService;
	}
	
	public String queryByUserID() {
		user = shopCarService.queryByUserId(userID);
		
		data = Data.success().add("user", user);
		
		return "toshow";
	}
	
	public String queryShopCarByUserID() {
		shopCar = shopCarService.queryShopCarByUserId(userID);
		
		data = Data.success().add("shopCar", shopCar);
		
		return "shopcar";
	}
	
	public String queryMealByMealId() {
		shopCar = shopCarService.queryShopCarByUserId(userID);
		
		String mealID = shopCar.getMealID();
		
		List<MealDetail> List = new ArrayList<>();
		if(!mealID.equals("")) {
			String mealCount[] = shopCar.getMealCount().split(";");
			
			List<Meal> list = shopCarService.queryMealByMealId(mealID);

			for(int i = 0; i < list.size(); i++ ) {
				Meal meal = list.get(i);
				
				MealDetail detail = new MealDetail();
				
				detail.setMealID(meal.getMealID());
				
				detail.setMealName(meal.getMealName());
				
				detail.setMealDescription(meal.getMealDescription());
				
				detail.setMealPrice(meal.getMealPrice());
				
				detail.setMealImg(meal.getMealImg());
				
				detail.setMealCount(Integer.parseInt(mealCount[i]));
				
				List.add(detail);
			}
			
			ActionContext.getContext().getValueStack().set("mealInfo", List);
		}else {
			
			System.out.println(List==null);
			ActionContext.getContext().getValueStack().set("mealInfo", List);
		}
		
		
		
		return "mealInfo";
	}
	
	public String saveMeal() {
		shopCarService.saveMeal(userID, mealID, mealCount);
		
		data = Data.success();
		
		return "saveMeal";
	
	}
	
	public String deleteFromShopCar() {
		shopCarService.deleteFromShopCar(userID, mealID);
		
		return "deleteMeal";
	
	}
}
