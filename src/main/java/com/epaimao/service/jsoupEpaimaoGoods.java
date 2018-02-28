package com.epaimao.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.epaimao.bean.goodsBean;

public class jsoupEpaimaoGoods {

	
	public static goodsBean SelectInfo(Element element){
		goodsBean goodbean= new goodsBean();
		String url="http://www.epaimao.com";
		goodbean.setGoodURl(url+element.select("a[class=pic-img]").attr("href"));
		 
		goodbean.setGoodsname(element.select("h3[class=good-title]").text());
		
		String maich = element.select("span[class=sold]").select("em").text();
		
		 int parseInt = Integer.parseInt(maich);
		 goodbean.setGoodnumBYmaichu(parseInt);
		 goodbean.setGoodcoupon(element.select("span[class=num]").text());
		 goodbean.setGoodprice(Double.parseDouble(getString (element.select("span[class=price-old]").text())));
		 goodbean.setGoodlastprice(Double.parseDouble(getString(element.select("span[class=price-current]").text())));
		 
		
		return goodbean;
		
	}
	
	
	public static   String getString(String   str)   throws   PatternSyntaxException   {      
		  // 只允许字母和数字        
		  // String   regEx  =  "[^a-zA-Z0-9]";                      
		  // 清除掉所有特殊字符   
		  String regEx="[`~!@#$%^&*()+=|{}':;',//[//]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";   
		  Pattern   p   =   Pattern.compile(regEx);      
		  Matcher   m   =   p.matcher(str);      
		  return   m.replaceAll("").trim();      
		   }
	
	
	
	
	public  static ArrayList<goodsBean> init(Document documentForURL) {
		
		
		ArrayList<goodsBean> arr = new ArrayList<goodsBean>(500);
		Elements selectFirst = documentForURL.select("ul[class=goods-list clear]");//查找元素标签为ul其内部元素有class 且等于goods-list clear 的元素列表
		
		Element ulelement = selectFirst.get(0);
		
		Elements shopElementlist = ulelement.select("li");
		for (Element element : shopElementlist) {
			
			arr.add(jsoupEpaimaoGoods.SelectInfo(element));	
			
			
			
		}
		return arr;
	}
	
	
}

