
public class Date {
	private int month;
	private int day;

	public Date(int month, int day) {
		if (range(month, day)) {
			this.month = month;
			this.day = day;
		}
	}

	public String toString() {
		return month + "-" + day;
	}

	public boolean range(int month, int day) {
		if (month > 0 && month <= 12 && day > 0 && day <= 31) {
			if (month == 2 && day > 28)
				return false;
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day > 30)
					return false;
			}

			return true;
		} else
			return false;

	}

	public int getDay() {
		return day;
	}

	public void incDay() {
		if (range(month, day + 1))
			this.day = day + 1;
	}

	public void decDay() {
		if (range(month, day - 1))
			this.day = day - 1;
	}

}
