package service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.User;

public class UserServiceImpl implements UserService{

	//data model
	private List<User> userList= new LinkedList<User>();
	private int id = 1;
	//initialize book data
	public UserServiceImpl() {
		userList.add(
				new User(id++, 
						"João",
						"joao@gmail.com.br"));
		userList.add(
				new User(id++, 
						"Maria",
						"maria@gmail.com.br"));
		userList.add(
				new User(id++, 
						"Pedro",
						"pedro@gmail.com.br"));
		userList.add(
				new User(id++, 
						"Paulo",
						"paulo@interqact.com.br"));
		
	}
        
        @Override
        public User addUser(String name, String email){
            
           User user = new User(id++, name, email);
           
           userList.add(user);
				
           return user;
        }
	
	
        @Override
	public List<User> findAll(){
		return userList;
	}
	
        @Override
	public List<User> search(String keyword){
		List<User> result = new LinkedList<User>();
		if (keyword==null || "".equals(keyword)){
			result = userList;
		}else{
			for (User u: userList){
				if (u.getName().toLowerCase().contains(keyword.toLowerCase())
					){
					result.add(u);
				}
			}
		}
		return result;
	}
}
