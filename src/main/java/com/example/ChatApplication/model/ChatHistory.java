package com.example.ChatApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_chat_history")
public class ChatHistory {

    @Id
    @Column(name="chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;
    @JoinColumn(name="to_user_id")
    @ManyToOne
    private User sender;
    @JoinColumn(name="from_user_id")
    @ManyToOne
    private User receiver;
    private String message;

    private Timestamp createdDate;

    private Timestamp updatedDate;
    @JoinColumn(name="status_id")
    @ManyToOne
    private Status statusId;
}
