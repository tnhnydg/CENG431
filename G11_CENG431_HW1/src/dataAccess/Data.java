package dataAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import com.google.gson.*;


import domain.Project;

import domain.IResource;

public class Data {

	
	public Data() {
			
	}
			
	public String saveProjects(List<Project> projectList) {
		Gson gson = new Gson();
		return gson.toJson(projectList);	
	}
	
	public String saveResources(List<IResource> resourceList) {
		
		return null;
	}
	
	public void writeFile(String fileName, String data) {
		try {
			PrintWriter pw = new PrintWriter("JSONExample.json");
			pw.write(data); 
	          
	        pw.flush(); 
	        pw.close(); 
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
	}
	public List<Project> loadProjects(BufferedReader bfrd) {
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Project>>(){}.getType();
		return gson.fromJson(bfrd, listType);
	}
	
	public BufferedReader readFile(String fileName) {
		try {
			return new BufferedReader(new FileReader("JSONExample.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
