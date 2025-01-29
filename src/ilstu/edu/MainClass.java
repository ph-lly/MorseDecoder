/**
 * Created on: Apr 30, 2024
 * 
 * ULID: pbnguye
 * Class: IT 179
 */
package ilstu.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MainClass for Morse Code program
 * @author Phillip
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MorseTree morse = buildTree("morse_code.txt");
		Scanner scan = new Scanner(System.in);
		
		if(morse !=null) {
			boolean flag = true;
			do {
				System.out.print("Please enter encoded message or stop to exit: "); //add an extra space before next word, but i guess they wouldn't know where the word ends
				String message = scan.nextLine();
				if(message.equalsIgnoreCase("stop")) {
					System.out.println("Thank you for using our decoder!");
					flag = false;
					break;
				}
				String stringToDecode = decode(message, morse);
				if(stringToDecode == null) {
					System.out.println("Please enter a valid Morse Code!");
				}
				else {
					System.out.println("The decoded message is: " + stringToDecode);
				}
			}
			while(flag);
		}
		scan.close();
	}	
	/**
	 * buildTree method that builds a MorseTree from the file
	 * @param fileName - fileName to be used
	 * @return MorseTree
	 */
	private static MorseTree buildTree(String fileName) {
		MorseTree morse = new MorseTree();
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				char character = line.charAt(0);
				String code = line.substring(2); 
				morse.addCharacter(character, code);
			}
			scan.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("Error while reading " + fnfe.getMessage());
			return null;
		}
		return morse;
	}
	/**
	 * decode method that decodes morse code
	 * @param message - message to be used
	 * @param morseTree - morseTree to be used
	 * @return - String
	 */
	private static String decode(String message, MorseTree morseTree) {
		String decode = "";
		String[] morse = message.split("  ");
		for(String m : morse) {
			String[] morseLetters = m.split(" ");
			for(String morseLetter : morseLetters) {
				char decodedChar = morseTree.decode(morseLetter);
				if(decodedChar == ' ') {
					return null;
				}
				decode += decodedChar;			
			}	
			decode += " ";
		}
		return decode;
	}
}
