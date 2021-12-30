package Features;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import Attributes.*;

public class MyProductActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Customer customer;
	private JFrame activity;
	private JScrollPane frame;
	private JTable table;
	private JButton LogoutButton, BackButton, CheckButton;
	private JLabel title, header, keywordLabel, productNameLabel, productQtLabel, productPriceLabel;
	private JTextField keywordTF, productNameTF, productQtTF, productPriceTF;
	public MyProductActivity(JFrame prev, Customer customer) {
		super("Purchase History");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.customer = customer;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Purchase History");
		title.setBounds(30, 40, 480,75);
		title.setOpaque(true);
		title.setBackground(Color.decode("#CCFFFF"));
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		LogoutButton = new JButton("Logout");
		LogoutButton.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		LogoutButton.setFont(Theme.FONT_BUTTON);
		LogoutButton.setBackground(Color.WHITE);
		LogoutButton.setForeground(Theme.COLOR_TITLE);
		LogoutButton.setBackground(Color.decode("#CCFFFF"));
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
		
		table = new JTable();
		table.setModel(customer.myProduct());
		frame = new JScrollPane(table);
		frame.setBounds(40,140,600,300);
		panel.add(frame);
		
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
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       
    }
}