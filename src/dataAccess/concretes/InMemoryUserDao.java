package dataAccess.concretes;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	
	private List<User> users;
	
	public InMemoryUserDao(List<User> users) {
		this.users=users;
	}

	@Override
	public void register(User user) {

		users.add(user);
		System.out.println("Kullanıcı Oluşturuldu : "+user.getEmail());
	}

	@Override
	public void login(User user) {
		System.out.println("Giriş Başarılı "+user.getEmail());
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("Kullanıcı Silindi : "+user.getEmail());
		
	}

	@Override
	public User getByMail(String mail) {
		for (User user : users) {
			if (user.getEmail().equals(mail)) {
				return user;
			}
		}
		return null;
	}

}
