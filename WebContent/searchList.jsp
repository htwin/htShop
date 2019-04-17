<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>51商城</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">
<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>

	<div class="custom">
		<div id="myTab" class="container">
			<h3 class="index_h3">
				<span class="index_title"></span>
			</h3>
			<div class="ja-tab-subcontent">
				<div class="row">
					<!-- 循环显示添加12条商品信息-->
					<c:forEach items="${productList }" var="product">
						<div class="product-grid col-lg-2 col-md-3 col-sm-6 col-xs-12">
							<div class="product-thumb transition">
								<div class="actions">
									<div class="image">
										<a href="products/1/c_0001.jpgDetail.jsp?ID=49 "><img
											src="${product.pimage }" class="img-responsive" width="200px"
											height="200px"> </a>
									</div>
									<div class="button-group">
										<div class="cart">
											<button class="btn btn-primary btn-primary" type="button"
												data-toggle="tooltip" 
												onclick='javascript:window.location.href="addCartServlet?pid=${product.pid}"; '
												style="display: none; width: 33.3333%;"
												data-original-title="加入到购物车">
												<i class="fa fa-shopping-cart"></i>
											</button>
										</div>
									</div>
								</div>
								<div class="caption">
									<div class="name" style="height: 40px">
										<a href="products/1/c_0001.jpgDetail.jsp?ID=49"
											style="width: 95%"> <span style="color: #0885B1">商品名：</span>${product.pname }

										</a>
									</div>
									<div class="name" style="margin-top: 10px">
										<span class="price"> 现价：${product.shop_price }元</span><br>
										<span class="oldprice">原价：${product.market_price } 元</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- 循环显示添加12条商品信息-->
				</div>
			</div>
		</div>
	</div>
	<!-- //最新上架及打折商品展示 -->
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>