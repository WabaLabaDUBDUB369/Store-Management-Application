package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Attributes.*;

public class ManageProduct extends JFrame implements ActionListener {
	private JPanel panel;
	ViewProductActivity prev;
	private Product product;
	private JButton BackButton, EditButton, DeleteButton, SellButton, SubmitButton;
	private JLabel title, header, productIdLabel, productNameLabel, productQtLabel, productPriceLabel, userIdLabel;
	private JTextField productId, productName, productQt, productPrice, userId;
	
	public ManageProduct(String pid, ViewProductActivity prev) {
		super("Manage Product");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		product = new Product(pid);
		product.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		productIdLabel = new JLabel("Product ID: "+product.getProductId());
		productIdLabel.setBounds(60, 20, 140, 30);
		productIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(productIdLabel);
		
		productNameLabel = new JLabel("Name: ");
		productNameLabel.setBounds(60, 60, 140, 30);
		productNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(productNameLabel);
		
		productPriceLabel = new JLabel("Price: ");
		productPriceLabel.setBounds(60, 100, 140, 30);
		productPriceLabel.setVisible(false);
		productPriceLabel.setFont(Theme.FONT_INPUT);
		panel.add(productPriceLabel);
		
		userIdLabel = new JLabel("CustomerID: ");
		userIdLabel.setBounds(60, 100, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		productQtLabel = new JLabel("Quantity: ");
		productQtLabel.setBounds(60, 140, 140, 30);
		productQtLabel.setFont(Theme.FONT_INPUT);
		panel.add(productQtLabel);
		
		productName = new JTextField(product.getProductName());
		productName.setBounds(180, 60, 220, 30);
		productName.setEnabled(false);
		productName.setFont(Theme.FONT_PRODUCT);
		panel.add(productName);
		
		userId = new JTextField("");
		userId.setBounds(180, 100, 220, 30);
		userId.setFont(Theme.FONT_INPUT);
		userId.setBackground(Color.decode("#E0E0E0"));
		panel.add(userId);
		
		productPrice = new JTextField(product.getPrice()+"");
		productPrice.setBounds(180, 100, 220, 30);
		productPrice.setFont(Theme.FONT_INPUT);
		productPrice.setVisible(false);
		panel.add(productPrice);
		
		productQt = new JTextField("");
		productQt.setBounds(180, 140, 220, 30);
		productQt.setFont(Theme.FONT_INPUT);
		productQt.setBackground(Color.decode("#E0E0E0"));
		panel.add(productQt);
		
		EditButton = new JButton("Edit");
		EditButton.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		EditButton.setFont(Theme.FONT_BUTTON);
		EditButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		EditButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		EditButton.setFocusable(false);
		EditButton.addActionListener(this);
		panel.add(EditButton);
		
		SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		SubmitButton.setFont(Theme.FONT_BUTTON);
		SubmitButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		SubmitButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		SubmitButton.setVisible(false);
		SubmitButton.setFocusable(false);
		SubmitButton.addActionListener(this);
		panel.add(SubmitButton);
		
		DeleteButton = new JButton("Delete");
		DeleteButton.setBounds(300, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		DeleteButton.setFont(Theme.FONT_BUTTON);
		DeleteButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		DeleteButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		DeleteButton.setFocusable(false);
		DeleteButton.addActionListener(this);
		panel.add(DeleteButton);
		
		SellButton = new JButton("Sell");
		SellButton.setBounds(60, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		SellButton.setFont(Theme.FONT_BUTTON);
		SellButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		SellButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		SellButton.setFocusable(false);
		SellButton.addActionListener(this);
		panel.add(SellButton);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(SellButton)) {
			try {
				product.sellProduct(userId.getText().trim(),Integer.parseInt(productQt.getText()));
				if (!prev.keyword.getText().trim().isEmpty())
					prev.table.setModel(Product.searchProduct(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Product.searchProduct("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(EditButton)) {
			EditButton.setVisible(false);
			SubmitButton.setVisible(true);
			SellButton.setEnabled(false);
			productQt.setText(product.getQuantity()+"");
			productName.setEnabled(true);
			userIdLabel.setVisible(false);
			userId.setVisible(false);
			productPriceLabel.setVisible(true);
			productPrice.setVisible(true);
		}
		else if (ae.getSource().equals(SubmitButton)) {
			try {
				product.updateProduct(productName.getText(),Double.parseDouble(productPrice.getText()),Integer.parseInt(productQt.getText()));
				if (!prev.keyword.getText().trim().isEmpty())
					prev.table.setModel(Product.searchProduct(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Product.searchProduct("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(DeleteButton)) {
			product.deleteProduct();
			if (!prev.keyword.getText().trim().isEmpty())
				prev.table.setModel(Product.searchProduct(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Product.searchProduct("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}