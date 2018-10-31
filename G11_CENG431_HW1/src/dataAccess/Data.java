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
	private Gson gson;
	
	public Data() {
			setGson(new Gson());
	}
			
	public String saveProjects(List<Project> projectList) {
		return getGson().toJson(projectList);	
	}
	
	public List<Project> loadProjects(BufferedReader bfrd) {
		Type listType = new TypeToken<ArrayList<Project>>(){}.getType();
		return getGson().fromJson(bfrd, listType);
	}
	
	public String saveResources(List<IResource> resourceList) {
		return getGson().toJson(resourceList);
	}
	
	public List<IResource> loadResources(BufferedReader bfrd) {
		
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

	public BufferedReader readFile(String fileName) {
		BufferedReader bfrd = null;
		try {
			bfrd = new BufferedReader(new FileReader("JSONExample.json"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return bfrd;
	}
	public void setGson(Gson gson) {
		this.gson = gson;
	}
	
	public Gson getGson() {
		return this.gson;
	}
}
