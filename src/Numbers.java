import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Numbers {
	private Float[] numbers;
	private int numItems = 0;
	private Formatter output;
	private Scanner input;
	private boolean fileCheck = true;

	public Numbers() {
		numbers = new Float[5];
	}

	public Numbers(int size) {
		numbers = new Float[size];
	}

	public void addValue(Scanner keyboard) {
		if (numbers.length == numItems) {
			System.out.println("Array is full");
		}
		if (numbers.length != numItems) {
			try {
				System.out.print("Enter value: ");
				float x = keyboard.nextFloat();
				if (x < Float.MAX_VALUE) {
					numbers[numItems] = x;
					numItems++;
				} else {
					System.out.println("Number Enter is too large, Please try again!");
				}
			} catch (Exception e) {
				System.out.println("Invalid Entry - Please try again\n");
				keyboard.nextLine();
			}
		}
	}

	public float calcAverage() {
		float total = 0;
		
		if (numItems == 0) {

			System.out.print("Average is: ");
			System.out.println(numItems);
			return (float) 0.0;
		}

		for (int i = 0; i < numItems; i++) {
			total = total + numbers[i];
		}
		
		System.out.print("Average is: ");
		System.out.println(total / numItems);
		return (float) 0.0;
	}

	@Override
	public String toString() {
		System.out.println("Numbers are: ");

		for (int i = 0; i < numItems; i++) {
			System.out.println(numbers[i]);
		}
		return "";
	}

	public void openInputFile(String IOfile) {
		File file = new File(IOfile);
		
		try {
			input = new Scanner(file);
		} catch (Exception e) {
			fileCheck = false;
			System.out.println("Error: File " + IOfile + " Does not exist" );
		}
	}

	public void closeInputFile() {
		input.close();
	}

	public void openOutputFile(String IOfile) {
		File file = new File(IOfile);
		
		try {
			output = new Formatter(file);
		} catch (FileNotFoundException ex) {
			fileCheck = false;
			System.out.println("Error: File Not found or Does not exist" + ex);
		}
	}

	public void closeOutputFile() {
		output.close();
	}

	public void readValue(Scanner keyboard) {
		System.out.print("Name of the file to read from: ");
		String fileName = keyboard.next();
		openInputFile(fileName);
		int inputted = 0;
		
		if (fileCheck == true) {
			while (input.hasNext()) {
				if (numItems == numbers.length) {
					System.out.println("Array is now full, inputted " + inputted + " float values");
					break;
				} else {
					float temp = input.nextFloat();
					numbers[numItems] = temp;
					numItems++;
					inputted++;
				}
			}
			closeInputFile();
		}
	}

	public void saveValue(Scanner keyboard) {
		System.out.print("Name of the file to save to: ");
		String fileName = keyboard.next();
		openOutputFile(fileName);
		
		if (numItems != 0) {
			for (int i = 0; i < numItems; i++) {
				String temp = "" + numbers[i];
				output.format(temp + "\n");
			}
		} else {
			System.out.println("Array is Empty");
		}
		closeOutputFile();
	}

	public void addMultipleValues(Scanner keyboard) {
		if (numbers.length == numItems) {
			System.out.println("Array is full");
		}
		if (numbers.length != numItems) {
			try {
				System.out.println("How many values do you wish to add? ");
				int temp = keyboard.nextInt();
				
				for (int x = 0; x < temp; x++) {
					if (numbers.length == numItems) {
						System.out.println("Array is now full");
						break;
					} else {
						addValue(keyboard);
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid Entry - Please try again\n");
				keyboard.nextLine();
			}
		}

	}

	public void sortArray() {
		if (numItems != 0) {
			for (int x = 1; x < numItems; x++) {
				float newElement = numbers[x];
				int i;
				
				for (i = x; i > 0 && numbers[i - 1] > newElement; i--) {
					numbers[i] = numbers[i - 1];
				}
				numbers[i] = newElement;
			}
		} else {
			System.out.println("Array is Empty");
		}
	}
}
