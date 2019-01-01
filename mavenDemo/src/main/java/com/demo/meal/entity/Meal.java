package com.demo.meal.entity;

public class Meal {
	private Integer mealID;
	
	private Integer seriesID;
	
	private String mealName;
	
	private String mealDescription;
	
	private float mealPrice;
	
	private String mealImg;

	public Integer getMealID() {
		return mealID;
	}

	public void setMealID(Integer mealID) {
		this.mealID = mealID;
	}

	public Integer getSeriesID() {
		return seriesID;
	}

	public void setSeriesID(Integer seriesID) {
		this.seriesID = seriesID;
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
	
	
}
