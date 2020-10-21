package pa3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimestampUtil {
	private static final long startTime = System.currentTimeMillis();
	private static final DateFormat timeFormat;
	static {
		timeFormat = new SimpleDateFormat("HH:mm:ss.SS");
		timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	
	public static String getTimestamp() {
		return timeFormat.format(new Date()).substring(0, 11);
	}

	public static String getTimestampDiff() {
		long duration = System.currentTimeMillis() - startTime;
		return timeFormat.format(duration);
	}
	
	public static String getTimestampDiffFormatted() {
		return "[" + getTimestampDiff() + "]"; 
	}
}