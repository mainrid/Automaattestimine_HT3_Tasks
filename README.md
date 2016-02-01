# Automaattestimine_HT3_Tasks
mockito, stubbing

Harjutustund 3

Projekti tooriku import: Eclipse-ist File -> Import... -> Projects from Git
ja kirjutage https://bitbucket.org/mkalmo/atex.git URI-ks.

Ülesanne 1

  Panna tööle test stub.ReportTest.calculatesTotalFromAmounts(). Selleks tuleb asendada
  puuduv kood stub meetoditega ehk teha järgmist:
  
  1. Kirjutada lõpuni TestableReport, mis kirjutab üle getIncomesBetween
     tagastades fikseeritud listi money objektidest.
     nt. Arrays.asList(new Money(1, "EUR"), new Money(15, "EEK"))
     Kasutada testis loodud alamklassi Report klassi asemel.
  
  2. Kirjutada lõpuni TestableBank, mis kirjutab üle convert() meetodi
     nt. if ("EEK".equals(money.getCurrency())) {
             return new Money(money.getAmount() / 15, "EUR");
         } else {
             return money;
         }
     Kasutada testis loodud alamklassi Bank klassi asemel.

Ülesanne 2

  Teha läbi loengu näited Mockito kohta, ehk panna tööle testid
  mockito.TransferServiceTestMockitoSimple klassis.

Ülesanne 3

  Soovime testida TransferService.transfer() meetodit. See meetod töötab ja seda 
  pole vaja muuta. Kuna see meetod on void, ei saa me tema õigsust tagasusväärtuse 
  järgi kontrollida. Lisaks kasutab ta oma tööks BankService-it, mida meil pole.
  Lahendus on teha mock, mis tagastab meile sobivaid väärtusi ja mille kaudu
  saame kontrollida, kuidas testitav meedod (TransferService.transfer()) käitub.
  
  Panna tööle testid klassis mockito.TransferServiceTestMockito.
  a) Õpetada BankService mock sobivalt vastama (when).
  b) Kontrollida, et withdraw() ja deposit() meetodeid kutsuti välja sobivate argumentidega.
