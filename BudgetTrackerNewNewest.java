import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BudgetTrackerNewNewest {

	static Date endDate = new Date(1, 31);
	static boolean weeklyB = false;
	static boolean biweeklyB = false;
	static String recur = "Single";

	public static void main(String[] args) {

		BudgetReport budgetReport = new BudgetReport();

		// Calendar Image
		String cale;
		int calen;
		Calendar cal;
		cale = JOptionPane.showInputDialog("Enter Month you want: ");
		calen = Integer.parseInt(cale);
		cal = new Calendar(calen);
		JLabel image = new JLabel(cal.getImage());

		// create JFrame and JTable
		JFrame frame = new JFrame();
		JTable table = new JTable();

		// create a table model and set a Column Identifiers to this model
		Object[] columns = { "Date", "Title", "Amount", "Recurrence" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);

		// JTable Color, Font, Font Color, Row Height
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("", 1, 25);
		table.setFont(font);
		table.setRowHeight(30);

		// JLabels
		JLabel dateL = new JLabel("Enter Day");
		JLabel titleL = new JLabel("Enter Title");
		JLabel amountL = new JLabel("Enter Amount");
		JLabel totalIn = new JLabel("Total Income: ");
		JLabel totalEx = new JLabel("Total Expense: ");
		JLabel totalMon = new JLabel("Total Money: ");
		totalIn.setFont(font);
		totalEx.setFont(font);
		totalMon.setFont(font);

		// JTextFields
		JTextField title = new JTextField();
		JTextField amount = new JTextField();
		JTextField recurrance = new JTextField();
		JTextField date1 = new JTextField();

		// JButtons
		JButton btnAddIn = new JButton("AddIncome");
		JButton btnAddEx = new JButton("AddExpense");
		JButton btnDelete = new JButton("Delete");
		JButton btnReOrder = new JButton("Reorder");
		JButton btnCalendar = new JButton("Calendar");
		JButton btnStartPrev = new JButton("Start Prev");
		JButton btnStartNext = new JButton("Start Next");
		JButton btnEndPrev = new JButton("End Prev");
		JButton btnEndNext = new JButton("End Next");
		JButton btnExport = new JButton("Export");

		// JRadioButton
		JRadioButton single = new JRadioButton("Single");
		JRadioButton weekly = new JRadioButton("Weekly");
		JRadioButton biweekly = new JRadioButton("BiWeekly");
		ButtonGroup group = new ButtonGroup();
		group.add(single);
		group.add(weekly);
		group.add(biweekly);

		// Setting start and End Dates
		Date startDate = new Date(cal.getMonth(), 1);
		// Date endDate = new Date(1,31);
		if (endDate.range(cal.getMonth(), 31))
			endDate = new Date(cal.getMonth(), 31);
		else if (endDate.range(cal.getMonth(), 30))
			endDate = new Date(cal.getMonth(), 30);
		else
			endDate = new Date(cal.getMonth(), 28);

		JLabel startDateL = new JLabel("Start Date: " + startDate);
		JLabel endDateL = new JLabel("End Date: " + endDate);

		// Set Bounds/Location
		date1.setBounds(1150, 10, 100, 25);
		title.setBounds(1150, 40, 100, 25);
		amount.setBounds(1150, 70, 100, 25);

		dateL.setBounds(1090, 10, 100, 25);
		titleL.setBounds(1090, 40, 100, 25);
		amountL.setBounds(1070, 70, 100, 25);
		totalIn.setBounds(10, 600, 500, 25);
		totalEx.setBounds(10, 625, 500, 25);
		totalMon.setBounds(10, 650, 500, 25);
		startDateL.setBounds(625, 600, 200, 25);
		endDateL.setBounds(850, 600, 200, 25);
		startDateL.setFont(font);
		endDateL.setFont(font);

		btnAddIn.setBounds(1150, 150, 100, 25);
		btnAddEx.setBounds(1150, 180, 105, 25);
		btnDelete.setBounds(1150, 210, 100, 25);
		btnReOrder.setBounds(1150, 240, 100, 25);
		btnCalendar.setBounds(1150, 270, 100, 25);
		btnExport.setBounds(1150, 300, 100, 25);

		btnStartPrev.setBounds(625, 625, 100, 25);
		btnStartNext.setBounds(725, 625, 100, 25);
		btnEndPrev.setBounds(850, 625, 100, 25);
		btnEndNext.setBounds(950, 625, 100, 25);

		single.setBounds(1075, 100, 75, 25);
		weekly.setBounds(1150, 100, 75, 25);
		biweekly.setBounds(1150, 125, 100, 25);

		// create JScrollPane
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 1050, 600);

		frame.setLayout(null);

		// Add to Frame
		frame.add(pane);

		frame.add(btnReOrder);
		frame.add(startDateL);
		frame.add(endDateL);

		frame.add(totalIn);
		frame.add(totalEx);
		frame.add(totalMon);

		frame.add(titleL);
		frame.add(amountL);

		frame.add(dateL);

		frame.add(title);
		frame.add(amount);
		frame.add(recurrance);
		frame.add(date1);

		frame.add(btnAddIn);
		frame.add(btnAddEx);
		frame.add(btnDelete);
		frame.add(btnExport);

		frame.add(btnCalendar);
		frame.add(btnStartPrev);
		frame.add(btnStartNext);
		frame.add(btnEndPrev);
		frame.add(btnEndNext);

		frame.add(single);
		frame.add(weekly);
		frame.add(biweekly);

		// create an array of objects to set the row data
		Object[] row = new Object[4];

		// Add Income
		btnAddIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// get date/day
				int datei = Integer.parseInt(date1.getText());
				Date date = new Date(cal.getMonth(), datei);

				// if day entered is not invalid, invalid turns to zero
				if (date.getDay() != 0) {

					// get amount
					double amount1 = Double.parseDouble(amount.getText());

					// checks weekly button
					if (weeklyB) {
						recur = "Weekly";
						// add the income 4 times
						for (int i = 0; i < 4; i++) {
							if (datei <= endDate.getDay()) {
								budgetReport.addItem(new Income(title.getText(), amount1, recur, date));
								datei = datei + 7;
								date = new Date(cal.getMonth(), datei);
							}
						}
					// checks biweekly button
					} else if (biweeklyB) {
						recur = "BiWeekly";
						// add the income 2 times
						for (int i = 0; i < 2; i++) {
							if (datei <= endDate.getDay()) {
								budgetReport.addItem(new Income(title.getText(), amount1, recur, date));
								datei = datei + 14;
								date = new Date(cal.getMonth(), datei);
							}
						}

					// if just single add it
					} else {
						// IF NOT IN DATE RANGE THAT IS MOVED
						// if(date.getDay() >= startDate.getDay() && date.getDay() <= endDate.getDay())
						// {
						BudgetItem in = new Income(title.getText(), amount1, "single", date);
						budgetReport.addItem(in);
						// }
					}

					// remove all rows so can add back in order
					for (int i = model.getRowCount() - 1; i >= 0; i--)
						model.removeRow(i);

					// add rows back inorder
					for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
						BudgetItem a = budgetReport.budgetReportList.get(j);
						row[0] = a.getDate();
						row[1] = a.getTitle();
						row[2] = "$" + a.getAmount();
						row[3] = a.getRecurrance();
						model.addRow(row);

					}
					
					// updates totals
					System.out.println(budgetReport);
					totalMon.setText("Total Money: $" + budgetReport.getTotalMon(budgetReport));
					totalIn.setText("Total Income: $" + budgetReport.getTotalIn());
					totalEx.setText("Total Expense: $" + budgetReport.getTotalEx());
				}
			}
		});

		
		// Add Expense
		btnAddEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get date/day
				int datei = Integer.parseInt(date1.getText());
				Date date = new Date(cal.getMonth(), datei);

				// if day entered is not invalid, invalid turns to zero
				if (date.getDay() != 0) {
					double amount1 = Double.parseDouble(amount.getText());
					
					// checks weekly button
					if (weeklyB) {
						recur = "Weekly";
						// add the income 4 times
						for (int i = 0; i < 4; i++) {
							if (datei <= endDate.getDay()) {
								budgetReport.addItem(new Expense(title.getText(), amount1, recur, date));
								datei = datei + 7;
								date = new Date(cal.getMonth(), datei);
							}
						}
						
					// checks biweekly button
					} else if (biweeklyB) {
						recur = "BiWeekly";
						// add the income 2 times
						for (int i = 0; i < 2; i++) {
							if (datei <= endDate.getDay()) {
								budgetReport.addItem(new Expense(title.getText(), amount1, recur, date));
								datei = datei + 14;
								date = new Date(cal.getMonth(), datei);
							}
						}
					
					// if just single add it
					} else {
						BudgetItem ex = new Expense(title.getText(), amount1, "single", date);
						budgetReport.addItem(ex);
					}
					
					// remove all rows so can add back in order
					for (int i = model.getRowCount() - 1; i >= 0; i--)
						model.removeRow(i);
					
					// add rows back inorder
					for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
						BudgetItem a = budgetReport.budgetReportList.get(j);
						row[0] = a.getDate();
						row[1] = a.getTitle();
						row[2] = "$" + a.getAmount();
						row[3] = a.getRecurrance();
						model.addRow(row);
					}
					
					// updates totals
					System.out.println(budgetReport);
					totalMon.setText("Total Money: $" + budgetReport.getTotalMon(budgetReport));
					totalIn.setText("Total Income: $" + budgetReport.getTotalIn());
					totalEx.setText("Total Expense: $" + budgetReport.getTotalEx());
				}
			}
		});
		
		// Deletes item that matches date and title
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gets date
				int datei = Integer.parseInt(date1.getText());
				// calls delete method
				budgetReport.delete(budgetReport, title.getText(), datei);
				
				// remove all rows so can add back in order
				for (int i = model.getRowCount() - 1; i >= 0; i--)
					model.removeRow(i);
				
				// add rows back inorder
				for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
					BudgetItem a = budgetReport.budgetReportList.get(j);
					row[0] = a.getDate();
					row[1] = a.getTitle();
					row[2] = "$" + a.getAmount();
					row[3] = a.getRecurrance();
					model.addRow(row);
				}
			}
		});

		// Shows calendar in pop window
		btnCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, image);
			}
		});

		// Decrements start date
		btnStartPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dec day, set text
				startDate.decDay();
				startDateL.setText("Start Date: " + startDate);
				
				// check for popping item
				budgetReport.pops(budgetReport, startDate.getDay(), endDate.getDay());

				for (int i = model.getRowCount() - 1; i >= 0; i--)
					model.removeRow(i);

				for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
					BudgetItem a = budgetReport.budgetReportList.get(j);
					row[0] = a.getDate();
					row[1] = a.getTitle();
					row[2] = "$" + a.getAmount();
					row[3] = a.getRecurrance();
					model.addRow(row);
				}
				totalMon.setText("Total Money: $" + budgetReport.getTotalMon(budgetReport));
				totalIn.setText("Total Income: $" + budgetReport.getTotalIn());
				totalEx.setText("Total Expense: $" + budgetReport.getTotalEx());
			}
		});
		
		// Increments start date
		btnStartNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if start date is not going to pass end date
				if (startDate.getDay() + 1 <= endDate.getDay()) {
					
					startDate.incDay();
					startDateL.setText("Start Date: " + startDate);
					budgetReport.pushes(budgetReport, startDate.getDay(), endDate.getDay());
					
					for (int i = model.getRowCount() - 1; i >= 0; i--)
						model.removeRow(i);

					for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
						BudgetItem a = budgetReport.budgetReportList.get(j);
						row[0] = a.getDate();
						row[1] = a.getTitle();
						row[2] = "$" + a.getAmount();
						row[3] = a.getRecurrance();
						model.addRow(row);
					}

				}
				totalMon.setText("Total Money: $" + budgetReport.getTotalMon(budgetReport));
				totalIn.setText("Total Income: $" + budgetReport.getTotalIn());
				totalEx.setText("Total Expense: $" + budgetReport.getTotalEx());
			}
		});
		
		// Decrements end date
		btnEndPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (endDate.getDay() - 1 >= startDate.getDay()) {
					endDate.decDay();
					endDateL.setText("End Date: " + endDate);
					budgetReport.pushes(budgetReport, startDate.getDay(), endDate.getDay());
					for (int i = model.getRowCount() - 1; i >= 0; i--)
						model.removeRow(i);

					for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
						BudgetItem a = budgetReport.budgetReportList.get(j);
						row[0] = a.getDate();
						row[1] = a.getTitle();
						row[2] = "$" + a.getAmount();
						row[3] = a.getRecurrance();
						model.addRow(row);
					}
				}
				totalMon.setText("Total Money: $" + budgetReport.getTotalMon(budgetReport));
				totalIn.setText("Total Income: $" + budgetReport.getTotalIn());
				totalEx.setText("Total Expense: $" + budgetReport.getTotalEx());
			}
		});
		
		// Increments end date
		btnEndNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endDate.incDay();
				endDateL.setText("End Date: " + endDate);
				budgetReport.pops(budgetReport, startDate.getDay(), endDate.getDay());

				for (int i = model.getRowCount() - 1; i >= 0; i--)
					model.removeRow(i);

				for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
					BudgetItem a = budgetReport.budgetReportList.get(j);
					row[0] = a.getDate();
					row[1] = a.getTitle();
					row[2] = "$" + a.getAmount();
					row[3] = a.getRecurrance();
					model.addRow(row);
				}
				totalMon.setText("Total Money: $" + budgetReport.getTotalMon(budgetReport));
				totalIn.setText("Total Income: $" + budgetReport.getTotalIn());
				totalEx.setText("Total Expense: $" + budgetReport.getTotalEx());
			}
		});

		// Button for emergency Reordering
		btnReOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = model.getRowCount() - 1; i >= 0; i--)
					model.removeRow(i);
				budgetReport.sort();

				for (int j = 0; j < budgetReport.budgetReportList.size(); j++) {
					BudgetItem a = budgetReport.budgetReportList.get(j);
					row[0] = a.getDate();
					row[1] = a.getTitle();
					row[2] = "$" + a.getAmount();
					row[3] = a.getRecurrance();
					model.addRow(row);
				}
			}
		});
		
		//Weekly radio button
		weekly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weeklyB = true;
				biweeklyB = false;
			}
		});

		//BiWeekly radio button
		biweekly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biweeklyB = true;
				weeklyB = false;
			}
		});

		//Daily radio button
		single.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weeklyB = false;
				biweeklyB = false;
				recur = "single";
			}
		});

		//Export
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				budgetReport.export(budgetReport, startDate, endDate);
			}
		});

		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}