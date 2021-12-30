package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributes.*;

public class ViewSupplierActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton LogoutButton, BackButton, CheckButton, AddSupplierButton;
	private JLabel title, header, keywordLabel;
	JTextField keyword;
	
	public ViewSupplierActivity(JFrame prev, Employee employee) {
		super("View Supplier");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Supplier Details");
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

		AddSupplierButton = new JButton("Add");
		AddSupplierButton.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		AddSupplierButton.setFont(Theme.FONT_BUTTON);
		AddSupplierButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		AddSupplierButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		AddSupplierButton.setFocusable(false);
		AddSupplierButton.addActionListener(this);
		panel.add(AddSupplierButton);		
		
		
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		
		keyword = new JTextField();
		keyword.setBounds(160, 160, 240, 30);
		keyword.setFont(Theme.FONT_INPUT);
		keyword.setBackground(Color.decode("#E0E0E0"));
		panel.add(keyword);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 160, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		
		CheckButton = new JButton("Search");
		CheckButton.setBounds(500, 160, Theme.BUTTON_PRIMARY_WIDTH,30);
		CheckButton.setFont(Theme.FONT_BUTTON);
		CheckButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		CheckButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		CheckButton.setFocusable(false);
		CheckButton.addActionListener(this);
		panel.add(CheckButton);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Supplier.columnNames);
		table.setModel(model);
		
		table.setAutoCreateColumnsFromModel(false);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(220);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		frame = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.setBounds(50,240,600,300);
		panel.add(frame);
		
		
		table.setModel(Supplier.searchSupplier("", "By Name"));
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH+30, 100);
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
		else if (ae.getSource().equals(AddSupplierButton)) {
			this.setVisible(false);
			new AddSupplierActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(CheckButton)) {
			table.setModel(Supplier.searchSupplier(keyword.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();

       TableModel model = table.getModel();

       String value1 = model.getValueAt(index, 0).toString();
	   new ManageSupplier(value1, this).setVisible(true);
    }
}
