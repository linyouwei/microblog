package org.uclbrt.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uclbrt.util.EmptyUtil;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  String string = "2016-10-24 21:59:06";
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  try {
			System.out.println(sdf.parse(string));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
