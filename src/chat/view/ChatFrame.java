package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame (ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
		
	}
	//size of the frame and visibility
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400,400);
		this.setVisible(true);
		this.setTitle("Cassandra's Chatbot");
	}
	//getters only have one line of code: return content;
	public ChatController getBaseController()
	{
		return baseController;
	}
	

}