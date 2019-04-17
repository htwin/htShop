package com.shop.utils;

public class PageBean {
	private int total;//总数
	private int currentPage;//当前页
	private int rows;//一页显示条数
	
	//开始索引，页面第一条数据
	public int getStart() {
		return (currentPage-1)*rows;
	}
	
	//页数
	public int getPages() {
		return total%rows==0?total/rows:(total/rows)+1;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
}
