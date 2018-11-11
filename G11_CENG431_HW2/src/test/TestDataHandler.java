package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import dataAccess.*;

public class TestDataHandler {

	public static void main(String[] args) throws IOException {
		
/*
		 Type listType = new TypeToken<ArrayList<CustomerWrapper>>(){}.getType();
		 Gson gson = new Gson();
		 BufferedReader a =  dataHandler.readFile("customers.json");
		 ArrayList<CustomerWrapper> k = gson.fromJson(a, listType);
		 System.out.println(k.size());
	*/
		 
		/*
		 Gson gson = new Gson();
		 ArrayList<CustomerWrapper> cst = new ArrayList<CustomerWrapper>();
		 Type listType = new TypeToken<ArrayList<CustomerWrapper>>(){}.getType();
		 String l =gson.toJson(cst, listType);
		 dataHandler.writeFile("customers.json", l);
		
		*/
		 
		
		 
	//	DataHandler data = new DataHandler();
	//	data.signUpCustomer("emre");
	}

}
