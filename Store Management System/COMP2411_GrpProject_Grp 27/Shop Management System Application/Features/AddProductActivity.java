package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributes.*;

public class AddProductActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private ViewProductActivity activity;
	private Employee employee;
	private JButton LogoutButton, BackButton, AddButton;
	private JLabel title, header, productNameLabel, productQtLabel, productPriceLabel;
	private JTextField productName, productQt, productPrice;
	
	public AddProductActivity(ViewProductActivity prev, Employee employee) {
		super("Add Product");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee = employee;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Add Product");
		title.setBounds(30, 40, 280,75);
		title.setOpaque(true);
		title.setBackground(Color.decode("#CCFFFF"));
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		LogoutButton = new JButton("Logout");
		LogoutButton.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		LogoutButton.setFont(Theme.FONT_BUTTON);
		LogoutButton.setBackground(Color.decode("#CCFFFF"));
		LogoutButton.setForeground(Theme.COLOR_TITLE);
		LogoutButton.setFocusable(false);
		LogoutButton.addActionListener(this);
		panel.add(LogoutButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		BackButton.setFont(Theme.FONT_BUTTON);
		BackButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		BackButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		BackButton.setFocusable(false);
		BackButton.addActionListener(this);
		panel.add(BackButton);
		
		productNameLabel = new JLabel("Name: ");
		productNameLabel.setBounds(60, 190, 140, 30);
		productNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productNameLabel);
		
		productPriceLabel = new JLabel("Price: ");
		productPriceLabel.setBounds(60, 240, 140, 30);
		productPriceLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productPriceLabel);
		
		productQtLabel = new JLabel("Quantity: ");
		productQtLabel.setBounds(60, 290, 140, 30);
		productQtLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productQtLabel);
		
		productName = new JTextField();
		productName.setBounds(180, 190, 220, 30);
		productName.setFont(Theme.FONT_INPUT);
		productName.setBackground(Color.decode("#E0E0E0"));
		panel.add(productName);
		
		productPrice = new JTextField();
		productPrice.setBounds(180, 240, 220, 30);
		productPrice.setFont(Theme.FONT_INPUT);
		productPrice.setBackground(Color.decode("#E0E0E0"));
		panel.add(productPrice);
		
		productQt = new JTextField();
		productQt.setBounds(180, 290, 220, 30);
		productQt.setFont(Theme.FONT_INPUT);
		productQt.setBackground(Color.decode("#E0E0E0"));
		panel.add(productQt);
		
		AddButton = new JButton("Add");
		AddButton.setBounds(60, 340, Theme.BUTTON_PRIMARY_WIDTH,30);
		AddButton.setFont(Theme.FONT_BUTTON);
		AddButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		AddButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		AddButton.setFocusable(false);
		AddButton.addActionListener(this);
		panel.add(AddButton);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(LogoutButton)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(BackButton)) {
			this.setVisible(false);
			new ViewProductActivity(new EmployeeActivity(employee.getUserId()), employee).setVisible(true);
		}
		else if (ae.getSource().equals(AddButton)) {
			try {
				Product p = new Product();
				p.setProductName(productName.getText().trim());
				p.setPrice(Double.parseDouble(productPrice.getText()));
				p.setQuantity(Integer.parseInt(productQt.getText()));
				p.createProduct();
				productName.setText("");
				productPrice.setText("");
				productQt.setText("");
				if (!activity.keyword.getText().trim().isEmpty())
					activity.table.setModel(Product.searchProduct(activity.keyword.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Product.searchProduct("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Enter price/quantity correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}
}