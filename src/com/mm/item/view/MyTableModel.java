package com.mm.item.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mm.item.dto.Item;
import com.mm.item.dto.ItemOperations;

public class MyTableModel extends AbstractTableModel {
	String col[]= {"id","price","item Name","quantity"};
	ItemOperations itemOperations;
	ArrayList<Item> item;
	public MyTableModel() {
		item=ItemOperations.getInstance().getList();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return item.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Item item= this.item.get(row);
		switch(column) {
		case 0:
			return item.getItemId();
			
		case 1:
			return item.getPrice();
			
		case 2:
			return item.getItemName();
			
		case 3:
			return item.getQuantity();
		default:
			return null;
		}
		
	}
	
	@Override
	public String getColumnName(int col) {
	return this.col[col];}
	}

