package WikangWali.SigninSignup.Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import WikangWali.SigninSignup.Entity.UserEntity;
import WikangWali.SigninSignup.Repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository urepo;
	
	@Autowired
    public UserService(UserRepository urepo) {
		this.urepo = urepo;
	}
	
	// Create (C)
	public UserEntity insertUser(UserEntity user) {
		return urepo.save(user);
	}
	
	//Read (R)
	public List<UserEntity> getAllUser() {
		return urepo.findAll();
	}
	
	//Update - update a user 
	@SuppressWarnings("finally")
	public UserEntity updateuser(int sid, UserEntity newUserDetails) {
		UserEntity user = new UserEntity();
		try {
			//1 Search the id of the user that will be update
			user = urepo.findById(sid).get();
			
			//2 Update the record	
			user.setFname(newUserDetails.getFname());
			user.setLname(newUserDetails.getLname());
			user.setEmail(newUserDetails.getEmail());
			user.setPassword(newUserDetails.getPassword());
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException ("Student " + sid + " does not exist!");
			
		}finally {
			return urepo.save(user);
		}
	}
	
	//3 D - delete a user
	public String deleteUser(int sid) {
		UserEntity user = urepo.findById(sid)
			.orElseThrow(() -> new NoSuchElementException("User " + sid + "does not exist"));

		if (user.getIsDeleted()) {
			return "User #" + sid + " is already deleted!";
		} else {
			user.setIsDeleted(true);
			urepo.save(user);
			return "User #" + sid + "has been deleted";
		}
	}

}
