import java.util.ArrayList;
import java.util.Scanner;

import GoogleAuth.GoogleAuthManager;
import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.concretes.GoogleAuthManagerAdapter;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Yapmak istediginiz islemi seciniz");
		System.out.println("1-Giris\n2-Kayit");
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
		if (select == 1) {
			System.out.println("Giris Yontemi Seciniz : ");
			System.out.println("1-Mail ve Sifre \n2-Google");
			Scanner sc = new Scanner(System.in);

			int select2 = sc.nextInt();
			if (select2 == 1) {
				User user = new User();
				user.setEmail("yigitc@gmail.com");
				user.setPassword("123456");

				ArrayList<User> users = new ArrayList<>();
				UserManager userManager = new UserManager(new InMemoryUserDao(users));
				userManager.login(user);

			}

			else if (select2 == 2) {
				User user = new User();
				user.setEmail("yigitc@gmail.com");
				user.setPassword("123456");

				AuthManager authManager=new AuthManager(new GoogleAuthManagerAdapter(new GoogleAuthManager()));
				authManager.login(user);

			}
		} else if (select == 2) {
			System.out.println("Kayit Yontemi Seciniz : ");
			System.out.println("1-Mail ve Sifre \n2-Google");
			Scanner sc = new Scanner(System.in);
			int select2 = sc.nextInt();
			if (select2 == 1) {
				ArrayList<User> users = new ArrayList<>();
				UserManager userManager = new UserManager(new InMemoryUserDao(users));
				User user = new User(1, "Yiğit", "Ç", "yigitc@gmail.com", "123456");
				userManager.register(user);
			}

			else if (select2 == 2) {
				User user = new User();
				user.setEmail("yigitc@gmail.com");
				user.setPassword("123456");

				AuthManager authManager=new AuthManager(new GoogleAuthManagerAdapter(new GoogleAuthManager()));
				authManager.register(user);

			}
		}

	}

}
