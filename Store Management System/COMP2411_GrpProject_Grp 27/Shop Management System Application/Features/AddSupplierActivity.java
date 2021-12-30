package Features;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributes.*;

public class AddSupplierActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private ViewSupplierActivity activity;
	private JButton LogoutButton, BackButton, AddButton, EditButton, DeleteButton, RandomButton;
	private JLabel title, header, supplierIdLabel, supplierNameLabel, supplierLocationLabel, productIdLabel;
	private JTextField supplierId, supplierName, supplierLocation, productId;
	private Random r;
	
	public AddSupplierActivity(ViewSupplierActivity prev, Employee employee) {
		super("Add Supplier");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		r = new Random();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Add Supplier");
		title.setBounds(30, 40, 340,75);
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
		
		supplierIdLabel = new JLabel("Supplier ID: ");
		supplierIdLabel.setBounds(60, 140, 140, 30);
		supplierIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(supplierIdLabel);
		
		supplierNameLabel = new JLabel("Name: ");
		supplierNameLabel.setBounds(60, 190, 140, 30);
		supplierNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(supplierNameLabel);
		
		supplierLocationLabel = new JLabel("Location: ");
		supplierLocationLabel.setBounds(60, 240, 140, 30);
		supplierLocationLabel.setFont(Theme.FONT_REGULAR);
		panel.add(supplierLocationLabel);
		
		productIdLabel = new JLabel("Product IDs: ");
		productIdLabel.setBounds(60, 290, 340, 30);
		productIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productIdLabel);
		
		
		supplierId = new JTextField();
		supplierId.setBounds(180, 140, 220, 30);
		supplierId.setFont(Theme.FONT_INPUT);
		supplierId.setBackground(Color.decode("#E0E0E0"));
		panel.add(supplierId);
		
		supplierName = new JTextField();
		supplierName.setBounds(180, 190, 220, 30); 
		supplierName.setFont(Theme.FONT_INPUT);
		supplierName.setBackground(Color.decode("#E0E0E0"));
		panel.add(supplierName);
		
	
		supplierLocation = new JTextField();
		supplierLocation.setBounds(180, 240, 220, 30);
		supplierLocation.setFont(Theme.FONT_INPUT);
		supplierLocation.setBackground(Color.decode("#E0E0E0"));
		panel.add(supplierLocation);
		
		productId = new JTextField();
		productId.setBounds(180, 290, 220, 30);
		productId.setFont(Theme.FONT_INPUT);
		productId.setBackground(Color.decode("#E0E0E0"));
		panel.add(productId);
		
		AddButton = new JButton("Add");
		AddButton.setBounds(60, 440, Theme.BUTTON_PRIMARY_WIDTH,30);
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
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(AddButton)) {
			try {
				Supplier e = new Supplier(supplierId.getText().trim());
				e.setSupplierName(supplierName.getText().trim());
				e.setSupplierLocation(supplierLocation.getText().trim());
				e.setProductID(productId.getText());
				e.createSupplier();
				supplierId.setText("");
				supplierName.setText("");
				supplierLocation.setText("");
				productId.setText("");
				if (!activity.keyword.getText().trim().isEmpty())
					activity.table.setModel(Supplier.searchSupplier(activity.keyword.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Supplier.searchSupplier("", "By Name"));
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}
}
