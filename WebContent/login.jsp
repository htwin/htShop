<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>登录-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">
<script src="js/jquery-1.11.3.min.js"type="text/javascript"></script>
</head>

<body>
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- 主体内容 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div class="login-wrap" style="margin-bottom: 60px; margin-top: 50px">
					<div style="max-width: 540px; margin: 0 auto;">
						<a href="index.jsp" title="点击返回首页"><img src="images/51logo.png"></a>
					</div>
					<div class="login">
						<div class="page-header" style="pause: 0px;"> <h1 class="login_h1">会员登录</h1> </div>
						<!-- 会员登录表单 -->
						<form action="loginServlet" method="post" class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="username-lbl" for="username" class="required">账户 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 账户文本框 -->
										<input type="text" name="username" onchange="clearError()" value="${username }" id="username" value="" size="38"
											class="validate-username required" required="required" autofocus="">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">密码 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 密码文本框 -->
										<input type="password" name="password" onchange="clearError()" value="${password }" id="password" value=""
											class="validate-password required" size="38" maxlength="99"
											required="required" aria-required="true">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">验证码 ：</label>
									</div>
									<div class="col-sm-8" style="clear: none;">
										<!-- 验证码文本框 -->  
										<input type="text" name="checkCode" onfocus="clearError()" id="checkCode" value=""
											class="validate-password required" style="float: left;"
											title="验证码不区分大小写" size="18" maxlength="6" required="required"
											aria-required="true">   
											<!-- 显示验证码 -->  
											<img alt="验证码" onclick="changeCode()" id="code" src="checkCode" style="border: 1px #f2f2f2 solid; margin-left: 20px" width="96" height="36">
											
									</div>
								</div> 
								<div>    
									<div class="col-sm-4 control-label"> 
										<label id="error"  for="password" class="required"><font color="red">${error }</font></label>
									</div> 
								</div>
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-8">
										<button type="submit" class="btn btn-primary login">登录</button>
									</div>
								</div>
								<div class="form-group"
									style="border-top: 1px solid #D9D9D9; margin: 20px;">
									<label
										style="float: right; color: #858585; margin-right: 40px; margin-top: 10px; font-size: 14px;">没有账户？<a
										href="register.jsp">立即注册</a></label>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<!-- //主体内容 -->
		</div>
	</div>
	
	<script type="text/javascript"> 
		//更换校验码
		function changeCode(){
			var img = document.getElementById("code");
			img.src="checkCode?date="+new Date();    
		}    
		//聚焦，清楚session中error
		function clearError(){
			document.getElementById("error").hidden = "hidden"; 
		}
	</script>
	<script language="javascript">
		//刷新验证码
		function myReload() {
			document.getElementById("img_checkCode").src = document
					.getElementById("img_checkCode").src + "?nocache=" + new Date().getTime();
		}
	</script>
	<script type="text/javascript">
	$(function(){
		//如果有回显的邮箱，则注册页面提交过来的
		<% 
			String registerMessage = (String)session.getAttribute("registerMessage"); 
			session.removeAttribute("registerMessage");
			if(registerMessage!=null){ 
		%>   
			alert('<%=registerMessage%>');          
		<% }%> 
		//如果为激活跳转activeMessage
		<% 
			String activeMessage = (String)session.getAttribute("activeMessage"); 
			session.removeAttribute("activeMessage");
			if(activeMessage!=null){ 
		%>   
			alert('<%=activeMessage%>');          
		<% }%> 
	});
</script>
</body>
</html>