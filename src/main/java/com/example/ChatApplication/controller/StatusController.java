package com.example.ChatApplication.controller;

import com.example.ChatApplication.model.Status;
import com.example.ChatApplication.service.StatusService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/status")
public class StatusController {
    @Autowired
    StatusService service;
    @PostMapping("/status")
    public ResponseEntity<String> createstatus(@RequestBody String statusData)
    {
        Status status=setStatus(statusData);
        int statusId=service.saveStatus(status);
        return new ResponseEntity<>("Status Saved- "+statusId, HttpStatus.CREATED);
    }
    private Status setStatus(String statusData)
    {
        //create new status object
        Status status=new Status();
        //statusData has data type as String but format is json, so we create data of json
        JSONObject jsonobject=new JSONObject(statusData);
        String StatusName= jsonobject.getString("statusName");
        String StatusDescription= jsonobject.getString("statusDescription");
        status.setStatusName(StatusName);
        status.setStatusDescription(StatusDescription);
        return status;
    }

}
