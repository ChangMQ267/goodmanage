package net.hunau.goodsmanager.biz;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDAO;
import net.hunau.goodsmanager.exception.UserAuthException;

public class UserBiz {
	
	private UserDAO ud;
	public UserBiz(){
		ud = new UserDAO();
	}

	public User login(User user) throws UserAuthException{
		User tempUser = ud.getUser(user.getUsername(), user.getPassword());
			
		if(tempUser != null){
			return user;
		}else{
			throw new UserAuthException("用户名或密码错误！");
		}
	}
	public void iscancelUser(String userName,int flag){
		
		User user = ud.getUser(userName);
		if(user != null){
			user.setValidateFlag(flag);
			ud.updateUserFlag(user);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBiz ub = new UserBiz();
		User user = new User();
		user.setUsername("peter");
		user.setPassword("123456");
		try {
			user = ub.login(user);
			System.out.println(user);
		} catch (UserAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
