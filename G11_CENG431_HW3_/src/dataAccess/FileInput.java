package dataAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {

	private BufferedReader br;
	private FileReader fr;
	
	public FileInput(String fileName) throws FileNotFoundException {
		setFr(new FileReader(fileName));
		setBr(new BufferedReader(getFr()));
	}
	
	public String getText() throws IOException {
		StringBuilder sb = new StringBuilder();
		String text = "";
		
		while ((text = getBr().readLine()) != null) {
		    sb.append(text);
		    sb.append("\n");
		}

		String btext = sb.toString();
		
		return btext;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public FileReader getFr() {
		return fr;
	}

	public void setFr(FileReader fr) {
		this.fr = fr;
	}
}
