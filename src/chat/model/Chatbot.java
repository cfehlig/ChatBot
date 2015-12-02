package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Cassandra Fehlig
 * @version 1.2 11/4/15
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Soccer";

		buildMemesList();
		buildPoliticalTopicsList();
	}

	private void buildMemesList()
	{
		memesList.add("cute animals");
		memesList.add("doge");

	}

	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("Donald Trump");
		politicalTopicList.add("President");
		politicalTopicList.add("Hillary Clinton");

	}

	public String processConversation(String currentInput)
	{
		String nextConversation = "oh, what else would you like to talk about?";
		int randomTopic = (int) (Math.random() * 5);
		
		if(keyboardMashChecker(currentInput))
		{
			return "Stop mashing the keyboard!!!!!";
		}
			
		switch (randomTopic)
		{
			case 0:
				if(contentChecker(currentInput))
				{
					nextConversation = "hey you should talk about my special topic, " + "Wow! What is your favorite food?";	
				}
				break;
			case 1:
				if(memeChecker(currentInput))
				{
					nextConversation = "That is a popular meme this year! " + "Wow! What is your favorite food?";
				}
				
				break;
			case 2:
				if(politicalTopicChecker(currentInput))
				{
					nextConversation = "comment and a question";
				}
				
				break;
			case 3:
				if(currentInput.length() > 10)
				{
					nextConversation = "comment and a question";
				}
				break;
			case 4:
				nextConversation = "Do you like ice cream?";
				break;
			default:
				nextConversation = "How did we get here!";
				break;
		}
		
		return nextConversation;
		
	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}

		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		if (currentInput.contains(content))
		{
			hasContent = true;
		}

		return hasContent;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitical = false;

		int i;

		if (currentInput == null)
			return false;

		for (i = 0; i < politicalTopicList.size(); i++)
		{
			String temp = politicalTopicList.get(i);
			if (temp.equalsIgnoreCase(currentInput))
				hasPolitical = true;
		}

		return hasPolitical;
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasmeme = false;

		int i;

		if (currentInput == null)
			return false;

		for (i = 0; i < memesList.size(); i++)
		{
			String temp = memesList.get(i);
			if (currentInput.contains(temp))
				hasmeme = true;
		}

		return hasmeme;
	}

	public boolean keyboardMashChecker(String content)
	{
		if (content == null)
			return false;
		if (content.equalsIgnoreCase("sdf"))
			return true;
		if (content.equalsIgnoreCase("dfg"))
			return true;
		if (content.equalsIgnoreCase("cvb"))
			return true;
		return false;
	}

	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	public boolean quitChecker(String content)
	{
		if (content == null)
			return false;

		if (content.equalsIgnoreCase("quit"))
			return true;
		else
			return false;
	}

}
