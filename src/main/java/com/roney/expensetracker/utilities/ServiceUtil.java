package com.roney.expensetracker.utilities;

public class ServiceUtil {
	
	
	
	public static boolean isEmpty(Object obj) {
		if(obj == null) {
			return true;
		}else if(obj.toString().trim().equals("")){
			return true;
		}else if (obj.toString().trim().equalsIgnoreCase("null")) {
			return true;
		}
		
		return false;
	}

}
