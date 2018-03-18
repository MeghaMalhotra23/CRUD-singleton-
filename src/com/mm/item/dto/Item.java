package com.mm.item.dto;

public class Item {
private int itemId;
private double price;
private String itemName;
private int quantity;

public Item(int itemId,double price,String itemName,int qty) {
	this.itemId=itemId;
	this.price=price;
	this.itemName=itemName;
	this.quantity=qty;
}

public Item() {}

@Override
public boolean equals(Object obj) {
	if(obj instanceof Item) {
	Item item=(Item) obj;
	if(this.itemId>0 || this.itemName!=null && this.itemName.trim().length()>0){
		if(this.itemId == item.itemId && this.itemName.equals(item.itemName)){
			return true;
		}
	}
	else
	if(item.itemName!=null && item.itemName.trim().length()>0){
		if(this.itemName.equals(item.itemName)){
			return true;
		}
	}
	else
	if(item.itemId>0){
	if(this.itemId == item.itemId){
		return true;
		}
}}
	return false;}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Item [itemId=" + itemId + ", price=" + price + ", itemName=" + itemName + ", quantity=" + quantity + "]";
}

}
