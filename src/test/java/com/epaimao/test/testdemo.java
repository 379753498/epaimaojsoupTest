package com.epaimao.test;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.epaimao.bean.goodsBean;
import com.epaimao.service.JsoupUtil;
import com.epaimao.service.jsoupEpaimaoGoods;
import com.zeone.io.FileOperation;

public class testdemo {

	
	public static void main(String[] args) throws IOException {
		
		ArrayList<goodsBean> arr = new ArrayList<goodsBean>();
		JsoupUtil js= new JsoupUtil();
	
		for (int i = 1; i < 21; i++) {
			Document documentForURL = js.getDocumentForURL("http://www.epaimao.com/index/index/p/"+i+".html",50000);
			
			arr.addAll(jsoupEpaimaoGoods.init(documentForURL))	;

		}
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("商品名称" + "\t");
		sb2.append("商品URL" + "\t");
		sb2.append("商品原价" + "\t");
		sb2.append("优惠劵" + "\t");
		sb2.append("商品现价" + "\t");
		sb2.append("已购买人数" + "\n");
		FileOperation.writeTxFile(sb2.toString(), "易猫网");		
		for (int i = 0; i < arr.size(); i++) {
			
			goodsBean goodsBean = arr.get(i);
			
			StringBuffer sb21 = new StringBuffer();
			sb21.append(goodsBean.getGoodsname()+ "\t");
			sb21.append(goodsBean.getGoodURl()+ "\t");
			sb21.append(goodsBean.getGoodprice() + "\t");
			sb21.append(goodsBean.getGoodcoupon() + "\t");
			sb21.append(goodsBean.getGoodlastprice() + "\t");
			sb21.append(goodsBean.getGoodnumBYmaichu() + "\n");
			FileOperation.writeTxFile(sb21.toString(), "易猫网");	
		}

		
		
		
		
	
		
	}
	
	
}
