package com.example.demo.service.impl;

import com.example.demo.entity.Users;
import com.example.demo.model.request.UserAddRequest;
import com.example.demo.model.request.UserEditRequest;
import com.example.demo.model.response.UserAddResponse;
import com.example.demo.model.response.UserListResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;



    @Override
    public UserAddResponse addNewUser(UserAddRequest request) {
        Users users = new Users();
        users.setUserName(request.getUserName());
        users.setPassword(request.getPassword());
        users.setSex(request.getGender());
        users.setPhoneNumber(request.getPhoneNumber());
        users.setEmail(request.getEmail());
        users.setStatus(request.getStatus());
        users.setCreatedBy(request.getUserName());
        users.setCreatedDate(new Date());

        // save database
        userRepository.save(users);

        // khoi tao response
        UserAddResponse response = new UserAddResponse();
        response.setUserName(request.getUserName());
        response.setEmail(request.getEmail());
        response.setGender(request.getGender());
        response.setPhoneNumber(request.getPhoneNumber());
        response.setStatus(request.getStatus());
        return response;
    }

    @Override
    public List<UserListResponse> getListUsers() {
        List<Users> listUsers = userRepository.findAll();
        List<UserListResponse> response = listUsers.stream()
                .map(user -> {
                    UserListResponse item = new UserListResponse();
                    item.setUserName(user.getUserName());
                    item.setGender(user.getSex());
                    item.setPhoneNumber(user.getEmail());
                    item.setStatus(user.getStatus());
                    item.setEmail(user.getEmail());

                    return item;

                }).collect(Collectors.toList());
        return response;
    }

    @Override
    public boolean editUser(UserEditRequest request) {
        //tim kiem xem ton tai hay khong
        Optional<Users> user = userRepository.findById(request.getUserName());
        if (user.isPresent()) {
            Users newUsers = user.get();
            newUsers.setPhoneNumber(request.getPhoneNumber());
            newUsers.setEmail(request.getEmail());
            userRepository.save(newUsers);
            return true;
        }
            return false;
    }

    // impl: Implement

    @Override
    public  void deleteUser (String userName) {
        userRepository.deleteById(userName);
    }


}
