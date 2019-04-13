import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

public class MyActionListener implements ActionListener{
	private InputField input;
	private MessagesField message;
	
	public MyActionListener(InputField input, MessagesField message){
		this.input = input;
		this.message = message;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			input.sendMessage();
			//message.readMessage();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
