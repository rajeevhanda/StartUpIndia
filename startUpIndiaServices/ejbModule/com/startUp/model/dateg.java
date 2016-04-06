package com.startUp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.xb.binding.sunday.xop.SimpleDataSource;

import sun.java2d.pipe.SpanShapeRenderer.Simple;


public class dateg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date d=new Date();
		SimpleDateFormat myf=new SimpleDateFormat("yyyy-MM-dd");
		myf.format(d);
		System.out.println(myf.format(d)+2);
		
	}

}
