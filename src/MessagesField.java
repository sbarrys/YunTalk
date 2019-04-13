import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class MessagesField extends JPanel implements Runnable {

	
	
	private static FileReader fr = null;
	private static BufferedReader br = null;
	String name = "";
	GridBagConstraints gbc = new GridBagConstraints();
	
	public String readMessage() throws IOException {
		String s = null; // 로그에 있는 것들을 한줄씩 읽어 온것.
		String str = null; // 로그에서 읽어온 s들을 이어 붙여줌
		fr = new FileReader("log.txt");
		br = new BufferedReader(fr);

		
		while ((s = br.readLine()) != null) {
			add(new MessageLine(this.name, s), gbc);
		}
		return s;
	}

	MessagesField(String name) {
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setLayout(new GridBagLayout());
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.name = name;
	}

	public String readLastLine() throws IOException {
		
		String s = null; // 로그에 있는 것들을 한줄씩 읽어 온것.
		String str = null; // 로그에서 읽어온 s들을 이어 붙여줌
		fr = new FileReader("log.txt");
		br = new BufferedReader(fr);
		String last = null;
		
		while ((s = br.readLine()) != null) {
			 last =s;
		}


		
		return last;
		
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String lastline = this.readMessage();
			while (true) {
				// MessageLine 을 추가해줌
				String lastline2 = this.readLastLine();
				if ( lastline!=null &&!lastline.equals(lastline2)) {
					add(new MessageLine(this.name, lastline2), gbc);
				
				}
				this.revalidate();
				ChatFrame parent = (ChatFrame) SwingUtilities.getAncestorOfClass(ChatFrame.class ,this);
				parent.setBarBottom();
				
				lastline = lastline2;

				Thread.sleep(100);

			}
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
