package Features;

import java.lang.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributes.*;

public class ViewEmployeeActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton LogoutButton, BackButton, CheckButton, AddEmployeeButton;
	private JLabel title, header, keywordLabel;
	JTextField keyword;
	
	public ViewEmployeeActivity(JFrame prev, Employee employee) {
		super("View Employee");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Employee Details");
		title.setBounds(30, 40, 400,75);
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
		
		AddEmployeeButton = new JButton("Add");
		AddEmployeeButton.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		AddEmployeeButton.setFont(Theme.FONT_BUTTON);
		AddEmployeeButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		AddEmployeeButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		AddEmployeeButton.setFocusable(false);
		AddEmployeeButton.addActionListener(this);
		panel.add(AddEmployeeButton);
		
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		
		keyword = new JTextField();
		keyword.setBounds(160, 140, 240, 30);
		keyword.setFont(Theme.FONT_INPUT);
		panel.add(keyword);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		
		CheckButton = new JButton("Search");
		CheckButton.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		CheckButton.setFont(Theme.FONT_BUTTON);
		CheckButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		CheckButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		CheckButton.setFocusable(false);
		CheckButton.addActionListener(this);
		panel.add(CheckButton);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Employee.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		
		table.setModel(Employee.searchEmployee("", "By Name"));
		
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
		else if (ae.getSource().equals(AddEmployeeButton)) {
			this.setVisible(false);
			new AddEmployeeActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(CheckButton)) {
			table.setModel(Employee.searchEmployee(keyword.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();

       TableModel model = table.getModel();

       String value1 = model.getValueAt(index, 0).toString();
	   new ManageEmployee(value1, this).setVisible(true);
    }
}