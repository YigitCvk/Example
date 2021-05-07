package GoogleAuth;

import entities.concretes.User;

public class GoogleAuthManager {
	public void register(User user){
        System.out.println("Google ile kayit olundu : " + user.getEmail());
    }

   public void login(User user){
       System.out.println("Google ile giris yapildi : " + user.getEmail());
   }
}
