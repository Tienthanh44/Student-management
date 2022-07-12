package com.example.demo.controller;

import com.example.demo.model.request.UserAddRequest;
import com.example.demo.model.request.UserEditRequest;
import com.example.demo.model.response.UserAddResponse;
import com.example.demo.model.response.UserItemResponse;
import com.example.demo.model.response.UserListResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shop/v1/user")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserAddResponse> addUser(@RequestBody UserAddRequest request){

        UserAddResponse response = userService.addNewUser(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/edit")
    public ResponseEntity<Void> editUser(@RequestBody UserEditRequest request){
        boolean result = userService.editUser(request);
        if(result){
            ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete/{username}")
     ResponseEntity<Void> deleteUser(@PathVariable String userName){
            userService.deleteUser(userName);
            return ResponseEntity.ok().build();
     }
    @GetMapping("/list")
    public ResponseEntity<List<UserListResponse>> getListUsers(){
        List<UserListResponse> response = userService.getListUsers();
        return ResponseEntity.ok(response);
    }


}
