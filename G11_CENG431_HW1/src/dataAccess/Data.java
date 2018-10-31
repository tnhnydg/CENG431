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
import domain.Consultant;
import domain.Employee;
import domain.IResource;
import domain.Person;

public class Data {
	private Gson gson;
	
	public Data() {
			setGson(new Gson());
	}
			
	public JsonElement saveProjects(List<Project> projectList) {
		return getGson().toJsonTree(projectList);	
	}
	
	public List<Project> loadProjects(BufferedReader bfrd) {
		Type listType = new TypeToken<ArrayList<Project>>(){}.getType();
		return getGson().fromJson(bfrd, listType);
	}
	
	public JsonElement saveResources(List<IResource> resourceList) {
		return getGson().toJsonTree(resourceList);
	}
		
	public List<IResource> loadResources(BufferedReader bfrd) {
		List<IResource> resourceList = new ArrayList<IResource>();
		
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonTree = jsonParser.parse(bfrd);
		
		if(jsonTree.isJsonArray()) {
			JsonArray jsonArray = jsonTree.getAsJsonArray();
			for(int i = 0; i < jsonArray.size(); i++) {
				JsonObject tmp = jsonArray.get(i).getAsJsonObject();
				if(Integer.parseInt(tmp.get("id").toString()) == 5) {
					//create consultant
					resourceList.add(getGson().fromJson(tmp, Consultant.class));
				}
				else if(Integer.parseInt(tmp.get("id").toString()) == 10) {
					//create employee
					resourceList.add(getGson().fromJson(tmp, Employee.class));
				}
			}
		}
		System.out.println(resourceList);
		return resourceList;
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
	
	public String mergeJson(List<Project> projectList, List<IResource> resourceList) {
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.add("projectList", saveProjects(projectList));
		jsonObject.add("resourceList", saveResources(resourceList));
	
		System.out.println(jsonObject);
	
		return jsonObject.toString();
	}
}
