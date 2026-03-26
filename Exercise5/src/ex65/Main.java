package ex65;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Type in your array: ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		String inputs[] = input.split(" ");
		
		int numbers[] = new int[inputs.length];
		int sum = 0;
		for(int i = 0; i < inputs.length; i++)
		{
			numbers[i] = Integer.parseInt(inputs[i]);
		sum = sum + numbers[i];
		}
		
		Arrays.sort(numbers);
		
		double average = (double)sum / numbers.length;
		
		System.out.println("Sorted array: " + Arrays.toString(numbers));
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + average);
		keyboard.close();
	}

}

