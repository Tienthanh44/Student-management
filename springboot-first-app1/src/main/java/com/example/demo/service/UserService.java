package com.example.demo.service;

import com.example.demo.model.request.UserAddRequest;
import com.example.demo.model.request.UserEditRequest;
import com.example.demo.model.response.UserAddResponse;
import com.example.demo.model.response.UserListResponse;

import java.util.List;

public interface UserService {
    UserAddResponse addNewUser(UserAddRequest request);
    List<UserListResponse> getListUsers();
    boolean editUser(UserEditRequest request);

    void deleteUser (String userName);

}
