<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="queryByUserID.action">
Id:<input type="text" name="userID">
<input type="submit">
</form>

查询购物车
<form action="queryShopCarByUserID.action">
Id:<input type="text" name="userID">
<input type="submit">
</form>

查询菜品信息
<form action="queryMealByMealId.action">
Id:<input type="text" name="userID" id="username">
<button type="button" id="btn">提交</button>

 <div id="register_reminder" style="text-align: center">
 </div>
</form>

添加进入购物车
<form action="saveMeal.action">
userId:<input type="text" name="userID">
mealId:<input type="text" name="mealID">
mealCount:<input type="text" name="mealCount">
<input type="submit">
</form>
从购物车删除
<form action="deleteFromShopCar.action">
userId:<input type="text" name="userID">
mealId:<input type="text" name="mealID">
<input type="submit">
</form>

</body>

<script type="text/javascript">
	function search(){
		//let id = $("#username").val();
		$.ajax({

            url:'http://localhost:8080/mavenDemo/test/queryMealByMealId.action',//相对应的esb接口地址

            type:'post',

            data:{"userID":1002},//向服务器（接口）传递的参数
            
            success:function(data){//服务器（接口）返回来的数据
            	let datas = data.extend.mealInfo;
             	let str = '';
            	if(data.code == 100){

            		 for(let i=0; i<datas.length;i++){
            			 str += '<h2>'+datas[i].mealName+'</h2>';
            			 str += '<h3>'+datas[i].mealPrice+'</h3>';
            			 str += '<h4>'+datas[i].mealCount+'</h4>';
            		 }
            		$("#register_reminder").html(str);
            	}
            	
            }
	
		})
	}
	
	$(function (){
	    search();

	});
</script>
</html>