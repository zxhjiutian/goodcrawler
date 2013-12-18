/**
 * @工程 goodcrawler
 * @文件 HtmlElement.java
 * @时间 2013年12月18日 下午4:42:42
 * @作者 shenbaise（shenbaise1001@126.com）
 * @描述 
 */
package org.sbs.goodcrawler.extractor.htmlelment;

import java.util.Map;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author shenbaise（shenbaise1001@126.com）
 * @param <E>
 * @desc html元素选择器。支持xpath、ID两种方式进行提取。
 * <br>主要用于提取<code>javascript</code>生成的内容以及由ajax调用生成的内容。
 * <br><b>注意</b><i>除非有<code>javascript</code>生成的内容需要抓取，否则强烈不建议使用该元素</i>
 */
public abstract class AbstractHtmlElement<E> {
	/**
	 * webClient
	 */
	protected WebClient webClient;
	/**
	 * 页面
	 */
	protected HtmlPage page;
	/**
	 * 选择器名称
	 */
	protected String name;
	/**
	 * 选择器值，对应xpath或者tagName、id等。
	 */
	protected String value;
	/**
	 * 使用的提取方式，默认为xpath
	 */
	protected HtmlElementExtractType type = HtmlElementExtractType.xpath;
	
	protected boolean newPage = true;
	
	protected boolean isRequired;
	/**
	 * 构造器
	 */
	public AbstractHtmlElement(){}
	/**
	 * 构造器
	 * @param webClient
	 * @param page
	 * @param name
	 * @param value
	 * @param type
	 * @param isRequired
	 */
	public AbstractHtmlElement(WebClient webClient, HtmlPage page, String name,
			String value, HtmlElementExtractType type, boolean isRequired) {
		super();
		this.webClient = webClient;
		this.page = page;
		this.name = name;
		this.value = value;
		this.type = type;
		this.isRequired = isRequired;
	}



	/**
	 * 返回内容
	 * @return
	 */
	public abstract E getContent();
	
	public abstract Map<String, E> getContentMap();
	
	public HtmlPage getPage() {
		return page;
	}

	public void setPage(HtmlPage page) {
		this.page = page;
		this.newPage = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HtmlElementExtractType getType() {
		return type;
	}

	public void setType(HtmlElementExtractType type) {
		this.type = type;
	}
	public boolean isNewPage() {
		return newPage;
	}
	public void setNewPage(boolean newPage) {
		this.newPage = newPage;
	}
	public boolean isRequired() {
		return isRequired;
	}
	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
	public void setNewPage(){
		this.newPage = true;
	}
}
