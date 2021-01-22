package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private List<Employee> result;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		if (email == null || "".equals(email)) {
			throw new UsernameNotFoundException("Username is empty");
		}

		Employee user = repository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found: " + email);
		}

		return user;
	}

	// adminを登録するメソッド
		@Transactional
		public void registerAdmin(String username, String password, String email, Date birthday, int sex, String department, String telephone_number,
				   String address, Date join_date, Date updated_at, Date deleted_at) {
			Employee user = new Employee(username, passwordEncoder.encode(password), email, birthday, sex, department, telephone_number,
										address, join_date, updated_at, deleted_at);
			user.setAdmin(true);
			repository.save(user);
		}

	public List<Employee> findAllList() {
		result = repository.findAll();
		return result;
	}

}