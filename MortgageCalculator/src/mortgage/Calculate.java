package mortgage;
public class Calculate {
	
	public static double housePayment(double GrossIncome){
		double hsepmt = (GrossIncome/12)*0.18;
		return hsepmt;
	
	}

	public static double debts(double GrossIncome, double monthlyDebt){
		double payment = ((GrossIncome/12)*0.36)-monthlyDebt;
		return payment;
		
	}
	
	public static double maxSpend(double payment, double hsepmt){
		if(payment<hsepmt){
			return payment;
			
		}
		else{
			return hsepmt;
		}
	}
	public static double mortgagePermitted(double can_Payment, double downPayment, double rate, int term){
		int month = term*12;
		double monthlyrate = rate/12;
		double monthlyrate1 = Math.pow(1+monthlyrate, month);
		double max_mort = (can_Payment)*(((1-(1/monthlyrate1))/monthlyrate)+downPayment);
		
		return max_mort;

	}
}
