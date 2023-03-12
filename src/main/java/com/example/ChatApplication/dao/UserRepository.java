package com.example.ChatApplication.dao;

import com.example.ChatApplication.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
//    public Users findByFirstName(String name);
//
//    public Users findByStatusID(Status status);
    @Query(value = "select * from tbl_user where username= :userName and status_id=1",nativeQuery = true)
    public List<User> findFirstName(String userName);
    @Query(value = "select * from tbl_user where user_id= :userId and status_id=1",nativeQuery = true)
    public List<User> getUserByUserId(int userId);

    @Query(value="select * from tbl_user where username=:username and status_id=1",nativeQuery = true)
    public List<User> findUserName(String username);

//    @Query(value = "select * from tbl_user where status_id = 1", nativeQuery = true)
//    public List<User> getAllUsers();

    @Query(value="select * from tbl_user where status_id=1", nativeQuery=true)
    @Override
    public List<User> findAll();
    @Modifying
    @Transactional
    @Query(value="update tbl_user set status_id=2 where user_id=:userId",countQuery = "select count(*) from tbl_user",nativeQuery=true)
    public void deleteUserByUserId(int userId);
}
