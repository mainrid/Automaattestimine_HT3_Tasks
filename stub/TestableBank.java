package stub;

import common.Money;

public class TestableBank extends Bank {
	
	@Override
	public Money convert(Money money, String toCurrency) {
		if ("EEK".equals(money.getCurrency())) {
            return new Money(money.getAmount() / 15, "EUR");
        } else {
            return money;
        }
    }
	
}
