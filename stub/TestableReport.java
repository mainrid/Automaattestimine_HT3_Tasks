package stub;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import common.Money;

public class TestableReport extends Report {
    protected List<Money> getIncomesBetween(Date startDate, Date endDate) {
        return Arrays.asList(new Money(1, "EUR"), new Money(15, "EEK"));
    }
}
