
public class BudgetItem {
	private String title;
	private Double amount;
	private String recurrance;
	private Date date;
	private boolean isExpense;

	public BudgetItem(String title, Double amount, String recurrance, Date date) {
		this.title = title;
		this.amount = amount;
		this.recurrance = recurrance;
		this.date = date;
	}

	public String toString() {
		return "Title: " + title + "  Date: " + date + "  Amount: $" + amount + "  Recurrance: " + recurrance;
	}

	public String getTitle() {
		return title;
	}

	public Double getAmount() {
		return amount;
	}

	public String getRecurrance() {
		return recurrance;
	}

	public String getDate() {
		return date.toString();
	}

	public Date getDateObj() {
		return date;
	}
}
