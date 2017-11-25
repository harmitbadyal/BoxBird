import javax.swing.JOptionPane;

import javax.swing.JPanel;

public class GameRunner extends JPanel{

public static void main(String[]args)
	{
		Object[]options = {"Close","Start"};
		JOptionPane startMessage = new JOptionPane();
		startMessage.setOptions(options);
		int answer = startMessage.showOptionDialog(null, "Do you want to start", "Start", startMessage.YES_NO_CANCEL_OPTION,startMessage.QUESTION_MESSAGE,null, options,options[1]);
		if(answer == 1)
		{
			FlappyBird game1 = new FlappyBird();
		}
	}

}
