package ex64;

public class Month {
	String fullName;
	String abbr;
	String shortName;
	String number;
	int daysInCommonYear;
	int daysInLeapYear;
	
	Month(String f, String a, String s, String n, int d1, int d2)
	{
		fullName = f;
		abbr = a;
		shortName = s;
		number = n;
		daysInCommonYear = d1;
		daysInLeapYear = d2;
	}
	
	int daysInMonth(int year)
	{
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
		{
			return daysInLeapYear;
		}
		else return daysInCommonYear;
	}
}

