package service;

import java.util.Date;
import java.util.List;
import model.User;

public interface UserService {

	/**
	 * Retrieve all cars in the catalog.
	 * @return all cars
	 */
	public List<User> findAll();
	
	/**
	 * search cars according to keyword in name and company.
	 * @param keyword for search
	 * @return list of car that match the keyword
	 */
	public List<User> search(String keyword);
        
        
        public User addUser(String name, String email);
}
