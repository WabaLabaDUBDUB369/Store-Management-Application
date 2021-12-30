package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Attributes.*;

public class ManageEmployee extends JFrame implements ActionListener {
	private JPanel panel;
	ViewEmployeeActivity prev;
	private Employee employee;
	private JButton BackButton, EditButton, DeleteButton;
	private JLabel title, header, userIdLabel, employeeNameLabel, phoneNumberLabel, roleLabel, salaryLabel;
	private JTextField userId, employeeName, phoneNumber, phoneCode, salary;
	private JComboBox roleCB;
	
	public ManageEmployee(String eid, ViewEmployeeActivity prev) {
		super("Manage Employee");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		employee = new Employee(eid);
		employee.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		userIdLabel = new JLabel("Employee ID: "+employee.getUserId());
		userIdLabel.setBounds(60, 20, 160, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		employeeNameLabel = new JLabel("Name: ");
		employeeNameLabel.setBounds(60, 60, 140, 30);
		employeeNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(employeeNameLabel);
		
		phoneNumberLabel = new JLabel("Phone: ");
		phoneNumberLabel.setBounds(60, 100, 140, 30);
		phoneNumberLabel.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberLabel);
		
		roleLabel = new JLabel("Role: ");
		roleLabel.setBounds(60, 140, 140, 30);
		roleLabel.setFont(Theme.FONT_INPUT);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(60, 180, 140, 30);
		salaryLabel.setFont(Theme.FONT_INPUT);
		panel.add(salaryLabel);
		
		employeeName = new JTextField(employee.getEmployeeName());
		employeeName.setBounds(160, 60, 220, 30);
		employeeName.setFont(Theme.FONT_INPUT);
		employeeName.setBackground(Color.decode("#E0E0E0"));
		panel.add(employeeName);
		
		phoneCode = new JTextField("+852");
		phoneCode.setEnabled(false);
		phoneCode.setBounds(160, 100, 40, 30);
		phoneCode.setFont(Theme.FONT_INPUT);
		panel.add(phoneCode);
		

		phoneNumber = new JTextField(employee.getPhoneNumber().substring(4)+"");
		phoneNumber.setBounds(200, 100, 180, 30);
		phoneNumber.setFont(Theme.FONT_INPUT);
		phoneNumber.setBackground(Color.decode("#E0E0E0"));
		panel.add(phoneNumber);
		
		roleCB = new JComboBox(Employee.roles);
		roleCB.setBounds(160, 140, 160, 30);
		roleCB.setSelectedIndex(employee.getRole().equals("Manager") ? 1 : 0);
		roleCB.setFont(Theme.FONT_INPUT);
		panel.add(roleCB);
		
		salary = new JTextField(employee.getSalary()+"");
		salary.setBounds(160, 180, 220, 30);
		salary.setFont(Theme.FONT_INPUT);
		salary.setBackground(Color.decode("#E0E0E0"));
		panel.add(salary);
		
		EditButton = new JButton("Update");
		EditButton.setBounds(60, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		EditButton.setFont(Theme.FONT_BUTTON);
		EditButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		EditButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		EditButton.addActionListener(this);
		panel.add(EditButton);
		
		DeleteButton = new JButton("Delete");
		DeleteButton.setBounds(180, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		DeleteButton.setFont(Theme.FONT_BUTTON);
		DeleteButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		DeleteButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		DeleteButton.addActionListener(this);
		panel.add(DeleteButton);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(EditButton)) {
			try {
				employee.updateEmployee(employeeName.getText(),Integer.parseInt(phoneNumber.getText()),roleCB.getSelectedItem().toString(), Double.parseDouble(salary.getText()));
				if (!prev.keyword.getText().trim().isEmpty())
					prev.table.setModel(Employee.searchEmployee(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Employee.searchEmployee("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(DeleteButton)) {
			employee.deleteEmployee();
			if (!prev.keyword.getText().trim().isEmpty())
				prev.table.setModel(Employee.searchEmployee(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Employee.searchEmployee("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}