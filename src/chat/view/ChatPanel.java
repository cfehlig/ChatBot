package chat.view;

import javax.swing.*;
import java.awt.event.*;
import chat.controller.ChatController;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JTextField typingField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JLabel promptLabel;
	
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		submitButton = new JButton("Click Me!");
		typingField = new JTextField("Hi I'm Chatbot!");
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 198, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, -10, SpringLayout.EAST, this);
		chatArea = new JTextArea(10,30);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -6, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		promptLabel = new JLabel("Chat with me");
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -6, SpringLayout.NORTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, promptLabel, -158, SpringLayout.EAST, this);
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here for the chatbot");
		chatArea.setEnabled(false);
	
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void changeRandomColor()
	{
		int red, green, blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
		
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//need to do this
				//Grab user typed answer
				//display typed answer
				//send the text to chatbot
				//chatbot will process
				//display the response
				String userText = typingField.getText();  //Grab user typed answer
				chatArea.append("\nUser: " + userText); //display typed answer
				typingField.setText("");
				String response = baseController.userToChatbot(userText); //send the text to chatbot 
				chatArea.append("\nChatbo " + response); //display the response
			}
		});
	}

	public JTextField getTextField()
	{
		return typingField;
	}
}
