package WikangWali.SigninSignup.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import WikangWali.SigninSignup.Entity.UserEntity;
import WikangWali.SigninSignup.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userv;
	
	@GetMapping("/print")
	public String printHello() {
		return "Start your journey!";
	}
	
	//Create (C)
	@PostMapping("/insertUser")
	public UserEntity insertuser(@RequestBody UserEntity user) {
		return userv.insertUser(user);
	}
	
	//Read (R)
	@GetMapping("/getAllUser")
	public List<UserEntity> getAllUser() {
		return userv.getAllUser();
	}
	
	//Update - update a user record
	@PutMapping("/updateUser")
	public UserEntity uodateUser(@RequestParam int sid, @RequestBody UserEntity newUserDetails) {
		return userv.updateuser(sid, newUserDetails);
	}
	
	//D - delete a user record
	@DeleteMapping("/deleteUser/{sid}")
	public String deleteUser(@PathVariable int sid) {
		return userv.deleteUser(sid);
	}

}
