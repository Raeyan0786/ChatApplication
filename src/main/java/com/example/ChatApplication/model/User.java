package com.example.ChatApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
//import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="gender")
    private String gender;
    @Column(name="first_name")
    private String FirstName;
    @Column(name="last_name")
    private String LastName;
    @Column(name="age")
    private Integer age;
    @Column(name="create_date")
    private Timestamp createdDate;
    @Column(name="update_date")
    private Timestamp updatedDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;


}
