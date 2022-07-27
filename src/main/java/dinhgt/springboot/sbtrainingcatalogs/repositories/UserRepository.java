package dinhgt.springboot.sbtrainingcatalogs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dinhgt.springboot.sbtrainingcatalogs.model.Account;

public interface UserRepository extends JpaRepository<Account, Integer> {
	Optional<Account> findByEmailAndIsActived(String email, boolean isActivated);
}
