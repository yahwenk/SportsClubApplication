package nus.iss.team2.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.team2.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT u FROM User u WHERE u.userID=:un AND u.password=:pwd")
	User findUserByIdPwd(@Param("un") String userID, @Param("pwd") String pwd);

}
