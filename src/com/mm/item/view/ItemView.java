package com.mm.item.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mm.item.dto.Item;
import com.mm.item.dto.ItemOperations;

public class ItemView extends JFrame {

	private JPanel contentPane;
	private JTextField itemId;
	private JTextField price;
	private JTextField qty;
	private JTextField itemName;
	private Item item;
	private JTable table;
	private static ItemView frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ItemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ItemView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item ID");
		lblNewLabel.setBounds(46, 53, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(46, 98, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(46, 140, 91, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Item Name");
		lblNewLabel_3.setBounds(46, 188, 91, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ITEM");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(159, 11, 74, 28);
		contentPane.add(lblNewLabel_4);
		
		itemId = new JTextField();
		itemId.setBounds(147, 50, 180, 20);
		contentPane.add(itemId);
		itemId.setColumns(10);
		
		price = new JTextField();
		price.setBounds(147, 95, 180, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		qty = new JTextField();
		qty.setBounds(147, 140, 180, 20);
		contentPane.add(qty);
		qty.setColumns(10);
		
		itemName = new JTextField();
		itemName.setBounds(147, 185, 180, 20);
		contentPane.add(itemName);
		itemName.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD ITEM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});
		btnNewButton.setIcon(new ImageIcon(ItemView.class.getResource("/com/mm/item/view/images.png")));
		btnNewButton.setBounds(0, 228, 117, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PRINT ITEM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(119, 228, 103, 33);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(10, 294, 542, 156);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 294, 542, 156);
		contentPane.add(scrollPane);
		
		JButton search = new JButton("SEARCH ITEM");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		search.setBounds(225, 228, 124, 33);
		contentPane.add(search);
		
		JButton btnNewButton_2 = new JButton("DELETE ITEM");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnNewButton_2.setBounds(352, 228, 100, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnUpdateItem = new JButton("UPDATE ITEM");
		btnUpdateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdateItem.setBounds(452, 228, 106, 33);
		contentPane.add(btnUpdateItem);
	}
	public Item getData() {
		if(itemId==null) {
			JOptionPane.showMessageDialog(this, "enter item id");
		}
		else if(price==null) {
			JOptionPane.showMessageDialog(this, "enter price");
		}
		else if(qty==null) {
			JOptionPane.showMessageDialog(this, "enter quantity");
		}
		else {
		item= new Item(Integer.parseInt(itemId.getText()),Integer.parseInt(price.getText()),itemName.getText(),Integer.parseInt(qty.getText()));
		}return item;
	}
	
	public void addItem() {
		JOptionPane.showMessageDialog(this,ItemOperations.getInstance().addItem(getData()));
		table.setModel(new MyTableModel());
		//JOptionPane.showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue)
		
	}
	
	public void search() {
		JOptionPane.showMessageDialog(this, ItemOperations.getInstance().searchItem(getData()));
	}
	
	public void delete() {
		JOptionPane.showMessageDialog(this,ItemOperations.getInstance().deleteItem(getData()));
		table.setModel(new MyTableModel());
		
	}
	public void update() {
		Item updatedItem;
		JFrame frame=new JFrame();
		String newid=JOptionPane.showInputDialog(frame, "enter new id");
		if(newid!=null){
			updatedItem=new Item();
			updatedItem.setItemId(Integer.parseInt(newid));
			updatedItem.setItemName(itemName.getText());
			updatedItem.setPrice(Integer.parseInt(price.getText()));
			updatedItem.setQuantity(Integer.parseInt(qty.getText()));
			ItemOperations.getInstance().updateItem(getData(),updatedItem);
		}
		table.setModel(new MyTableModel());
	}
}
