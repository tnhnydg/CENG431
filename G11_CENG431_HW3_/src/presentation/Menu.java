package presentation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import domain.Component;
import domain.Composite;
import domain.Counter;
import domain.Searcher;
import domain.TextSaver;

public class Menu {
	
	private DataInput dInput;
	
	public Menu() {
		dInput = new DataInput();
	}
	
	public void start() throws IOException {
		
		String input;
		while(true) {
			System.out.println("\n---------------Text Editing Application---------------");
			System.out.println("1-Create text file");
			System.out.println("2-Display count info");
			System.out.println("3-Search&list with token");
			System.out.println("4-Exit");
			input = dInput.takeInput("Please select an option : ");
			if(input.equals("1")) {
				firstOpt();
			}
			else if (input.equals("2")) {
				input = dInput.takeInput("1-File | 2-Console");
				if(input.equals("1")) {
					secondOpt_file();
				}
				else if (input.equals("2")) {
					secondOpt_console();
				}
			}
			else if (input.equals("3")) {
				input = dInput.takeInput("1-File | 2-Console");
				if(input.equals("1")) {
					thirdOpt_file();
				}
				else if (input.equals("2")) {
					thirdOpt_console();
				}
			}
			else if (input.equals("4")) {
					break;
			}
		
		}
	}
	
	public void firstOpt() throws FileNotFoundException {
		TextSaver ts = new TextSaver();
		String fileName = dInput.takeInput("Enter the filename : ");
		ts.saveText(fileName);
	}
	
	public void secondOpt_file() throws IOException {
		Counter c = new Counter();
		String fileName = dInput.takeInput("Enter the filename : ");
		System.out.println("Paragraph : " + c.countParagraph(fileName));
		System.out.println("Line : " + c.countLine(fileName));
		System.out.println("Word : " + c.countWord(fileName));
		System.out.println("Character : " + c.countCharacter(fileName));
	}
	
	public void secondOpt_console() throws IOException {
		Composite c = new Composite();
		ArrayList<Component> cList = new ArrayList<>();
		TextSaver ts = new TextSaver();
		Counter cn = new Counter();
		cList.add(ts);
		cList.add(cn);
		c.setComponentList(cList);
		String fileName = "temp";
		ts.saveText(fileName);
		System.out.println("Paragraph : " + cn.countParagraph(fileName));
		System.out.println("Line : " + cn.countLine(fileName));
		System.out.println("Word : " + cn.countWord(fileName));
		System.out.println("Character : " + cn.countCharacter(fileName));
	}
	
	public void thirdOpt_file() throws IOException {
		Composite c = new Composite();
		ArrayList<Component> cList = new ArrayList<>();
		Counter cn = new Counter();
		Searcher s = new Searcher();
		cList.add(cn);
		cList.add(s);
		c.setComponentList(cList);
		String fileName = dInput.takeInput("Enter the filename : ");
		String token = dInput.takeInput("Enter the token : ");
		ArrayList<String> rList = s.searchAndList(fileName, token);
		for(String rs : rList) {
			System.out.println(rs);
		}
		System.out.println("Count : " + rList.size());
		
	}
	
	public void thirdOpt_console() throws IOException {
		Composite c = new Composite();
		ArrayList<Component> cList = new ArrayList<>();
		TextSaver ts = new TextSaver();
		Counter cn = new Counter();
		Searcher s = new Searcher();
		cList.add(ts);
		cList.add(cn);
		cList.add(s);
		c.setComponentList(cList);
		String fileName = "temp";
		ts.saveText(fileName);
		String token = dInput.takeInput("Enter the token : ");
		ArrayList<String> rList = s.searchAndList(fileName, token);
		for(String rs : rList) {
			System.out.println(rs);
		}
		System.out.println("Count : " + rList.size());
	}

}
