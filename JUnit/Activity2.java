package activities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Activity2 {
	@Test
	void notEnoughFunds() {
		
		BankAccount BA = new BankAccount(9);
		
		assertThrows(NotEnoughFundsException.class, () -> BA.withdraw(8), "Balance is equal to Withdraw r greaterthan withdraw");
	}
	
	@Test
	void enoughFunds() {
		BankAccount BA = new BankAccount(9);
		assertDoesNotThrow(() -> BA.withdraw(9));
	}

}
