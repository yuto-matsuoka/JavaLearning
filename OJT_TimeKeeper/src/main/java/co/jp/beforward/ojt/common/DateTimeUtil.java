package co.jp.beforward.ojt.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;


public class DateTimeUtil {
	public static DateTimeFormatter FORMATTER_YMD = DateTimeFormatter.ofPattern("uuuuMMdd");
	public static DateTimeFormatter FORMATTER_YMD_SLASH = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	
	public static boolean isParsable(final String value, final String... patterns) {
		return Arrays.stream(patterns).anyMatch(pattern -> isParsable(value,pattern));
	}
	
	private static boolean isParsable(final String value, final String pattern) {
		boolean ret = false;
		if(StringUtils.isNotBlank(value) && StringUtils.isNotBlank(pattern)) {
			String tmpValue = value;
			String tmpPattern = pattern;
			
			//tmpValue = tmpValue.replace("/", "");
			//tmpPattern = tmpPattern.replace("/", "");
			
			LocalDateTime localDateTime = anyParse(tmpValue,tmpPattern);
			
			if(localDateTime != null) {
				ret = true;
			}
		}
		return ret;
	}
	
	public static LocalDateTime anyParse(final String value, final String... patterns) {
		if(StringUtils.isBlank(value)) {
			return null;
		}
		
		LocalDateTime localDateTime = null;
		LocalDate localDate = null;
		
		for(String pattern:patterns) {
			try {
				LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT));
				break;
			} catch (Exception e1) {
				try {
					localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT));
					localDateTime = localDate.atStartOfDay();
				} catch (Exception e2) {
					
				}
			}
		}
		return localDateTime;
	}
	
	public static String getYmdString() {
		return LocalDateTime.now().format(FORMATTER_YMD);
	}
	
	public static String getYmdSlashString() {
		return LocalDateTime.now().format(FORMATTER_YMD_SLASH);
	}
	
}
