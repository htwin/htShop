<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String username = (String) session.getAttribute("username");

	if (username == null || username == "") {
%>
<div id="toolbar" style="background-color: #F0F0F0; width: 100%;">
	<div class="container">
		<div class="row">
			<div class="toolbar-ct-1">
				<p>
					 <a href="login.jsp">登录</a>&nbsp; ｜ &nbsp;<a href="register.jsp">注册</a>
				</p>
			</div> 
			<div class="toolbar-ct-2"> 
				<a href="myOrderServlet">我的订单</a>&nbsp;&nbsp;
			</div> 
		</div>
	</div>
	<div style="background-color: white; width: 100%">
		<div class="container">
			<div class="row">
				<div class="toolbar-ct col-xs-12 col-md-6  hidden-sm hidden-xs">
					<div class="toolbar-ct-1">
						<img src="images/mylogo.png" width="144px" height="75px">
					</div>
					<div>
						<!-- 搜索条 -->
						<div class="search_box">
							<div class="top-nav-search">
								<form method="post" id="myform" onsubmit="return checkSearch()" action="searchServlet">
									<input type="text" name="searchword" size="38" id="search" 
										style="border: 0px;" class="top-nav-search-input"
										placeholder="请输入内容" />   
										<input type="image" src="images/search.png" class="search_box_img"/>  
								</form>
							</div>
						</div>
						<!-- //搜索条 -->
					</div>
				</div>

				<div class="toolbar-ct toolbar-ct-right col-xs-12 col-md-3">


					<div class="toolbar-ct-2 "
						style="margin-top: 35px; border: 1px solid #EAEAEA; padding: 5px;">
						<a href="cart_see.jsp" style="color: #E33737; font-size: 20px;"><i
							class="fa fa-cart1"></i> 我的购物车</a>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	} else {
%>
<div id="toolbar" style="background-color: #F0F0F0; width: 100%;">
	<div class="container">
		<div class="row">
			<div class="toolbar-ct-1">
				<p> 
					您好，<font color="red"><%=username%></font>
					&nbsp; &nbsp;
					|&nbsp;&nbsp;<a href="#" onclick="logout()">退出</a>
				</p>
			</div>
			<div class="toolbar-ct-2"> 
				<a href="myOrderServlet">我的订单</a>&nbsp;&nbsp;
			</div>
		</div> 
	</div>
	<div style="background-color: white; width: 100%">
		<div class="container">
			<div class="row">
				<div class="toolbar-ct col-xs-12 col-md-6  hidden-sm hidden-xs">
					<div class="toolbar-ct-1">
						<img src="images/mylogo.png" width="144px" height="75px">
					</div>
					<div>
						<!-- 搜索条 -->
						<div class="search_box">
							<div class="top-nav-search"> 
								<form method="post" id="myform" onsubmit="return checkSearch()" action="searchServlet">
									<input type="text" name="searchword" size="38" id="search" 
										style="border: 0px;" class="top-nav-search-input"
										placeholder="请输入内容" />   
										<input type="image" src="images/search.png" class="search_box_img"/>  
								</form>
							</div>
						</div>
						<!-- //搜索条 -->



					</div>
				</div>

				<div class="toolbar-ct toolbar-ct-right col-xs-12 col-md-3">


					<div class="toolbar-ct-2 "
						style="margin-top: 35px; border: 1px solid #EAEAEA; padding: 5px;">
						<a href="cart_see.jsp" style="color: #E33737; font-size: 20px;"><i
							class="fa fa-cart1"></i> 我的购物车</a>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	}
%>
<script>
	function checkSearch(){ 
		var val = document.getElementById("search").value;
		val = val.trim(); 
		if(val == null||val==""){   
			alert("请输入搜索内容！");
			return false;
		} 
		return true;
	}
</script>
<script> 
	function logout(){
		if(confirm("确定退出登录?")){
			window.location.href="logoutServlet";
		}
	}
</script>