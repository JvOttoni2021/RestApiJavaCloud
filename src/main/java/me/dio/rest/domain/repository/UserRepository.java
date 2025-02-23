package me.dio.rest.domain.repository;

import me.dio.rest.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumberAndAccountAgency(String accountNumber, String accountAgency);
}
