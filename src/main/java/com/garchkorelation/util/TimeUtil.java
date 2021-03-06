package com.garchkorelation.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {

	static final long ONE_MINUTE_IN_MILLIS = 60000;
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static DateFormat userDateFormat = new SimpleDateFormat("MMMMM dd, yyyy", Locale.ENGLISH);

	public static String getCurrentTime() {
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getExpirationDateForToken() {
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date afterAddingTenMins = new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
		return dateFormat.format(afterAddingTenMins);
	}
	
	public static Date getDatefromString(String date){
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getFormatedDate(String date) {
		return userDateFormat.format(getDatefromString(date)).toString();
	}
	

}
