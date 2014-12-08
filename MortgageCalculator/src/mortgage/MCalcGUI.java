package mortgage;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class MCalcGUI{

	public JFrame frame;
	public JTextField grossInc;
	public JTextField totDbt;
	public JTextField intRte;
	public JTextField dwnPymt;
	public JTextField afrdAble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MCalcGUI window = new MCalcGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MCalcGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 350, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel GrossIncome = new JLabel("Total Gross Income");
		GrossIncome.setBounds(10, 25, 135, 14);
		frame.getContentPane().add(GrossIncome);
		
		JLabel MonthlyDebt = new JLabel("Total Monthly Debt");
		MonthlyDebt.setBounds(10, 55, 135, 14);
		frame.getContentPane().add(MonthlyDebt);
		
		JLabel InterestRate = new JLabel("Interest Rate");
		InterestRate.setBounds(10, 85, 135, 25);
		frame.getContentPane().add(InterestRate);
		
		JLabel Term = new JLabel("Term");
		Term.setBounds(10, 175, 145, 14);
		frame.getContentPane().add(Term);
		
		grossInc = new JTextField();
		grossInc.setBounds(215, 25, 111, 25);
		frame.getContentPane().add(grossInc);
		grossInc.setColumns(2);
		
		totDbt = new JTextField();
		totDbt.setBounds(215, 55, 111, 25);
		frame.getContentPane().add(totDbt);
		totDbt.setColumns(2);
		
		intRte = new JTextField();
		intRte.setBounds(215, 85, 111, 25);
		frame.getContentPane().add(intRte);
		intRte.setColumns(2);
		dwnPymt = new JTextField();
		dwnPymt.setText("0");
		dwnPymt.setBounds(215, 115, 111, 25);
		frame.getContentPane().add(dwnPymt);
		dwnPymt.setColumns(2);
		
	    final JTextField afrdAble = new JTextField();
		afrdAble.setBounds(215, 145, 111, 25);
		frame.getContentPane().add(afrdAble);
		afrdAble.setColumns(2);
		afrdAble.setEditable(false);
			

		ArrayList<Integer> Term1 = new ArrayList<Integer>();
		Term1.add(10);
		Term1.add(15);
		Term1.add(20);
		Term1.add(30);
		Term1.add(35);
		final JComboBox<Object> nw = new JComboBox<Object>(Term1.toArray());
		nw.setBounds(215, 175, 111, 25);
		frame.getContentPane().add(nw);
		 nw.addActionListener(new java.awt.event.ActionListener(){


			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Integer Term1 = (Integer)nw.getSelectedItem();
				String grosIncome = grossInc.getText();
				String monthDebt = totDbt.getText();
				String intRte1 = intRte.getText();
				String downPmt = dwnPymt.getText();
				Integer grossIncome = Integer.parseInt(grosIncome);
				Integer monthlyDebt = Integer.parseInt(monthDebt);
				Double intr = Double.parseDouble(intRte1);
				Integer dwnPmt = Integer.parseInt(downPmt);
				double eighteen_percent = Calculate.housePayment(grossIncome);
				double thirtysix = Calculate.debts(grossIncome, monthlyDebt);
		        double pmtAllowed = Calculate.maxSpend(eighteen_percent, thirtysix);
		        Double mortgage = Calculate.mortgagePermitted(pmtAllowed, dwnPmt,intr, Term1);
		        DecimalFormat format = new DecimalFormat("#0.00");
		        String mrg = format.format(mortgage);
		        afrdAble.setText(mrg);
			}});
		 
		JLabel downPayment = new JLabel("Down Payment");
		downPayment.setBounds(10, 115, 135, 25);
		frame.getContentPane().add(downPayment);
		
		
		JLabel affordableHousePrice = new JLabel("Affordable House Price");
		affordableHousePrice.setBounds(10, 145, 155, 25);
		frame.getContentPane().add(affordableHousePrice);
	}


		}
