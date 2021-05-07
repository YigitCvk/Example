package business.concretes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;



public class UserManager implements UserService {

	private UserDao userDao;
	
    public UserManager(UserDao userDao) {
		this.userDao=userDao;		
	}
	
	@Override
	public void register(User user) {

		if (user.getPassword().length()<6) {
			System.out.println("Şifreniz 6 karakterden Uzun olmalıdır : ");
			return;
		}
		String regex="^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			System.out.println("Mail adresi(example@example.com) formatinda olmalıdır.");
			return;
		}
		if (userDao.getByMail(user.getEmail())!=null) {
			System.out.println("Kullanıcı zaten var");
		    return;
		}
		Scanner scanner=new Scanner(System.in);
		System.out.println("Gönderilen epostayi doğrulamak için 1 e basın : ");
		int selection=scanner.nextInt();
		if (selection!=1) {
			System.out.println("Doğrulama başarısız.");
			return;
		}
		userDao.register(user);
	}

	@Override
	public void login(User user) {
		if (user.getEmail()==null||user.getPassword()==null) {
			System.out.println("Zorunlu Alanları doldurun :");
			return;
		}
		else if (userDao.getByMail(user.getEmail())==null) {
			System.out.println("Kullanıcı bulunamadı");
		}
		
		userDao.login(user);
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	@Override
	public User getByMail(String mail) {
		// TODO Auto-generated method stub
		return userDao.getByMail(mail);
	}

}
