
public class Expense extends BudgetItem {

	public Expense(String title, Double amount, String recurrance, Date date) {
		super(title, (amount * -1), recurrance, date);
		// TODO Auto-generated constructor stub
	}
}
