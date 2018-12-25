package dataAccess;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DataOutput {

	private PrintWriter pt;
	private FileOutputStream fs;
	
	public DataOutput(String fileName) throws FileNotFoundException {
		setFs(new FileOutputStream(fileName));
		setPt(new PrintWriter(getFs()));
	}
	
	public void saveFile(String input) {
		getPt().println(input);
		getPt().close();
	}
	
	public void setPt(PrintWriter pt) {
		this.pt = pt;
	}
	
	public PrintWriter getPt() {
		return this.pt;
	}
	
	public FileOutputStream getFs() {
		return fs;
	}

	public void setFs(FileOutputStream fs) {
		this.fs = fs;
	}
}
