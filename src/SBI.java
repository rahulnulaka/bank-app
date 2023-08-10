import java.util.UUID;

public class SBI implements BankAccountInterface {
	private String name;

	private String accountNo; // unique UUID

	private String password;

	private double balance;

	final double rateOfInterest = Math.random();

	final String IFSCCode = "SBI374873";

	public SBI() {

	}

	public SBI(String name, String password, double balance) {
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.accountNo = String.valueOf(UUID.randomUUID());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public String fetchBalance(String password) {
		// TODO Auto-generated method stub
		if (this.password.equals(password)) {
			return "Your balance is: " + this.balance;
		}
		return "Incorrect Password!!!";
	}

	public String addMoney(double amount) {
		this.balance += amount;
		return "Added successfully: " + " New Balance is: " + this.balance;
	}

	public String withdrawMoney(double amount, String password) {
		if (this.balance < 0 || this.balance < amount) {
			return "Insufficient funds";
		}
		this.balance -= amount;
		return "Withdraw successfull: " + "New Balance is: " + this.balance;
	}

	public String changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if (this.password != oldPassword)
			return "Incorrect Password!!!";
		boolean flag = Check(newPassword);
		if (!flag) {
			return "Make Sure your password contains uppercase,lowercase,digit,specialcharacter: ";
		}
		this.password = newPassword;
		return "Successfully changed Password";
	}

	private boolean Check(String newPassword) {
		// TODO Auto-generated method stub
		if (newPassword.length() < 8)
			return false;
		boolean uppercase = false;
		boolean lowercase = false;
		boolean digit = false;
		boolean specialcharacter = false;
		for (int i = 0; i < newPassword.length(); i++) {
			if (Character.isUpperCase(newPassword.charAt(i))) {
				uppercase = true;
			} else if (Character.isLowerCase(newPassword.charAt(i))) {
				lowercase = true;
			} else if (Character.isDigit(newPassword.charAt(i))) {
				digit = true;
			} else {
				String special = "!@#$%^&*";
				for (int j = 0; j < special.length(); j++) {
					if (special.charAt(j) == newPassword.charAt(i)) {
						specialcharacter = true;
					}
				}
			}
		}
		return (uppercase && lowercase && digit && specialcharacter);
	}

	public double calculateInterest(int year) {
		// TODO Auto-generated method stub
		return (this.balance * this.rateOfInterest * year) / 100;
	}

	public String toString() {
		return "SBI [name=" + name + ", accountNo=" + accountNo + ", password="
				+ password + ", balance=" + balance + ", rateOfInterest="
				+ rateOfInterest + ", IFSCCode=" + IFSCCode + "]";
	}

}
