package com.demo.mealDetail.entity;

public class MealDetail {
	private String mealName;
	
	private String mealDescription;
	
	private float mealPrice;
	
	private String mealImg;
	
	private Integer mealCount;
	
	private Integer mealID;

	public Integer getMealID() {
		return mealID;
	}

	public void setMealID(Integer mealID) {
		this.mealID = mealID;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealDescription() {
		return mealDescription;
	}

	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}

	public float getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(float mealPrice) {
		this.mealPrice = mealPrice;
	}

	public String getMealImg() {
		return mealImg;
	}

	public void setMealImg(String mealImg) {
		this.mealImg = mealImg;
	}

	public Integer getMealCount() {
		return mealCount;
	}

	public void setMealCount(Integer mealCount) {
		this.mealCount = mealCount;
	}
	
	
}
