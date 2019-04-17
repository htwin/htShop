<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>我的购物车-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">
<link type="text/css" rel="stylesheet"
	href="js/jBox/Skins2/Pink/jbox.css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>

</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- 页面主体内容 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
					<c:if test="${orderList[0].orderItems == null }">
						<div class="row">   
							<h1>您还没有购买过任何东西！！！</h1> 
						</div> 
					</c:if>
						<c:forEach items="${orderList }" var="order">
							<div class="row">
								<div id="content_oc" class="col-sm-12">
									<h1>我的订单-->&nbsp;&nbsp;订单编号:&nbsp;&nbsp;${order.oid }</h1>
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

												<c:forEach items="${order.orderItems }" var="orderItem">
													<tr>
														<td class="text-center image" width="20%"><a
															href="goodsDetail.jsp?ID=57"> <img width="80px"
																src="${orderItem.product.pimage }">
														</a></td>
														<td class="text-left name"><a
															href="goodsDetail.jsp?ID=57">
																${orderItem.product.pname }</a></td>
														<td class="text-left quantity">${orderItem.count }件</td>
														<td class="text-right price">${orderItem.product.shop_price }元</td>
														<td class="text-right total">${orderItem.subtotal }元</td>
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
															<p>${order.total  }元</p>
														</span>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<!-- //显示总计金额  -->
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- //页面主体内容 -->
		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
</body>
</html>
