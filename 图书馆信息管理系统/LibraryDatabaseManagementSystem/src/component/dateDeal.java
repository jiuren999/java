package component;

public class dateDeal {
	
	//补齐0
	public static String fillZero(String s){
		if(s.length() == 1) {
			return "0" + s;
		}else {
			return s;
		}
	}
	
	//date格式"xxxxxxxx"
	public static String dateAdd(String date, int days){
		boolean leapYear = false;
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8));
		if(year / 4 * 4 == year) {
			if(year / 100 * 100 == year) {
				if(year / 400 * 400 == year) {
					leapYear = true;
				}
			}else{
				leapYear = true;
			}
		}
		int[] month_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(leapYear) {
			month_days[1] = 29;
		}
		day += days;
		if(day <= month_days[month - 1]) {
			return fillZero(String.valueOf(year)) + "-" + fillZero(String.valueOf(month)) + "-" + fillZero(String.valueOf(day));
		}else {
			day -= days;
			days -= month_days[month - 1] - day + 1;
			day = 1;
			month++;
			if(month == 13) {
				month = 1;
				year++;
			}
			return dateAdd(fillZero(String.valueOf(year)) + "-" + fillZero(String.valueOf(month)) + "-" + fillZero(String.valueOf(day)), days);
		}
	}
	
}
