package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
import chat.view.ChatFrame;

/**
 * Controller for the Chatbot project.
 * @author cfeh7454
 *@version 1.0 11/5/15 Displays the Chatbot'suserName variable.
 */

public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.collectUserText("What is your name?");
		simpleBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);
	}
	
	//creates what chatbot will say first
	public void start()
	{
		display.displayText("Hello " + simpleBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String conversation = display.collectUserText("What would you like to talk about today?");
		while(simpleBot.lengthChecker(conversation))
		{
			if(simpleBot.contentChecker(conversation))
			{
				display.displayText("Wow, I had no idea you loved " + simpleBot.getContent());
			}
			else if(simpleBot.memeChecker(conversation))
			{
				display.displayText("OMG Y U NO memes!");
			}
			conversation = simpleBot.processConversation(conversation);
			conversation = display.collectUserText(conversation);
		}
	}
	//shuts down chatbot and leaves with a message
	private void shutDown()
	{
		display.displayText("Goodbye, " + simpleBot.getUserName() + " it has been my pleasure to talk with you");
		System.exit(0);
	}
	
	//String method
	public String userToChatbot(String conversation)
	{
		String response = "";
		
		if(simpleBot.quitChecker(conversation))
		{
			shutDown();
		}
		response = simpleBot.processConversation(conversation);
				
		return response;		
	}
	
	//getters only have one line of code: return content;
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}
