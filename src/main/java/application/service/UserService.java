package application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import application.model.Utilisateur;
import application.repository.UserRepository;


@Service
@Primary
public class UserService implements ICrudService<Utilisateur, String>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Utilisateur> getAll() {
		return userRepository.findAll();
	}
	@Override
	public Utilisateur add(Utilisateur user) {
		return userRepository.save(user);
	}

	@Override
	public void update(Utilisateur user) {
		userRepository.save(user);
	}

	@Override
	public void saveAll(Iterable<Utilisateur> iterable) {
		userRepository.saveAll(iterable);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Utilisateur> getOneUser(String username) {
		return userRepository.findById(username) ; 
	
	}
	
	@Override
	public List<Utilisateur> getUsersByDept(String codeDept) {
		return userRepository.findUserByDept(codeDept);
	}

	public Utilisateur getNomPrenom(String cin) {
		// TODO Auto-generated method stub
		return userRepository.getNomPrenom(cin);
	}


	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	public void checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			System.out.println("The password matches.");
		else
			System.out.println("The password does not match.");
	}

}
