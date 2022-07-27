package dinhgt.springboot.sbtrainingcatalogs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingcatalogs.model.Account;
import dinhgt.springboot.sbtrainingcatalogs.model.UserDetailsImpl;
import dinhgt.springboot.sbtrainingcatalogs.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmailAndIsActived(username, true).get();
		System.err.println(account.getEmail());
		return UserDetailsImpl.build(account);
	}

}
