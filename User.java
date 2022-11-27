package banktransaction;
public class User {
	private long account_num;
	private double balance;
	private String name;
	private int pin;
	public User(long account_num,String name,int pin,long balance)
	{
		this.account_num=account_num;
		this.balance=balance;
		this.name = name;
		this.pin = pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccount_num() {
		return account_num;
	}
	public double getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}
	public int getPin() {
		return pin;
	}
	
	
}
