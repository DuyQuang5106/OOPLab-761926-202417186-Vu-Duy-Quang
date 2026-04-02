package ex64;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Month months[] = {
				new Month("January", "Jan.", "Jan", "1", 31, 31),
				new Month("February", "Feb.", "Feb", "2", 28, 29),
				new Month("March", "Mar.", "Mar", "3", 31, 31),
				new Month("April", "Apr.", "Apr", "4", 30, 30),
				new Month("May", "May", "May", "5", 31, 31),
				new Month("June", "June", "Jun", "6", 30, 30),
				new Month("July", "July", "Jul", "7", 31, 31),
				new Month("August", "Aug.", "Aug", "8", 31, 31),
				new Month("September", "Sept.", "Sep", "9", 30, 30),
				new Month("October", "Oct.", "Oct", "10", 31, 31),
				new Month("November", "Nov.", "Nov", "11", 30, 30),
				new Month("December", "Dec.", "Dec", "12", 31, 31)
				
		};
		
		Scanner keyboard = new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter month and year: ");
			String input = keyboard.nextLine();
			String data[] = input.split(" ");
			String month = data[0];
			int year = Integer.parseInt(data[1]);
			boolean found = false;
			for(Month x : months)
			{
				if(x.fullName.equals(month) || x.abbr.equals(month) || x.shortName.equals(month) || x.number.equals(month))
				{
					System.out.println(x.daysInMonth(year));
					found = true;
				}
			}
			if(found == false) 
			{
				System.out.println("Wrong format, please try again.");
			}
			else break;
		}
		keyboard.close();
	}

}
