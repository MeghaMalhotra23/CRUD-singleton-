package com.mm.item.dto;

import java.util.ArrayList;

public class ItemOperations {
	private  ArrayList<Item> list=new ArrayList<>();
	private static ItemOperations itemOperations;
	private int index;
private ItemOperations() {}
public static ItemOperations getInstance() {
	synchronized(ItemOperations.class) {
	if(itemOperations==null) {
		itemOperations= new ItemOperations();
	}
	}
	return itemOperations;
}
public String addItem(Item item) {
	this.list.add(item);
	return "item Added";
}

public ArrayList<Item> getList(){
	return list;
}

public String deleteItem(Item item) {
	int index=list.indexOf(item);
	String result="Not Found";
	if(index>=0) {
		result="Item deleted..";
		list.remove(index);
	}
	return result;
		
}

public String searchItem(Item item) {
	String result="Not Found";
	
	if(list.indexOf(item)>=0) {
		index=list.indexOf(item);
		result="Found";
	}
return result;
}
public String updateItem(Item olditem,Item newitem) {
	String result="Not Found";
int index=list.indexOf(olditem);
if(index>=0) {
	list.set(index, newitem);
	result="updated..";
}
return result;}
}
