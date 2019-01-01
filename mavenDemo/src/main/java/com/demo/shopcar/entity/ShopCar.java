package com.demo.shopcar.entity;

public class ShopCar {
	private Integer ID;
	
	private Integer userID;
	
	private String mealID;
	
	private String mealCount;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getMealID() {
		return mealID;
	}

	public void setMealID(String mealID) {
		this.mealID = mealID;
	}

	public String getMealCount() {
		return mealCount;
	}

	public void setMealCount(String mealCount) {
		this.mealCount = mealCount;
	}
	
}
