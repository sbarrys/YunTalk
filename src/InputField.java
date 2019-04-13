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
		String s = null; // �α׿� �ִ� �͵��� ���پ� �о� �°�.
		String str = null; // �α׿��� �о�� s���� �̾� �ٿ���
		fr = new FileReader("log.txt");
		br = new BufferedReader(fr);
		while ((s = br.readLine()) != null) {
			str += s + '\n';
			
			
		}
		return str;
	}
*/
	
	public void sendMessage() throws IOException { // ��ǲ�� �޾Ƽ� �α����Ͽ� ����

		try {
			String str = this.getText();
			fw = new FileWriter("log.txt", true);
			bw = new BufferedWriter(fw);
			bw.write(name+":"+str);
			bw.newLine();
			bw.close();
			this.setText("");
			System.out.println("����");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block+
			e.printStackTrace();
		} finally {

			// BufferedReader FileReader�� �ݾ��ش�.
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

			// BufferedWriter FileWriter�� �ݾ��ش�.
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
