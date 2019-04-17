<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>我的购物车-ht商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">
<link type="text/css" rel="stylesheet"
	href="js/jBox/Skins2/Pink/jbox.css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
<script type="text/javascript">
	<% Object object = session.getAttribute("user");
		if(object==null){
	%>  
		window.location.href="login.jsp";
	<%}%>
</script>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<c:if test="${cart==null }">
		<h1>您的购物车还是空空的，赶紧行动吧！！！<a href="indexServlet">去购物</a></h1>
			<div class="row">
				<img alt="" src="images/gou.png">
			</div>
		</c:if>
		<c:if test="${cart!=null }">
			<div class="row">
				<!-- 页面主体内容 -->
				<div id="mr-content" class="mr-content col-xs-12">
					<div id="mrshop" class="mrshop common-home">
						<div class="container_oc">
							<div class="row">
								<div id="content_oc" class="col-sm-12">
									<h1>我的购物车</h1>
									<!-- 显示购物车中的商品 -->
									<div class="table-responsive cart-info">
										<table class="table table-bordered">
											<thead>
												<tr>
													<td class="text-center image">商品图片</td>
													<td class="text-left name">商品名称</td>
													<td class="text-left quantity">数量</td>
													<td class="text-right price">单价</td>
													<td class="text-right total">总计</td>
												</tr>
											</thead>
											<tbody>
												<!-- 遍历购物车中的商品并显示 -->

												<c:forEach items="${cart.cartItems }" var="cartItem">
													<tr>
														<td class="text-center image" width="20%"><a
															href="goodsDetail.jsp?ID=57"> <img width="80px"
																src="${cartItem.product.pimage }">
														</a></td>
														<td class="text-left name"><a
															href="goodsDetail.jsp?ID=57">
																${cartItem.product.pname }</a></td>
														<td class="text-left quantity">${cartItem.num }件</td>
														<td class="text-right price">${cartItem.product.shop_price }元</td>
														<td class="text-right total">${cartItem.subTotal }元</td>
													</tr>
												</c:forEach>
												<!-- //遍历购物车中的商品并显示 -->
											</tbody>
										</table>
									</div>
									<!-- //显示购物车中的商品 -->
									<!-- 显示总计金额  -->
									<div class="row cart-total">
										<div class="col-sm-4 col-sm-offset-8">
											<table class="table table-bordered">
												<tbody>
													<tr>
														<span> <strong>总计:</strong>
															<p>${cart.totalPrice }元</p>
														</span>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<!-- //显示总计金额  -->
								</div>
							</div>

							<!-- 填写物流信息 -->
							<div class="row">
								<div id="content_oc" class="col-sm-12">
									<h1>物流信息</h1>
									<!-- 填写物流信息的表单 -->
									<form action="orderServlet" method="post" id="orderForm">
										<div class="table-responsive cart-info">
											<table class="table table-bordered">
												<tbody>
													<tr>
														<td class="text-right" width="20%">收货人姓名：</td>
														<td class="text-left quantity">
															<div class="input-group btn-block"
																style="max-width: 400px;">
																<input type="text" id="recevieName" name="name"
																	size="10" class="form-control">
															</div>
														</td>
													</tr>
													<tr>
														<td class="text-right">收货人手机：</td>
														<td class="text-left quantity">
															<div class="input-group btn-block"
																style="max-width: 400px;">
																<input type="text" id="tel" name="telephone" size="10"
																	class="form-control">
															</div>
														</td>
													</tr>
													<tr>
														<td class="text-right">收货人地址：</td>
														<td class="text-left quantity">
															<div class="input-group btn-block"
																style="max-width: 400px;">
																<input type="text" id="address" name="address" size="1"
																	class="form-control">
															</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</form>
									<!-- //填写物流信息的表单 -->
								</div>
							</div>
							<!-- //填写物流信息 -->
							<br />
							<!-- 显示支付方式 -->
							<div class="row">
								<div id="content_oc" class="col-sm-12">
									<h1>支付方式</h1>
									<div class="table-responsive cart-info">
										<table class="table table-bordered">
											<tbody>
												<tr>
													<td class="text-left"><img src="images/zhifubao.png" /></td>
												</tr>
											</tbody>
										</table>
									</div>
									<br /> <br />
									<div class="buttons">
										<div class="pull-left">
											<a href="indexServlet" class="btn btn-primary btn-default">继续购物</a>
										</div>
										<div class="pull-left">
											<a href="#" onclick="clearCart()" class="btn btn-primary btn-default">清空购物车</a>
										</div>
										<div class="pull-right">
											<a href="javascript:zhifu();"
												class="tigger btn btn-primary btn-primary">结账</a>
										</div>
									</div>
								</div>
							</div>
							<!-- //显示支付方式 -->
						</div>
					</div>
				</div>
				<!-- //页面主体内容 -->
			</div>
		</c:if>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->

	<!-- 使用jBox插件实现一个支付对话框 -->
	<script type="text/javascript" src="js/jBox/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jBox/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript">
		function clearCart(){
			if(confirm("确认要清空购物车？？")){
				window.location.href="clearCartServlet"; 
			}
		}
	</script>
	<script type="text/javascript">
		function zhifu() {
			//验证收货人姓名
			if ($('#recevieName').val() === "") {
				alert('收货人姓名不能为空！');
				return;
			}
			//验证收货人手机
			if ($('#tel').val() === "") {
				alert('收货人手机不能为空！');
				return;
			}
			//验证手机号是否合法
			if (isNaN($('#tel').val())) {
				alert("手机号请输入数字");
				return;
			}
			//验证收货人地址
			if ($('#address').val() === "") {
				alert('收货人地址不能为空！');
				return;
			}
			//设置对话框中要显示的内容  
			document.getElementById('orderForm').submit();//提交表单
		}
	</script>
	<!-- // 使用jBox插件实现一个支付对话框 -->
</body>
</html>
