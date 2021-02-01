package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private long accountNumber = 0;

	public Bank() {
		accounts = new LinkedHashMap<Long, Account>();
	}

	private Account getAccount(Long accountNumber) {
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		CommercialAccount c = new CommercialAccount(company, ++accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, c);
		return c.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		ConsumerAccount c = new ConsumerAccount(person, ++accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, c);
		return c.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account a = getAccount(accountNumber);
		if (a != null) {
			return a.validatePin(pin);
		}
		return false;
	}

	public double getBalance(Long accountNumber) {
		Account a = getAccount(accountNumber);
		if (a != null) {
			return a.getBalance();
		}
		// complete the function
		return -1;
	}

	public void credit(Long accountNumber, double amount) {
		Account a = getAccount(accountNumber);
		if (a != null) {
			a.creditAccount(amount);
		}
	}

	public boolean debit(Long accountNumber, double amount) {
		Account a = getAccount(accountNumber);
		if (a != null) {
			return a.debitAccount(amount);
		}
		return false;
	}
}
