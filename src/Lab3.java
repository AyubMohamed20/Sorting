import java.util.Scanner;

public class Lab3 {
	
	public static void main(String[] args) {

		Numbers test = new Numbers();
		Scanner scanner = new Scanner(System.in);
		boolean vaild = false;
		int i = 0;

		while (vaild == false || i != 10) {
			try {
				vaild = false;
				displayMainMenu();
				i = scanner.nextInt();

				if (i > 0 && i < 11) {
					vaild = true;
				} else if (i < 1 || i > 10) {
					System.out.println("Invalid Entry - Please try again\n");
				}
				
				if (vaild == true) {
					switch (i) {
					case 1:
						test = new Numbers();
						break;
					case 2:
						try {
							System.out.print("Enter new size of array: ");
							int x = scanner.nextInt();
							test = new Numbers(x);

						} catch (Exception e) {
							System.out.println("Invalid Entry - Please try again\n");
							scanner.nextLine();
						}
						break;
					case 3:
						test.addValue(scanner);
						break;
					case 4:
						test.toString();
						System.out.println();
						break;
					case 5:
						test.calcAverage();
						break;
					case 6:
						test.addMultipleValues(scanner);
						break;
					case 7:
						test.readValue(scanner);
						break;
					case 8:
						test.saveValue(scanner);
						break;
					case 9:
						test.sortArray();
						break;
					case 10:
						System.out.println("Exiting...");
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid Entry - Please try again\n");
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	public static void displayMainMenu() {
		System.out.println("Please select one of the following:" + "\n1: Initialize a default array"
				+ "\n2: To specify the max size of the array" + "\n3: Add value to the array"
				+ "\n4: Display values in the array" + "\n5: Display the average of the values"
				+ "\n6: Enter multiple values" + "\n7: Read values from file" + "\n8: Save values to file"
				+ "\n9: Sort the array" + "\n10: To Exit");
		System.out.print(">");
	}
}
