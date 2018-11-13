package dataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import domain.*;

import domain.*;

public class DataHandler {
	
	public DataHandler() {
		
	}
	
	public Customer signInCustomer(String email, String password) {
		//read from customer.json
		try {
			ArrayList<CustomerWrapper> cstw = getCustomerWraperList(readFile("customers.json"));
			
			for(int i = 0; i < cstw.size(); i++) {
				if(cstw.get(i).getEmail().equals(email) && cstw.get(i).getPassword().equals(password)) {
					CustomerWrapper tmp = cstw.get(i);
					Customer customer = new Customer();
					customer.setId(tmp.getId());
					customer.setName(tmp.getName());
					customer.setAddress(tmp.getAddress());
					customer.setSavings(tmp.getSavings());
					customer.setPhone(tmp.getPhone());
					customer.setEmail(tmp.getEmail());
					customer.setPassword(tmp.getPassword());
					return customer;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Customer signUpCustomer(Customer customer){
		//write to the customer.json
		try {
			ArrayList<CustomerWrapper> cstw = getCustomerWraperList(readFile("customers.json"));
			cstw.add(new CustomerWrapper(customer.getId(), customer.getName(), customer.getAddress(), customer.getSavings(), customer.getPhone(), customer.getEmail(), customer.getPassword()));
			
			writeFile("customers.json",jsonCustomerWraperList(cstw));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	public ArrayList<CustomerWrapper>  getCustomerWraperList(BufferedReader bfrd) {
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<CustomerWrapper>>(){}.getType();
	    return gson.fromJson(bfrd, listType);
	}
	
	public String jsonCustomerWraperList(ArrayList<CustomerWrapper> cstw) {
		 Gson gson = new Gson();
		 Type listType = new TypeToken<ArrayList<CustomerWrapper>>(){}.getType();
		 return gson.toJson(cstw, listType);
	}
	
	public ArrayList<OrderWrapper> getOrderWraperList(BufferedReader bfrd) {
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<OrderWrapper>>(){}.getType();
	    return gson.fromJson(bfrd, listType);	
	}
	
	public String jsonOrderWrapperList(ArrayList<OrderWrapper> orderWraperList) {
		 Gson gson = new Gson();
		 Type listType = new TypeToken<ArrayList<OrderWrapper>>(){}.getType();
		 return gson.toJson(orderWraperList, listType);
	}
	
	public void saveOrderList(List<Order> orderList) throws IOException {
		ArrayList<OrderWrapper> orderWrapperList = getOrderWraperList(readFile("orders.json"));
		for(int i = 0; i < orderList.size(); i++) {
			if(i >= orderWrapperList.size()) {
				Order tmp = orderList.get(i);
				orderWrapperList.add(new OrderWrapper(tmp.getId(), tmp.getTrackingNumber(), tmp.getCustomerId(), tmp.getCustomerName(), tmp.getWeight(), tmp.getShippingAddress(), tmp.getDateShipped(), tmp.getDateDelivered(), tmp.getProductPrice(), tmp.getCargoPrice(), tmp.getTotalPrice()));
			}
		}
	
		writeFile("orders.json", jsonOrderWrapperList(orderWrapperList));
	
	}
	
	public List<Order> loadOrderList() throws IOException {
		List<Order> orderList = new ArrayList<Order>();
		List<OrderWrapper> orderWrapperList = getOrderWraperList(readFile("orders.json"));
		for(int i = 0; i < orderWrapperList.size(); i++) {
			Order order = new Order();
			OrderWrapper tmp = orderWrapperList.get(i);
			order.setId(tmp.getId());
			order.setTrackingNumber(tmp.getTrackingNumber());
			order.setCustomerId(tmp.getCustomerId());
			order.setCustomerName(tmp.getCustomerName());
			order.setWeight(tmp.getWeight());
			order.setShippingAddress(tmp.getShippingAddress());
			order.setDateShipped(tmp.getDateShipped());
			order.setDateDelivered(tmp.getDateDelivered());
			order.setProductPrice(tmp.getProductPrice());
			order.setCargoPrice(tmp.getCargoPrice());
			order.setTotalPrice(tmp.getTotalPrice());
			
			orderList.add(order);
		}
		return orderList;
	}
	
	public BufferedReader readFile(String fileName) throws IOException {
		BufferedReader bfrd = null;
		try {
			bfrd = new BufferedReader(new FileReader("data//" + fileName));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return bfrd;
	}
	
	public void writeFile(String fileName, String data) throws IOException {
		try {
			PrintWriter pw = new PrintWriter("data//" +fileName);
			pw.write(data); 
	          
	        pw.flush(); 
	        pw.close(); 
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
	}

}
