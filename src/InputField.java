import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;

public class InputField extends JTextField {

	private static FileReader fr = null;
	private static FileWriter fw = null;
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	
	String name = "";

	 /*public static String readMessage() throws IOException {
		String s = null; // 로그에 있는 것들을 한줄씩 읽어 온것.
		String str = null; // 로그에서 읽어온 s들을 이어 붙여줌
		fr = new FileReader("log.txt");
		br = new BufferedReader(fr);
		while ((s = br.readLine()) != null) {
			str += s + '\n';
			
			
		}
		return str;
	}
*/
	
	public void sendMessage() throws IOException { // 인풋을 받아서 로그파일에 써줌

		try {
			String str = this.getText();
			fw = new FileWriter("log.txt", true);
			bw = new BufferedWriter(fw);
			bw.write(name+":"+str);
			bw.newLine();
			bw.close();
			this.setText("");
			System.out.println("고장");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block+
			e.printStackTrace();
		} finally {

			// BufferedReader FileReader를 닫아준다.
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
				}

			// BufferedWriter FileWriter를 닫아준다.
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
				}
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
				}

		}
	}

	InputField(String name) throws IOException {

		fw = new FileWriter("log.txt", true);
		bw = new BufferedWriter(fw);
		bw.close();
		this.name = name;

	}

}
