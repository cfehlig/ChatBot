package chat.view;

import javax.swing.*;
import java.awt.event.*;
import chat.controller.ChatController;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton firstButton;
	private JTextField firstField;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		firstButton = new JButton("Click Me!");
		firstField = new JTextField("Hi I'm Chatbot!");
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(firstButton);
		this.add(firstField);
	
		
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
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				firstField.setText("Wow,This is the most amazing ChatBot ever!");
			}
		});
	}

	public JTextField getTextField()
	{
		return firstField;
	}
}
