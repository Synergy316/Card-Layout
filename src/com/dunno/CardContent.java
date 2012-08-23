package com.dunno;

public class CardContent 
{
	private String title = null;
	private String content = null;
	
	public CardContent(String t, String c)
	{
		this.title = t;
		this.content = c;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getContent()
	{
		return this.content;
	}
	
}
