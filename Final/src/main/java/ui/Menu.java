package ui;

import utils.Utils;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Runs the program's main menu
 *
 * @author Timotej Fašiang
 */
public class Menu {

	public static Scanner sc = new Scanner(System.in);

	/**
	 * Runs the menu
	 *
	 * @return Number that signifies the option the user selected (1-4)
	 */
	public static int menuRun() {
		menuPrint();
		int choice = getInp();
		return choice;
	}

	/**
	 * Prints the menu and its options for the user in the console
	 */
	public static void menuPrint() {
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		System.out.println("                                                  ");
		System.out.println("                                                  ");
		System.out.println("   _______    _______    _           _     _      ");
		System.out.println("  (       )  (  ____ \\  | \\    /|   | |   | |   ");
		System.out.println("  | () () |  | (    \\/  |  \\  ( )   ) |   | )   ");
		System.out.println("  | || || | ( (__       |   \\ ( (   ( |   | (    ");
		System.out.println("  | |(_)| |  )  __)     | (\\ \\) )   ) |   | )   ");
		System.out.println("  | |   | | ( (         | | \\   (   ( |   | (    ");
		System.out.println("  | )   ( |  | (____/\\  | )  \\  )   | (___) |   ");
		System.out.println("  |/     \\  (________/  |/    (_)   (_______)    ");
		System.out.println("                                                  ");
		System.out.println(" " + currentDate + " " + currentTime);
		System.out.println("                                                  ");
		System.out.println(" 1) Graph heart rate data");
		System.out.println(" 2) Graph lactate data");
		System.out.println(" 3) Graph all data");
		System.out.println(" 4) Output test data");
		System.out.println(" 5) Sort athletes by name");
		System.out.println(" 6) Sort athletes by dob");
		System.out.println(" 7) Close program");
		System.out.println("                                                  ");
	}

	/**
	 * Asks the user for an input and makes sure it's a number from 1-4
	 *
	 * @return Number that signifies the option the user selected (1-4)
	 */
	public static int getInp() {
		int choices = 0;
		String selected;
		while (choices != 1 && choices != 2 && choices != 3 && choices != 4 && choices != 5 && choices != 6 && choices != 7) {
			System.out.print("Please make your selection: ");
			selected = sc.nextLine();
			try {
				choices = Integer.valueOf(selected);
				if (choices != 1 && choices != 2 && choices != 3 && choices != 4 && choices != 5 && choices != 6 && choices != 7) {
					System.out.println("Invalid selection. Selection must be an option from the menu.");
				}
			} catch (NumberFormatException e) {
				if (Utils.Contains(selected.toUpperCase())) {
					System.out.println("Please input your selection as a number not a word.");
				} else {
					selected = String.format("%s", selected);
					StringBuilder str = new StringBuilder(selected);
					str.append(" is an invalid selection. Selection must be a number.");
					System.out.println(str);
				}
			}
		}
		return choices;
	}
}
