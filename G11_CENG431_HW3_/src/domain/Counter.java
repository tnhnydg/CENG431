package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dataAccess.FileInput;

public class Counter implements Component {

	public Counter() {
		
	}
	
	public int countParagraph(String fileName) throws IOException {
		FileInput fi = new FileInput(fileName);
		String text = fi.getText();
		String[] lines = text.split("\r\t|\r|\t");
		return lines.length-1;
	}
	
	public int countLine(String fileName) throws IOException {
		FileInput fi = new FileInput(fileName);
		String text = fi.getText();
		String[] lines = text.split("\r\n|\r|\n");
		return lines.length;
	}

	public int countWord(String fileName) throws IOException {
		FileInput fi = new FileInput(fileName);
		String text = fi.getText();
		String[] lines = text.split(" |\n|\t");
		List<String> alines = new ArrayList<>(Arrays.asList(lines));
		int count=0;
		for(int i = 0;i<alines.size();i++) {
			if(alines.get(i).length() != 0) {
				count++;
			}
		}
		return count;
	}
	
	public int countCharacter(String fileName) throws IOException {
		FileInput fi = new FileInput(fileName);
		String text = fi.getText();
		char[] charArray = text.toCharArray();
		int count=0;
		for(int i = 0;i<charArray.length;i++) {
			boolean b1 = Character.isLetter(charArray[i]);
			if(b1) {
				count++;
			}
		}
		return count;
	}
}
