package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeStampTool {
	public static String getCurrentDateTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy:HH.mm.ss");
		return formatter.format(currentDate.getTime());
	}

	public static String getCurrentDateTimeFileName() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss");
		return formatter.format(currentDate.getTime());
	}

	public static String getCurrentTime1() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		return sdf.format(new Date().getTime());
	}

	public static String getCurrentDateTimeDash() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MMM_yyyy");
		return formatter.format(currentDate.getTime());
	}

	public static String getCurrentDateTimeUS() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
		return formatter.format(currentDate.getTime());
	}

	public static String getCurrentTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(currentDate.getTime());
	}
}
