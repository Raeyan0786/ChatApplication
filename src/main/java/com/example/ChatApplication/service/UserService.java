package com.example.ChatApplication.service;

import com.example.ChatApplication.dao.UserRepository;
import com.example.ChatApplication.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int saveUser(User user)
    {
        User userobj=userRepository.save(user);
        return userobj.getUserId();
    }

    public JSONArray getUsers(String userId)
    {
        JSONArray response=new JSONArray();
        if(null!= userId)
        {
            List<User> usersList = userRepository.getUserByUserId(Integer.valueOf(userId));
            for (User user:usersList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }
        else{
            List<User> usersList = userRepository.findAll();
            for (User user:usersList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }
        return response;
    }
    public JSONObject login(String username,String password)
    {
        JSONObject response=new JSONObject();
        List<User> user=userRepository.findUserName((username));
        if(user.isEmpty())
        {
            response.put("errorMessage","Username doesn,t exits");
        }
        else {
            User userObj=user.get(0);
            if(password.equals(userObj.getPassword()))
            {
                response=createResponse((userObj));
            }
            else{
                response.put("errorMessage","possword is not valied");
            }
        }
        return response;
    }
    public JSONObject updateUser(User newUser, String userId)
    {
        List<User> usersList = userRepository.getUserByUserId(Integer.valueOf(userId));
        JSONObject obj = new JSONObject();
        if(usersList.isEmpty())
        {
            User oldUser=usersList.get(0);
            newUser.setUserId(oldUser.getUserId());
            newUser.setCreatedDate(oldUser.getCreatedDate());
            newUser.setPassword(oldUser.getPassword());
            Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
            newUser.setUpdatedDate(updatedTime);
            userRepository.save(newUser);
        }else {
            obj.put("errorMessage" , "User doesn't exist");
        }
        return obj;
    }

    private JSONObject createResponse(User user) {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("userId", user.getUserId());
        jsonObj.put("username", user.getUsername());
        jsonObj.put("firstName", user.getFirstName());
        jsonObj.put("lastName", user.getLastName());
        jsonObj.put("age", user.getAge());
        jsonObj.put("email", user.getEmail());
        jsonObj.put("phoneNumber", user.getPhoneNumber());
        jsonObj.put("gender", user.getGender());
        jsonObj.put("createdDate", user.getCreatedDate());

        return jsonObj;
    }
}
