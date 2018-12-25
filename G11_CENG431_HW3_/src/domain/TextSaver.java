package domain;

import java.io.FileNotFoundException;

import dataAccess.DataOutput;
import presentation.DataInput;

public class TextSaver implements Component {
	
	public TextSaver() {
		
	}
	
	public void saveText(String fileName) throws FileNotFoundException {
		DataInput dInput = new DataInput();
		DataOutput dOutput = new DataOutput(fileName);
		String message = "Please enter the text : ";
		String input = dInput.takeInput(message);
		dOutput.saveFile(input);
		
	}
}
