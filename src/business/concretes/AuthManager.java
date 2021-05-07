package business.concretes;

import business.abstracts.UserService;
import core.abstracts.AuthService;
import entities.concretes.User;

public class AuthManager implements UserService{
	
	private  AuthService authService;
	
	public AuthManager(AuthService authService) {
		this.authService=authService;
	}

	@Override
	public void register(User user) {

		authService.register(user);
	}

	@Override
	public void login(User user) {

		authService.login(user);
	}

	@Override
	public void delete(User user) {

		
	}

	@Override
	public User getByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

}
