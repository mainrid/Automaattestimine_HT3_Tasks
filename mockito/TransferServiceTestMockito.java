package mockito;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import common.BankService;
import common.TransferService;
import common.Money;

@SuppressWarnings("unused")
public class TransferServiceTestMockito {

    BankService bankService = mock(BankService.class);
    TransferService transferService = new TransferService(bankService);

    @Test
    public void transferWithCurrencyConversion() {        
    	when(bankService.getAccountCurrency("E_123")).thenReturn("EUR");
    	
    	Money moneyTransferedInEUR= new Money(1,"EUR");
    	Money moneyTransferedInSEK= new Money(9, "SEK");
    	
        when(bankService.convert(new Money(1,"EUR"), "EUR")).thenReturn(moneyTransferedInEUR);
        when(bankService.hasSufficientFundsFor(moneyTransferedInEUR, "E_123")).thenReturn(true);
        // when(...
        // seda mida on vaja õpetada leiab transferService.transfer() meetodist.

        // kanda 1 EUR kontolt E_123 kontole S_456
        // E_123 konto valuuta on EUR
        // S_456 konto valuuta on SEK
       
      
        when(bankService.getAccountCurrency("S_456")).thenReturn("SEK");
        when(bankService.convert(moneyTransferedInEUR, "SEK")).thenReturn(moneyTransferedInSEK);
        
        transferService.transfer(moneyTransferedInEUR, "E_123", "S_456");
        verify(bankService).withdraw(moneyTransferedInEUR, "E_123");
        verify(bankService).deposit(moneyTransferedInSEK, "S_456");
        
    }

    @Test
    public void transferWhenNotEnoughFunds() {
    	when(bankService.getAccountCurrency("E_123")).thenReturn("EUR");
        when(bankService.convert(new Money(1,"EUR"), "EUR")).thenReturn(new Money(1,"EUR"));
        when(bankService.hasSufficientFundsFor(new Money(1,"EUR"), "E_123")).thenReturn(false);
        verify(bankService, never()).withdraw(anyMoney(), anyString());
    }

    private Money anyMoney() {
        return (Money) any();
    }

    private String anyAccount() {
        return anyString();
    }
}