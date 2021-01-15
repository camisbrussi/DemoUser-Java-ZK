package controller;



import java.util.LinkedList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import model.User;
import service.UserServiceImpl;
import service.UserService;

public class UserController extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	@Wire
	private Textbox keywordBox;
	@Wire
	private Listbox userListbox;
        @Wire
	private Textbox userName;
        @Wire
	private Textbox userEmail;
	@Wire
	private Label nameLabel;
	@Wire
	private Label emailLabel;
	
	private UserService userService = new UserServiceImpl();
	
	@Listen("onClick = #searchButton")
	public void search(){
		String keyword = keywordBox.getValue();
		List<User> result = userService.search(keyword);
		userListbox.setModel(new ListModelList<User>(result));
	}
        
        @Listen("onClick = #addButton")
	public void add(){
		String name = userName.getValue();
                String email = userEmail.getValue();
                

		
                User newUser = userService.addUser(name, email);
                
                List<User> userList= new LinkedList<User>();
                userList.add(newUser);
                
		userListbox.setModel(new ListModelList<User>(userList));
                
	}
}
