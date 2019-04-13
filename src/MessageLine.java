import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

// 메세지 각각을 담는 패널 



public class MessageLine extends JLabel{

	MessageLine(String name, String line){
		int index = line.indexOf(":");
		String person=line.substring(0, index);
		line = line.substring(index+1);
		this.setOpaque(true);
		if(name.equals(person)){
			this.setBackground(Color.YELLOW);
		}	
		else {
			this.setBackground(Color.GRAY);
		}
		this.setText(line);
	}
}
