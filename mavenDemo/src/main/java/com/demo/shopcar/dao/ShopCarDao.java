package com.demo.shopcar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.meal.entity.Meal;
import com.demo.shopcar.entity.ShopCar;
import com.demo.user.entity.User;

@Transactional(readOnly=true)
public class ShopCarDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User queryByUserId(Integer userID) {
		String hql = "from User where userID = " + userID;
		
		Session session = sessionFactory.getCurrentSession();
	
		User user = (User)session.createQuery(hql).uniqueResult();
		
		return user;
	}
	
	public ShopCar queryShopCarByUserId(Integer userID) {
		String hql = "from ShopCar where userID = " + userID;
		
		Session session = sessionFactory.getCurrentSession();
		
		ShopCar shopCar = (ShopCar)session.createQuery(hql).uniqueResult();
		
		return shopCar;
	}
	
	public List<Meal> queryMealByMealId(String mealID) {
			Session session = sessionFactory.getCurrentSession();

			List<Meal> list = new ArrayList<Meal>();
			
			String mealid[] = mealID.split(";");
			
			for(int i = 0; i < mealid.length; i++) {
				String hql = "from Meal where mealID = " + mealid[i];
				
				Meal meal = (Meal)session.createQuery(hql).uniqueResult();
				
				list.add(meal);
			}
		
		return list;
		
	}

	public void saveMeal(Integer userID , Integer mealID , Integer mealCount) {
		String hql = "from ShopCar";
		
		String mealid = "";
		
		String mealcount = "";
		
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ShopCar> list = session.createQuery(hql).list();
	
		int flag = 0;
		
		for (ShopCar Shopcar : list) {	
			if(Shopcar.getUserID().equals(userID)) {
				flag = 1;
				//用户之前有过添加记录，但是购物车为空
				if(Shopcar.getMealID().equals("")) {
					mealid = String.valueOf(mealID)+";";
					
					mealcount = String.valueOf(mealCount)+";";
					
					Shopcar.setMealID(mealid);
					
					Shopcar.setMealCount(mealcount);

					session.saveOrUpdate(Shopcar);
					
					break;//跳出循环
				}

				String info[] = checkMealID(Shopcar.getMealID() , mealID).split(";");
				//修改数量
				if(info[0].equals("true")) {
					String count[] = Shopcar.getMealCount().split(";");
					//修改已经存在的mealID 对应的菜品数量
					mealcount = organizeMealCount(count , Integer.parseInt(info[1]) , String.valueOf(mealCount));
					
					Shopcar.setMealCount(mealcount);

					session.saveOrUpdate(Shopcar);
				}else {
					mealid = Shopcar.getMealID()+String.valueOf(mealID)+";";
					
					mealcount = Shopcar.getMealCount()+String.valueOf(mealCount)+";";
				
					Shopcar.setMealID(mealid);
					
					Shopcar.setMealCount(mealcount);

					session.saveOrUpdate(Shopcar);
				}
			}
		}
		if(flag == 0){
			//该用户第一次保存添加购物车
			mealid = String.valueOf(mealID)+";";
				
			mealcount = String.valueOf(mealCount)+";";
				
			ShopCar Shopcar = new ShopCar();
				
			Shopcar.setUserID(userID);
				
			Shopcar.setMealID(mealid);
				
			Shopcar.setMealCount(mealcount);

			session.saveOrUpdate(Shopcar);
		}
	}
	
	public void deleteFromShopCar(Integer userID , Integer mealID) {
		String hql = "from ShopCar where userID = "+userID;
		
		String mealid = "";
		
		String mealcount = "";
		
		Session session = sessionFactory.getCurrentSession();
		
		ShopCar shopcar = (ShopCar)session.createQuery(hql).uniqueResult();
		
		String info[] = checkMealID(shopcar.getMealID() , mealID).split(";");
		
		String mealId[] = shopcar.getMealID().split(";");
		
		String count[] = shopcar.getMealCount().split(";");
		
		for(int i = 0; i < mealId.length; i++) {
			if(i != Integer.parseInt(info[1])) {
				mealid = mealId[i] + ";";
				
				mealcount = count[i] + ";";
			}
		}
		shopcar.setMealID(mealid);
		
		shopcar.setMealCount(mealcount);
		
		session.saveOrUpdate(shopcar);
		
	}
	
	//检查mealId是否存在，返回对应的位置
	public static String checkMealID(String mealID , int MealID) {
		
		if(!mealID.equals("")) {
			String ID[] = mealID.split(";");
			
			for (int i = 0; i < ID.length; i++) {
				if(Integer.parseInt(ID[i]) == MealID) {
					return "true" + ";" + i;
				}
			}
		}
		return "false" + ";"+" ";
	}
	
	public static String organizeMealCount(String[] mealCount , int i , String Mealcount) {
		String mealcount = "";
		
		List<String> list = new ArrayList<>();
		
		for (String count : mealCount) {
			list.add(count);
		}
		list.set(i, Mealcount);
		
		for(int j = 0; j < list.size(); j++ ) {
			mealcount = mealcount + list.get(j)+";";
		}

		return mealcount;
	}
}
