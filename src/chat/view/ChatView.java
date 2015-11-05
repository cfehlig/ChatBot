package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * POpup display class for GUI interaction in the Chatbot project.
 * @author cfeh7454
 *@version 1.0 10/21/15
 */

public class ChatView 
{
	/**
	 * Displays a GUI popup for collecting user text with the supplied String.
	 * Usually in the form of a question to collect for further use in the program.
	 * @param displayText The Text to show in the popup window. Should be a question
	 * @return The text supplied by the user.
	 */
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Hello from your friendly chatbot :D";
		chatIcon = new ImageIcon(getClass().getResource("images/cat.png"));
		
	}
	
	public String collectUserText(String displayText)
	{
		String userInput ="";
				
		userInput = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE,chatIcon, null, "Answer here :)").toString();
		
		return userInput;
	}
	
	/**
	 * Displays a String to the user with a standard popup.
	 * @param displayText The supplied text to be displayed.
	 */
	
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}
	

}
