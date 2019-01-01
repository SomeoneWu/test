<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html; charset=GBK"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GBK">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>购物车</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet -->
<link rel="stylesheet" type ="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nivo-lightbox/default.css">
</head>
<body id="page-top" data-spy="scroll" data-target=".navber-fixed-top">

<!-- Navigation -->
<nav id="menu" class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
  			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			  <a class="navbar-brand page-scroll" href="#page-top">桂堂</a>
		</div>
		
		<!-- 导航栏内容 -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		
		</div>
	</div>
</nav>
<div id="restaurant-menu">
  <div class="section-title text-center center">
    <div class="overlay">
      <h2>购物车</h2>
      <hr>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit duis sed.</p>
    </div>
  </div>
  
  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-6">
        <div class="menu-section">
        <a href="${pageContext.request.contextPath}/queryMealByMealId.action?userID=1001">购物车</a>
          <s:iterator var="info" value="mealInfo" status="status">
          	<div class="menu-item">
          		<div class="menu-item-name"><s:property value="#info.mealName"/></div>
          		<div class="menu-item-price"><s:property value="#info.mealPrice"/></div>
          		<a class="menu-item-description" href="${pageContext.request.contextPath}/deleteFromShopCar.action?userID=1001&mealID=${info.mealID}">delete</a>
          		<form id="countForm">
				<input type="text" name="amount" value=1 id="count">
				<input id="plus" type=button value="+" onClick="javascript:this.form.amount.value++;">
				<input id="minus"type=button value="-" onClick="javascript:if(this.form.amount.value>1) this.form.amount.value--;">
				</form>
          		<div class="menu-item-description"><s:property value="#info.mealDescription"/></div>          		
          	</div>
          </s:iterator>
          
          </div>
        </div>
      </div>
    </div>
  
        </div>
      </div>
    </div>
  </div>
</div>
<div style="margin-left:90%" id="price">
			<div class="menu-item-name" id="show"></div>
<input type="submit" class="btn btn-custom btn-lg page-scroll" value="Submit" id="sub">
</div>
	
	


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/SmoothScroll.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/nivo-lightbox.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.isotope.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jqBootstrapValidation.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/contact_me.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript">
</script>

<script type="text/javascript">
$("#plus").click(
	function(){
		let count = $("#count").val();
		let price = ${info.mealPrice};
		let total = count * price;
		let str = '';
		str += '<div class="menu-item-name" id="show">';
		str += 'Total Price </div>';
		str += '<div class="menu-item-price">$';
		str += total;
		str += '</div>';
		$("#show").html(str);
		
	}		
)

$("#minus").click(
	function(){
		let count = $("#count").val();
		let price = ${info.mealPrice};
		let total = count * price;
		let str = '';
		str += '<div class="menu-item-name" id="show">';
		str += 'Total Price </div>';
		str += '<div class="menu-item-price">$';
		str += total;
		str += '</div>';
		
		$("#show").html(str);
	}		
)

$("#sub").click(
	function(){
		let count = $("#count").val();
		$.ajax({
            url:'http://localhost:8080/mavenDemo/test/saveMeal.action',//相对应的esb接口地址
            type:'post',
            data:{"userID":1001 , "mealID":1 , "mealCount":count},//向服务器（接口）传递的参数           
            success:function(data){//服务器（接口）返回来的数据
            	let datas = data.extend.mealInfo;
            	if(data.code == 100){
            		alert("success");
            		}
            	}
        	})
        }
)

</script>

</html>