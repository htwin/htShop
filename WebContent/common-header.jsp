<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header id="mr-header" class="wrap mr-header">
	<div class="container">
		<div class="row">
			<!-- //网站Logo -->
			<!-- 主导航条 -->
			<nav id="mr-mainnav"
				class="col-xs-12 col-md-6 mr-mainnav navbar navbar-default">
				<div class="mr-navbar navbar-collapse collapse">
					<div class="mr-megamenu animate slide" data-duration="400"
						data-responsive="true">
						<ul class="nav navbar-nav level0">
							<li><a href="indexServlet">首页 </a></li>
						</ul>
						<ul id="category" class="nav navbar-nav level0">
						</ul>
					</div>
				</div>
			</nav>
			<!-- //主导航条 -->
		</div>
	</div>
</header>
<script>
	$(function(){
		var content = "";
		$.post(
			"categoryListServlet",
			function(data){
				for(var i=0;i<data.length;i++ ){
					content += "<li><a href='productListByCidServlet?cid="+data[i].cid+"'>"+data[i].cname+"</a></li>"
				}
				$("#category").html(content);
			},
			"json"
		);
	});
	// 获取页面参数
	function GetString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");//正则表达式
		var r = window.location.search.substr(1).match(reg);//获取鼠标点击区域
		if (r != null)
			return unescape(r[2]);//返回区域编号
		return null;
	}
	var type = GetString('type');
	if (type === '14') {
		var jingying = document.getElementById('jingying');
		jingying.style.backgroundColor = "#9E2626";

	}
	if (type === '15') {
		var wenyi = document.getElementById('wenyi');
		wenyi.style.backgroundColor = "#9E2626";

	}
	if (type === '16') {
		var jiaoyu = document.getElementById('jiaoyu');
		jiaoyu.style.backgroundColor = "#9E2626";

	}
	if (type === '17') {
		var shenghuo = document.getElementById('shenghuo');
		shenghuo.style.backgroundColor = "#9E2626";

	}
</script>