public class Main {
	public static void main(String[] args) {

		// HDFCAccount VivekAcc = new HDFCAccount("Vivek", "vivek123", 2000);
		SBI rahul = new SBI("rahul", "Rahul123", 20000);

		System.out.println(rahul); // printed the attricutes via toString

		// fetch balance
		System.out.println(rahul.fetchBalance("random")); // wrong password
		System.out.println(rahul.fetchBalance("Rahul123")); // correct
															// password

		// add money
		System.out.println(rahul.addMoney(100000));
		// withdraw
		System.out.println(rahul.withdrawMoney(200000, "Rahul123"));
		System.out.println(rahul.withdrawMoney(50000, "Rahul123"));
		System.out.println(rahul.withdrawMoney(50000, "random"));

		// change Password
		System.out.println(rahul.changePassword("random", "vivek"));
		System.out.println(rahul.changePassword("Rahul123", "vivek"));
		System.out.println(rahul.changePassword("rahul123", "Rahul@123"));

		System.out.println(rahul.fetchBalance("Rahul@123"));

		// calculate interest
		System.out.println("Interest for 5 years on current balance will be: "
				+ rahul.calculateInterest(5));

	}
}
