package stub;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import common.Money;

public class ReportTest {

    @Test
    public void calculatesTotalFromAmounts() {
    	Report report = new TestableReport();
        report.setBank(new TestableBank());

        Money total = report.getTotalIncomeBetween(null, null);

        assertThat(total, is(new Money(2, "EUR")));
    }

}
