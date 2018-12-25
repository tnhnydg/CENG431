package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dataAccess.FileInput;

public class Searcher implements Component {
	
	public Searcher() {
		
	}
	
	public ArrayList<String> searchAndList(String fileName,String token) throws IOException {
		FileInput fi = new FileInput(fileName);
		String text = fi.getText();
		String[] lines = text.split(" |\n|\t");
		List<String> alines = new ArrayList<>(Arrays.asList(lines));
		List<String> words = new ArrayList<>();
		ArrayList<String> resultList = new ArrayList<>();
		for(int i = 0;i<alines.size();i++) {
			if(alines.get(i).length() != 0) {
				words.add(alines.get(i));
			}
		}
		for(int i=0;i<words.size();i++) {
			if(words.get(i).contains(token)) {
				resultList.add(words.get(i));
			}
		}
		
		return resultList;
	}

}
