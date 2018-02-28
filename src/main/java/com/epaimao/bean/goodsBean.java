package com.epaimao.bean;

public class goodsBean {


	
	@Override
	public String toString() {
		return "goodsBean [goodsname=" + goodsname + ", goodprice=" + goodprice
				+ ", goodcoupon=" + goodcoupon + ", goodURl=" + goodURl
				+ ", goodlastprice=" + goodlastprice + ", goodnumBYmaichu="
				+ goodnumBYmaichu + "]";
	}
	private String goodsname;
	private double goodprice;
	private String goodcoupon;
	private String goodURl;

	private double goodlastprice;
	private int goodnumBYmaichu;
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public double getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(double goodprice) {
		this.goodprice = goodprice;
	}
	public String getGoodcoupon() {
		return goodcoupon;
	}
	public void setGoodcoupon(String goodcoupon) {
		this.goodcoupon = goodcoupon;
	}
	public String getGoodURl() {
		return goodURl;
	}
	public void setGoodURl(String goodURl) {
		this.goodURl = goodURl;
	}
	public double getGoodlastprice() {
		return goodlastprice;
	}
	public void setGoodlastprice(double goodlastprice) {
		this.goodlastprice = goodlastprice;
	}
	public int getGoodnumBYmaichu() {
		return goodnumBYmaichu;
	}
	public void setGoodnumBYmaichu(int goodnumBYmaichu) {
		this.goodnumBYmaichu = goodnumBYmaichu;
	}
}
