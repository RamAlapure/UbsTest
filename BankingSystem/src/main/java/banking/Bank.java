package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		this.accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		long id = new Random().nextLong();
		Account account = new CommercialAccount(company, id, pin, startingDeposit);
		accounts.put(id, account);
		return id;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		long id = new Random().nextLong();
		Account account = new ConsumerAccount(person, id, pin, startingDeposit);
		accounts.put(id, account);
        return id;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account account = accounts.get(accountNumber);
		return account.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
        return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
        return accounts.get(accountNumber).debitAccount(amount);
	}
}
