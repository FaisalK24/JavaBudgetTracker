import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class BudgetReport {

	LinkedList<BudgetItem> budgetReportList = new LinkedList<BudgetItem>();
	Stack<BudgetItem> budgetReportFront = new Stack<BudgetItem>();
	Stack<BudgetItem> budgetReportEnd = new Stack<BudgetItem>();;
	double totalIn;
	double totalEx;
	double totalMon;

	public BudgetReport() {
	}

	// adds item in order
	public void addItem(BudgetItem it) {
		
		// loops from backs to front
		for (int i = budgetReportList.size() - 1; i >= 0; i--) {
			//if date is greater than index
			if (it.getDateObj().getDay() > budgetReportList.get(i).getDateObj().getDay()) {
				//add it after that
				budgetReportList.add(i + 1, it);
				return;
			}
		}
		//else add to front
		budgetReportList.addFirst(it);
	}

	public String toString() {
		return Arrays.toString(budgetReportList.toArray());
	}

	public double getTotalIn() {
		return totalIn;
	}

	public double getTotalEx() {
		return totalEx;
	}

	// Updates totals
	public double getTotalMon(BudgetReport list) {
		//variables for adding
		double upTotalMon = 0;
		double upTotalIn = 0;
		double upTotalEx = 0;
		
		//loops through linked list
		for (int i = 0; i < list.budgetReportList.size(); i++) {
			BudgetItem it = list.budgetReportList.get(i);
			// adds to total money
			upTotalMon = upTotalMon + it.getAmount();
			//if item is income adds the total income
			if (it instanceof Income)
				upTotalIn = upTotalIn + it.getAmount();
			//else adds the total expense
			else
				upTotalEx = upTotalEx + it.getAmount();
		}
		totalIn = upTotalIn;
		totalEx = upTotalEx;
		totalMon = upTotalMon;
		return totalMon;
	}

	// pops item out of front stack and adds it to head of list
	private void popFront() {
		budgetReportList.addFirst(budgetReportFront.pop());
	}

	// pushes head of list into front stack 
	private void pushFront() {
		budgetReportFront.push(budgetReportList.poll());
	}

	// pops item out of end stack and adds it to tail of list
	private void popEnd() {
		//BudgetItem it = budgetReportEnd.pop();
		budgetReportList.addLast( budgetReportEnd.pop());
	}

	// pushes tail of list into end stack 
	private void pushEnd() {
		//BudgetItem it = budgetReportList.pollLast();
		budgetReportEnd.push(budgetReportList.pollLast());
	}

	// checks for pushing
	public void pushes(BudgetReport list, int startDay, int endDay) {
		// loop from start, if item date is less than new start, push to front stack
		for (int i = 0; i < list.budgetReportList.size(); i++) {
			if (list.budgetReportList.get(i).getDateObj().getDay() < startDay) {
				pushFront();
			}
		}

		// loop from end, if item date is greater than end start, push to end stack
		for (int i = list.budgetReportList.size() - 1; i >= 0; i--) {
			if (list.budgetReportList.get(i).getDateObj().getDay() > endDay) {
				pushEnd();
			}
		}
		//RESORTS
		//sort();
	}

	// checks for popping
	public void pops(BudgetReport list, int startDay, int endDay) {
		// loop from start, if item date is greater than new start, pop from front stack
		for (int i = 0; i < list.budgetReportFront.size(); i++) {
			if (list.budgetReportFront.get(i).getDateObj().getDay() >= startDay) {
				popFront();
			}
		}

		// loop end end, if item date is less than new end, pop from end stack
		for (int i = list.budgetReportEnd.size() - 1; i >= 0; i--) {
			if (list.budgetReportEnd.get(i).getDateObj().getDay() <= endDay) {
				popEnd();
			}
		}
		//RESORTS
		//sort();
	}

	// sorting
	public void sort() {
		Collections.sort(budgetReportList, new Comparator<BudgetItem>() {
			@Override
			public int compare(BudgetItem a, BudgetItem b) {
				return a.getDateObj().getDay() - (b.getDateObj().getDay());
			}
		});
	}

	// delete 
	public void delete(BudgetReport list, String title, int day) {
		for (int i = 0; i < list.budgetReportList.size(); i++) {
			BudgetItem it = list.budgetReportList.get(i);
			// if item matches titles and day
			if (it.getTitle().compareTo(title) == 0 && it.getDateObj().getDay() == day)
				list.budgetReportList.remove(i);
		}
	}

	// export
	public void export(BudgetReport list, Date start, Date end) {
		try {
			PrintWriter writer = new PrintWriter("BudgetReportExport.txt");
			for (int i = 0; i < list.budgetReportList.size(); i++) {
				BudgetItem it = list.budgetReportList.get(i);
				writer.println(it.toString());
			}
			writer.println("From " + start + " to " + end);
			writer.println("Total Expense is " + totalEx);
			writer.println("Total Income is " + totalIn);
			writer.println("Total Money is " + totalMon);

			writer.close();
		} catch (IOException e) {
		}
	}
}
