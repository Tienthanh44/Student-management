package com.student.demo.controller;

import com.student.demo.model.request.UserAddRequest;
import com.student.demo.model.request.UserEditRequest;
import com.student.demo.model.response.UserAddResponse;
import com.student.demo.model.response.UserAnswerResponse;
import com.student.demo.model.response.UserDeleteResponse;
import com.student.demo.model.response.UserListResponse;
import com.student.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shop/v1/student")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserAddResponse> addUser(@RequestBody UserAddRequest request) {

        UserAddResponse response = userService.addNewUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserListResponse>> getListUsers(){
        List<UserListResponse> response = userService.getListUsers();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/edit")
    public ResponseEntity<Void> editStudent(@RequestBody UserEditRequest request){
        boolean result = userService.editStudent(request);
        if(result){
            ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/student/v2")
    public  ResponseEntity<UserAnswerResponse> getStudent(@PathVariable Integer Id){
        UserAnswerResponse result = userService.getStudentbyId(Id);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserDeleteResponse> deleteStudent(@PathVariable Integer Id){
        UserDeleteResponse answer = userService.deleteStudentById(Id);
        return ResponseEntity.ok(answer);
    }

}
