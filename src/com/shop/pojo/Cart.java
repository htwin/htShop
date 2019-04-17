package com.shop.pojo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车对象
 * 
 * @author 22850
 *
 */
public class Cart {
	private double totalPrice;// 总价
	// 购物项 (key：id value：cartItem)方便移除购物项
	private Map<String, CartItem> cartItems = new HashMap<String, CartItem>();

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Collection<CartItem> getCartItems() {
		return cartItems.values();
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	// 添加商品到购物车
	public void addCart(Product product, int num) {
		if(product == null) {
			return;
		}
		
		//判断购物车是否有该商品，如果有，数量相加，总价相加
		CartItem cartItem = cartItems.get(product.getPid());
		if(cartItem==null) {
			cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setNum(num);
			cartItem.setSubTotal(product.getShop_price()*num);
			cartItems.put(product.getPid(),cartItem);
		}else {
			cartItem.setNum(cartItem.getNum()+num);
			cartItem.setSubTotal(product.getShop_price()*cartItem.getNum());
		}
		totalPrice += product.getShop_price()*num;
		
	}
}
