/**
 * Created on: Apr 30, 2024
 * 
 * ULID: pbnguye
 * Class: IT 179
 */
package ilstu.edu;

/**
 * MorseTree class for Morse Code program
 * @author Phillip 
 *
 */
public class MorseTree {

	private Node root;
	
	/**
	 * MorseTree default constructor
	 */
	public MorseTree() {
		root = new Node();
	}
	/**
	 * addCharacter starter method
	 * @param character - character to be used
	 * @param string - string to be used
	 */
	public void addCharacter(char character, String string) {
		root.addChar(character, string); 
	}
	/**
	 * decode starter method
	 * @param morse - morse to be used
	 * @return - char
	 */
	public char decode(String morse) {
		return root.decodeMessage(morse);
	}
	/**
	 * Inner class Node 
	 * @author Phillip Nguyen
	 *
	 */
	private class Node{
		private char character;
		private Node left;
		private Node right; 
		/**
		 * Node default constructor
		 */
		private Node() {
			this.character = ' '; 
			this.left = null;
			this.right = null;
		}
		/**
		 * addChar recursive method that adds chars to the tree
		 * @param character
		 * @param string
		 */
		private void addChar(char character, String string) {
			if(string.isEmpty()) {
				this.character = character; 
				return;
			}
			if(string.charAt(0)=='.') {
				if(left == null) {
					left = new Node();
				}
				left.addChar(character, string.substring(1)); 
			}
			else if (string.charAt(0) == '-') {
				if(right == null) {
					right = new Node();
				}
				right.addChar(character, string.substring(1));
			}
		}
		/**
		 * decodeMessage recursive method that retrieves characters from the tree to decode.
		 * @param message - message to be used
		 * @return - char
		 */
		public char decodeMessage(String message) {
			if(message.isEmpty()) {
				return character;
			}
			else {
				if(message.charAt(0) == '.') {
					if(left != null) {
						return left.decodeMessage(message.substring(1));
					}
				}
				else if (message.charAt(0) == '-') {
					if(right != null) {
						return right.decodeMessage(message.substring(1));
					}
				}
			}
			return ' ';
		}
	}
}
	
	
	
	

