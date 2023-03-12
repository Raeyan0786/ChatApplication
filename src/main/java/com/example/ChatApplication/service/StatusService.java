package com.example.ChatApplication.service;

import com.example.ChatApplication.dao.StatusRepository;
import com.example.ChatApplication.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    StatusRepository respository;
    public int saveStatus(Status status)
    {
        Status statusobj=respository.save(status);
        return statusobj.getStatusId();
    }
}
