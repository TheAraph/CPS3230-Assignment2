package main;
import java.util.*;

public class runner {
	
	//bad login output
	public void badLogin() {
		System.out.println("Bad login at: " + System.currentTimeMillis());
	}
	
	//good login output
	public void goodLogin() {
		System.out.println("Good login at: " + System.currentTimeMillis());
	}
	
	//if is at login page output
	public void LoginPage() {
		System.out.println("In Login Page at: " + System.currentTimeMillis());
	}
	
	//if is at alert page output
	public void AlertPage() {
		System.out.println("In Alert Page at: " + System.currentTimeMillis());
	}

	public void run(final Account account) {
		final Random rand = new Random();
		// loop to show different examples
		while(true){
			//give random number from 1-10
			//if number is 7 or over mock as if logged in
			final int randomNumber = rand.nextInt(10);
			
			//flip a coin to show the possibility and transition of logging out when being logged in
			final int loggedoutcoinflip = rand.nextInt(3);
			
			if (randomNumber < 7){
				this.badLogin();
				account.setBadLogins(account.getBadLogins() + 1);
				if(account.getBadLogins() >= 3){
					account.setInLoginPage(true);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					account.setBadLogins(0);
					account.setInLoginPage(true);
					account.setLoggedOut(true);
				}
			} else {
				this.goodLogin();
				account.setBadLogins(0);
				account.setInAlertPage(true);
				account.setInLoginPage(false);
				account.setLoggedOut(false);
				
				if (loggedoutcoinflip == 2){
					account.setLoggedOut(true);
					account.setInLoginPage(true);
					account.setInAlertPage(false);
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	
	
	public static void main(String[] args) {
		final runner m = new runner();
		final Account account = m.new Account(false, false, false, 0);
		m.run(account);
	}
	
	public class Account{
		private boolean isatAlertPage;
		private boolean isatLoginPage;
		private boolean isLoggedOut;
		private Integer badLogins;
		
		public Account(final boolean isatAlertPage, final boolean isatLoginPage, final boolean isLoggedOut, final Integer badLogins) {
			super();
			this.isatAlertPage = isatAlertPage;
			this.isatLoginPage = isatLoginPage;
			this.isLoggedOut = isLoggedOut;
			this.badLogins = badLogins;
		}

		public boolean isatAlertPage() {
			return isatAlertPage;
		}
		
		public void setInAlertPage(boolean isatAlertPage) {
			if(isatAlertPage){
				System.out.println("You are currently in the Alert Page");
			} else {
				System.out.println("You are currently in the Login Page");
			}
			this.isatAlertPage = isatAlertPage;
		}
		
		public boolean isatLoginPage() {
			return isatLoginPage;
		}
		
		public void setInLoginPage(boolean isatLoginPage) {
			if(isatLoginPage){
				System.out.println("You are currently in the Login Page");
			} else {
				System.out.println("You are currently in the Alert Page");
			}
			this.isatLoginPage = isatLoginPage;
		}
		
		public boolean isLoggedOut() {
			return isLoggedOut;
		}
		
		public void setLoggedOut(boolean isLoggedOut) {
			if(isLoggedOut){
				System.out.println("You are logged out");
			}
			this.isLoggedOut = isLoggedOut;
		}

		public Integer getBadLogins() {
			return badLogins;
		}

		public void setBadLogins(Integer badLogins) {
			this.badLogins = badLogins;
		}
	}
}
