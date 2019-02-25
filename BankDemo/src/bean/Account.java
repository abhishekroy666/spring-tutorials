package bean;

public class Account {
	private int accno;
	private String name;
	private float amount;
	private String userName;
	private String passWord;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accno, String name, float amount,String userName, String passWord) 
	{
		super();
		this.accno = accno;
		this.name = name;
		this.amount = amount;
		this.userName = userName;
		this.passWord = passWord;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", username=" + userName +", name=" + name + ", amount="
				+ amount + "]";
	}
}
