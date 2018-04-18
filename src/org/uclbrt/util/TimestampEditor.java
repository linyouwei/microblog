package org.uclbrt.util;

import java.beans.PropertyEditorSupport;

public class TimestampEditor extends PropertyEditorSupport {
	
	private String pattern = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	public void setAsText(String text)throws IllegalArgumentException{
		if(text==null){
			setValue(null);
		}else{
			
		}
		
	}
	

}
