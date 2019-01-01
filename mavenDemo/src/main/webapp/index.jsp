<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/19
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
        <form enctype="multipart/form-data" method="post" action="meal/savemeal">
            <h2><input type="text" value="菜品名称" name="mealName" ></h2>
            <hr>
            <p>菜品价格：$<input type="text" value="0.00" name="mealPrice"></p>
            <p>
                菜品类型：
                <input type="radio" name="seriesId" value="1" checked>breakfirst
                &nbsp
                <input type="radio" name="seriesId" value="2" >lunch
                &nbsp
                <input type="radio" name="seriesId" value="3" >dinner
            </p>
            <h3>菜品描述：</h3>
            <p><textarea rows="3" cols="40" style="overflow:scroll;overflow-x:hidden;" name="mealDescription"></textarea></p>
            <br><br>
            菜品类型：<input type="file" name="upload">
            <br><br>
            <input type="submit" class="btn btn-custom btn-lg page-scroll" value="Release">
        </form>


        <a href="meal/getMeal?mealId=2">getMeal</a>

        <a href="meal/getMealByKind?seriesId=2">getMealByKind</a>

        <a href="meal/deleteMeal?mealId=2">deleteMeal</a>

        <a href="order/getOrder">getOrder</a>

</body>
</html>
