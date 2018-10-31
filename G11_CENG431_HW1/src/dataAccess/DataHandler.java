package dataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import com.google.gson.*;


import domain.Project;
import domain.Consultant;
import domain.Employee;
import domain.IResource;
import domain.Person;

public class DataHandler {
	private Gson gson;
	
	public DataHandler() {
			setGson(new Gson());
	}
			
	public JsonElement saveProjects(List<Project> projectList) {
		return getGson().toJsonTree(projectList);	
	}
	
	public List<Project> loadProjects(JsonElement projects) {
		Type listType = new TypeToken<ArrayList<Project>>(){}.getType();
		return getGson().fromJson(projects, listType);
	}
	
	public JsonElement saveResources(List<IResource> resourceList) {
		return getGson().toJsonTree(resourceList);
	}
		
	public List<IResource> loadResources(JsonElement resources) {
		List<IResource> resourceList = new ArrayList<IResource>();

		JsonElement jsonTree = resources;
		
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
			PrintWriter pw = new PrintWriter("dataHistory//" +fileName);
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
			bfrd = new BufferedReader(new FileReader("dataHistory//" + fileName));
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
	
	public void splitJson(BufferedReader bfrd, List<Project> projectList, List<IResource> resourceList) {
		JsonParser jsonParse = new JsonParser();
		JsonElement jsonTree = jsonParse.parse(bfrd);
		
		if(jsonTree.isJsonObject()) {
			JsonObject jsonObject = jsonTree.getAsJsonObject();
			
		System.out.println(loadProjects(jsonObject.get("projectList")));
			loadResources(jsonObject.get("resourceList"));
			
		}
		
	}
	
	public String findLatestFile() {
		 /*
		  * Code taken from and modified for our purposes
		  * https://stackoverflow.com/questions/285955/java-get-the-newest-file-in-a-directory
		  * 
		  */
		
		 File fl = new File("dataHistory//");
		    File[] files = fl.listFiles(new FileFilter() {          
		        public boolean accept(File file) {
		            return file.isFile();
		        }
		    });
		    long lastMod = Long.MIN_VALUE;
		    File choice = null;
		    for (File file : files) {
		        if (file.lastModified() > lastMod) {
		            choice = file;
		            lastMod = file.lastModified();
		        }
		    }
		    
		    return choice.getName();
	}
}
