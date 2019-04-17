package com.shop.pojo;
/**
 * 购物项
 * @author 22850
 *
 */
public class CartItem {
	
	private Product product;//商品
	
	private int num;//购买的数量
	
	private double subTotal;//该商品的小计

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
	
}
