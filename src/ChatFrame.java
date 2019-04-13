import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ChatFrame extends JFrame {	
	
	InputField ip=null;
	JScrollBar vertical =null;
	
	public JScrollBar setBarBottom() {
		if(vertical == null) {
			return null;
		}
		vertical.setValue( vertical.getMaximum() );
		return vertical;
	}
	
	
	
	public ChatFrame(String name) throws IOException {
		
		
		
		
		this.setLayout(new GridLayout(3,1));
		
		ip=new InputField(name);
		
		MessagesField mf = new MessagesField(name);
		JScrollPane scrollPane = new JScrollPane(mf, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		vertical = scrollPane.getVerticalScrollBar();
		System.out.println(name+" : yes scrollbar");

		vertical.setValue( vertical.getMaximum() );


		
		SendButton sb = new SendButton();
		
		MyActionListener ma = new MyActionListener(ip,mf);
		sb.addActionListener(ma);
		Thread th = new Thread(mf);
		th.start();
		
		this.add(ip);
		this.add(scrollPane);
	    this.add(sb);
		this.setSize(new Dimension(400,800));

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	
}
