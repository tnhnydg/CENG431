package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import dataAccess.*;
import domain.Order;

public class TestDataHandler {

	public static void main(String[] args) throws IOException {
		
		List<Order> orderList = new ArrayList<Order>();
		Order order = new Order();
		orderList.add(order);		
		order.setCargoPrice(20);
	
		DataHandler dataHandler = new DataHandler();
		dataHandler.saveOrderList(orderList);
		
		List<Order> orderList2 = dataHandler.loadOrderList();
		double price = orderList2.get(5).getCargoPrice();
		System.out.println(price);
		System.out.println(orderList2.size());
		
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
