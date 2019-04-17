<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">
<script src="js/jquery-1.11.3.min.js"type="text/javascript"></script>
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
			<div id="mr-content"
				class="mr-content col-xs-12 col-sm-12 col-md-9 col-md-push-3">
				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<div class="row">
							<div id="content_oc" class="col-sm-12 view-product">
								<!-- 根据商品ID获取并显示商品信息 -->
								
								<!-- 显示商品详细信息 -->
								<div class="row">
									<div class="col-xs-12 col-md-4 col-sm-4">
										<ul class="thumbnails" style="list-style: none">
											<li><a class="thumbnail" href="#"> <img src="${product.pimage }"></a></li>
										</ul>
									</div>
									<div class="col-xs-12 col-md-8 col-sm-8">
										<div style="margin-left: 30px; margin-top: 20px">
											<h1 class="product-title">${product.pname }</h1>
											<ul class="list-unstyled price"><li><h2>${product.shop_price }元</h2></li></ul>
											<ul class="list-unstyled price"><li>原价: ${product.shop_price }元</li></ul>
											<div class="rating"><p>商城活动：全场满99包邮</p></div>
											<div id="product"><hr>
												<div class="form-group">
													<label class="control-label" for="shuliang"> 数量 </label>
													<input type="number"  name="num" value="1" size="2"
														id="num" class="form-control"> <br>
													<div class="btn-group">
														<button type="button" onclick="addCart()" class="btn btn-primary btn-primary">
															<i class="fa fa-shopping-cart"></i> 添加到购物车</button>
														<button type="button" id="button-wishlist" data-toggle="tooltip" class="btn"
														 title="收藏" data-original-title="收藏"> <i class="fa fa-heart"></i></button>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-12 description_oc clearfix">
										<ul class="nav nav-tabs htabs">
											<li class="active" style="width: 150px"><a href="#tab-description" data-toggle="tab"
												aria-expanded="true">商品描述</a></li>
										</ul>
										<div class="tab-content" style="border: 1px solid #eee; overflow: hidden;">
											<div class="tab-pane active" id="tab-description">
												${product.pdesc} 
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
	<script type="text/javascript">
		function addCart(){
			var num = document.getElementById("num").value;
			window.location.href='addCartServlet?pid=${product.pid}&num='+num;
		}
	</script>
	

</body>
</html>
