package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		this.accountNumber = accountNumber;
		this.bank = bank;
		Account account = bank.getAccount(accountNumber);
		boolean validatePin = account.validatePin(attemptedPin);
		if(!validatePin) throw new Exception("Account validation failed");
	}

	public double getBalance() {
		Account account = bank.getAccount(accountNumber);
        return account.getBalance();
	}

	public void credit(double amount) {
		Account account = bank.getAccount(accountNumber);
		account.creditAccount(amount);
	}

	public boolean debit(double amount) {
		Account account = bank.getAccount(accountNumber);
		return account.debitAccount(amount);
	}
}
