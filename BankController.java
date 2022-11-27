package banktransaction;
import java.util.*;
import java.text.*;
public class BankController {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);//for input support
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");//Date-time format
		Date date = new Date();//system date time
		ArrayList<User> table = new ArrayList<User>();//storing user objects
		try
		{
			table.add(new User(625029150,"Venkatasai Kanchi",3401,2000));
			table.add(new User(625029151,"Yamuna Kanchi",3402,20000));
			table.add(new User(625029152,"Rajeev Yadav",3403,3000));
			table.add(new User(625029153,"Nithish katkuri",3404,30000));
			table.add(new User(625029154,"Raviteja Katkuri",3405,4000));
			table.add(new User(625029155,"Yamini kante",3406,40000));
			table.add(new User(625029156,"Raju patel",3407,5000));
			table.add(new User(625029157,"Sathish Nayak",3408,50000));
			table.add(new User(625029158,"Anjan Kumar",3409,6000));
			table.add(new User(625029159,"Manideep Paloji",3410,60000));
			table.add(new User(625029160,"Dinesh Patel",3411,7000));
			table.add(new User(625029161,"Ravi varma",3412,70000));
			table.add(new User(625029162,"Naveen patel",3413,8000));
			table.add(new User(625029163,"Raju nambiyar",3414,80000));
			table.add(new User(625029164,"Sukanya shetty",3415,9000));
			table.add(new User(625029165,"Srinidhi shetty",3416,90000));
			table.add(new User(625029166,"Allu Arjun",3417,1000));
			table.add(new User(625029167,"Allu Sneha",3418,10000));
			table.add(new User(625029168,"Allu Bobby",3419,12000));
			table.add(new User(625029169,"Allu Sirish",3420,120000));
			table.add(new User(625029170,"Rashmika Mandanna",3421,132000));
			table.add(new User(625029171,"Rashi Khanna",3422,13200));
			table.add(new User(625029172,"Amrutha Iyer",3423,132000));
			table.add(new User(625029173,"Manisha patel",3424,142000));
			table.add(new User(625029174,"Akshay Kumar",3425,152000));
			System.out.println("       Welcome to SBI Bank OF INDIA ");
			while(true)
			{
				long acc_number;
				int found =0;
				int pin;
				int op;
				double amt; 
				User active = null;
				System.out.println("      ================================");
				System.out.println("      If New User >> Press 1 - Open New Account");
				System.out.println("      If Existing User >> Press 2 - go to Login Page");
				System.out.println("      If you want exit >> Press 3 - You'll be out from site");
				System.out.println("      =========================");
				switch(Integer.parseInt(s.nextLine()))
				{
				case 1 :
					System.out.println("    >> SIGN UP <<   ");
					System.out.println("***Don't use space or special characters in Username***");
					System.out.println("Enter First Name : ");
					String f_name = s.nextLine();
					System.out.println("Enter Last Name : ");
					String l_name = s.nextLine();
					String name = f_name+" "+l_name;
					int random_acc = (int)(Math.random()*(625029175+100000000));
					int random_pin = (int)(Math.random()*(9999-1000+1)+1000);
					table.add(new User(random_acc,name,random_pin,0));
					System.out.println(">>New Account Created Successfully<<\n Name : "+name);
					System.out.println("User Id : " +random_acc);
					System.out.println("Pin No  : "+random_pin);
					System.out.println("Login with your credentials to perform operations on account...");
					break;
				case 2:
					System.out.println("    >>LOGIN<<");
					System.out.println("Enter Account Number ");
					acc_number = Long.parseLong(s.nextLine());
					//Iterate through the database to find the User
					Iterator it = table.iterator();
					while(it.hasNext())
					{
						User us = (User)it.next();
						if(us.getAccount_num()==acc_number)
						{
							found=1;
							System.out.println("Enter Pin : ");
							pin = s.nextInt();
							if(us.getPin()==pin)
							{
								active = us;//active user
								System.out.println("\n <Successfully Logged int at "+df.format(date)+">\n");
								System.out.println("\n **Welcome "+ active.getName() +"**");
								found=2;
								break;
							}//end of if
						}//end of if
					}//end of loop
					if(found==0)
					{
						System.out.println("\n !!INVALID ACCOUNT NUMBER !!");
						System.out.println("!PLEASE TRY AGAIN LATER !");
						System.out.println("\n <Session ended at"+df.format(date)+ ">");
						System.exit(0);
					}
					if(found==1)
					{
						System.out.println("\n !!INVALID PIN !!");
						System.out.println("!PLEASE TRY AGAIN LATER !");
						System.out.println("\n <Session ended at"+df.format(date)+ ">");
						System.exit(0);
					}
					while(true)
					{
						System.out.println("\n-------------------");
						System.out.println("SELECT OPERATION : \n1.Update Pin\n2.Balance Enquiry\n3.Withdraw Money\n4.Deposit Money\n5.Logout");
						System.out.println("\n-------------------");
						switch(s.nextInt())
						{
						case 1:
							System.out.println("Enter Old Pin : ");
							op=s.nextInt();
							if(op==active.getPin())
							{
								System.out.println("Enter New Pin : ");
								active.setPin(s.nextInt());
								System.out.println(">> PIN UPDATED SUCCESSFULLY <<");
							}
							else
							{
								System.out.println("\n  !!INVALID PIN!!");
							}
							break;
						case 2:
							System.out.println("AVAILABLE BALANCE = Rs. "+active.getBalance());
							break;
						case 3:
							System.out.println("Enter Amount to be withdrawn : Rs."+"**Enter Only multiples of 100");
							amt = s.nextDouble();
							if(amt>0 && amt%100==0)
							{
								if(amt<active.getBalance() && amt<25000)
								{
									active.setBalance(active.getBalance()-amt);
									System.out.println("AVAILABLE BALANCE = Rs."+active.getBalance());
								}
								else
								{
									System.out.println("   !!INSUFFICIENT BALANCE!!");
								}
							}
							else
							{
								System.out.println("!!INVALID AMOUNT!!");
								break;
							}
							break;
						case 4:
							System.out.println("Enter Amount to be deposited : Rs."+"**Enter Only multiples of 100");
							amt = s.nextDouble();
							if(amt>0 && amt%100==0)
							{
								if(amt>100000)
								{
									System.out.println("Your amount exceeds limit..");
									System.out.println("Maximum depositing amoutn at once = Rs.100000");
								}
								else
								{
								   active.setBalance(active.getBalance()+amt);
								   System.out.println("AVAILABLE BALANCE = Rs."+active.getBalance());
								}
							}//end of if
							else
							{
								System.out.println("!!INVALID AMOUNT!!");
								break;	
							}
							break;
						case 5:
							System.out.println("\nThanks for using SBI, visit again...");
							System.out.println("Session ended at :"+df.format(date));
							System.exit(0);
						default:
							System.out.println("!!WRONG CHOICE!!Press between 1 to 5 ");	
						}//end of switch
					}//end of loop
				case 3:
					System.out.println("Thanks for using SBI, visit again...");
					System.exit(0);
				default:
					System.out.println("!!WRONG CHOICE!!Press between 1 or 2 ");
				}//end of switch	
			}//end of loop
		}//end of try
		catch(Exception e)
		{
			System.out.println("     !!WARNING!!  Please use correct input format");
			System.out.println("\nSession ended at :"+df.format(date));
		}
		finally {s.close();}
	}
}
