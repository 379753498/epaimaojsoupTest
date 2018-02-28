package com.epaimao.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupUtil {

	/**
	 * 根据网页链接参数返回当前网页的文档对象
	 * @param URL
	 * @return document对象
	 * @throws IOException
	 */
	public  Document  getDocumentForURL(String URL) throws IOException
	{
		Document document = Jsoup.connect(URL).timeout(10000).get();

		return document;
	}
	/**
	 * 
	 * @param URL 网页链接
	 * @param timeout  等待时间
	 * @return document对象
	 * @throws IOException
	 */
	
	public  Document  getDocumentForURL(String URL ,int timeout) throws IOException
	{
		Document document = Jsoup.connect(URL).timeout(timeout).get();

		return document;
	}
	
	
	
	public Elements getElementList(Document document,String key)
	{
		
		return document.select(key);
		
	}
	
	
	
	
	
	
}
