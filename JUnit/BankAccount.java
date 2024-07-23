package activities;

public class BankAccount {
	
	
	    private Integer balance;
	    
	    // Create a constructor
	    public BankAccount(Integer initialBalance) {
	        this.balance = initialBalance;
	    }

	    // Add method to calculate
	    // balance amount after withdrawal
	    public Integer withdraw(Integer amount) {
	        if (this.balance < amount) {
	            throw new NotEnoughFundsException(amount, balance);
	        }
	        this.balance  -= amount;
	        return this.balance;
	    }
	}


