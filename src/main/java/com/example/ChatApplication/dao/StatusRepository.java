package com.example.ChatApplication.dao;

import com.example.ChatApplication.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
