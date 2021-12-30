package Features;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributes.*;

public class AddEmployeeActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private ViewEmployeeActivity activity;
	private JButton LogoutButton, BackButton, AddButton, EditButton, DeleteButton, RandomButton;
	private JLabel title, header, employeeIdLabel, employeeNameLabel, roleLabel, employeePhoneLabel, salaryLabel;
	private JComboBox roleCB;
	private JTextField employeeId, employeeName, salary, employeePhone1, employeePhone2, password;
	private Random r;
	
	public AddEmployeeActivity(ViewEmployeeActivity prev, Employee employee) {
		super("Add Employee");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		r = new Random();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Add Employee");
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
		
		employeeIdLabel = new JLabel("Employee ID: ");
		employeeIdLabel.setBounds(60, 140, 140, 30);
		employeeIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeIdLabel);
		
		employeeIdLabel = new JLabel("Password: ");
		employeeIdLabel.setBounds(60, 190, 140, 30);
		employeeIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeIdLabel);
		
		employeeNameLabel = new JLabel("Name: ");
		employeeNameLabel.setBounds(60, 240, 140, 30);
		employeeNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeNameLabel);
		
		employeePhoneLabel = new JLabel("Phone No: ");
		employeePhoneLabel.setBounds(60, 290, 140, 30);
		employeePhoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeePhoneLabel);
		
		roleLabel = new JLabel("Role: ");
		roleLabel.setBounds(60, 340, 340, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(60, 390, 140, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);
		
		employeeId = new JTextField();
		employeeId.setBounds(180, 140, 220, 30);
		employeeId.setFont(Theme.FONT_INPUT);
		employeeId.setBackground(Color.decode("#E0E0E0"));
		panel.add(employeeId);
		
		password = new JTextField(""+(r.nextInt(89999999)+10000000));
		password.setBounds(180, 190, 220, 30);
		password.setFont(Theme.FONT_INPUT);
		password.setEnabled(false);
		password.setBackground(Color.decode("#E0E0E0"));
		password.setDisabledTextColor(Color.BLACK);
		panel.add(password);
		
		RandomButton = new JButton("Generate");
		RandomButton.setBounds(400, 190, Theme.BUTTON_PRIMARY_WIDTH+20,30);
		RandomButton.setFont(Theme.FONT_BUTTON);
		RandomButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		RandomButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		RandomButton.addActionListener(this);
		panel.add(RandomButton);
		
		employeeName = new JTextField();
		employeeName.setBounds(180, 240, 220, 30); 
		employeeName.setFont(Theme.FONT_INPUT);
		employeeName.setBackground(Color.decode("#E0E0E0"));
		panel.add(employeeName);
		
		employeePhone1 = new JTextField("+852");
		employeePhone1.setBounds(180, 290, 40, 30);
		employeePhone1.setEnabled(false);
		employeePhone1.setFont(Theme.FONT_INPUT);
		panel.add(employeePhone1);
	
		employeePhone2 = new JTextField();
		employeePhone2.setBounds(220, 290, 180, 30);
		employeePhone2.setFont(Theme.FONT_INPUT);
		employeePhone2.setBackground(Color.decode("#E0E0E0"));
		panel.add(employeePhone2);
		
		roleCB = new JComboBox(Employee.roles);
		roleCB.setBounds(180, 340, 160, 30);
		roleCB.setFont(Theme.FONT_INPUT);
		panel.add(roleCB);
		
		salary = new JTextField();
		salary.setBounds(180, 390, 220, 30);
		salary.setFont(Theme.FONT_INPUT);
		salary.setBackground(Color.decode("#E0E0E0"));
		panel.add(salary);
		
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
				Employee e = new Employee(employeeId.getText().trim());
				e.setPassword(password.getText().trim());
				e.setEmployeeName(employeeName.getText().trim());
				e.setPhoneNumber(Integer.parseInt(employeePhone2.getText()));
				e.setSalary(Double.parseDouble(salary.getText()));
				e.setRole(roleCB.getSelectedItem().toString());
				e.createEmployee();
				employeeId.setText("");
				employeeName.setText("");
				employeePhone2.setText("");
				salary.setText("");
				roleCB.setSelectedIndex(0);
				if (!activity.keyword.getText().trim().isEmpty())
					activity.table.setModel(Employee.searchEmployee(activity.keyword.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Employee.searchEmployee("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Enter phone no correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else if (ae.getSource().equals(RandomButton)) {
			password.setText(""+(r.nextInt(89999999)+10000000));
		}
		else {}
	}
}