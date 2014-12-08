package mortgage;
import static org.junit.Assert.*;

import org.junit.Test;


public class JCalcTest {

	@Test
	public void test() {
		   assertEquals("", 840, Calculate.housePayment(56000),0.0000005);
		   assertEquals("", 1380, Calculate.debts(56000, 300),0.00005);
		   assertEquals("", 840, Calculate.maxSpend(Calculate.housePayment(56000),Calculate.debts(56000, 300)), 0.000005);
		   assertEquals("", 30066028.34, Calculate.mortgagePermitted(600,50000,0.1,25),0.005);

	
	}

}
