package com.student.demo.service.impl;

import com.student.demo.entity.Student;
import com.student.demo.model.request.UserAddRequest;
import com.student.demo.model.request.UserEditRequest;
import com.student.demo.model.response.UserAddResponse;
import com.student.demo.model.response.UserAnswerResponse;
import com.student.demo.model.response.UserDeleteResponse;
import com.student.demo.model.response.UserListResponse;
import com.student.demo.repository.UserRepository;
import com.student.demo.service.UserService;
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
        Student student = new Student();
        student.setId(request.getId());
        student.setStudentName(request.getStudentName());
        student.setAge(request.getAge());
        student.setAddress(request.getAddress());
        student.setCreatedDate(new Date());

        userRepository.save(student);

        UserAddResponse response = new UserAddResponse();
        response.setId(request.getId());
        response.setStudentName(request.getStudentName());
        response.setAge(request.getAge());
        response.setAddress(request.getAddress());
        response.setCreatedDate(request.getCreatedDate());
        return response;
    }

    @Override
    public List<UserListResponse> getListUsers() {
        List<Student> listUsers = userRepository.findAll();
        List<UserListResponse> response = listUsers.stream()
                .map(user -> {
                    UserListResponse item = new UserListResponse();
                    item.setId(item.getId());
                    item.setStudentName(item.getStudentName());
                    item.setAge(item.getAge());
                    item.setAddress(item.getAddress());
                    item.setCreatedDate(item.getCreatedDate());

                    return item;

                }).collect(Collectors.toList());
        return response;
    }

    @Override
    public boolean editStudent(UserEditRequest request) {

        Optional<Student> student = userRepository.findById(request.getId());
        if (student.isPresent()) {
            Student newStudent = student.get();
            newStudent.setStudentName(request.getStudentName());
            newStudent.setAddress(request.getAddress());
            newStudent.setAge(request.getAge());
            userRepository.save(newStudent);
            return true;
        }
        return false;
    }

    @Override
    public UserAnswerResponse getStudentbyId (Integer Id){
        return userRepository.findById(Id).map(
            item -> {
                UserAnswerResponse response = new UserAnswerResponse();
                response.setId(item.getId());
                response.setStudentName(item.getStudentName());
                response.setAge(item.getAge());
                response.setAddress(item.getAddress());
                response.setCreatedDate(item.getCreatedDate());

                return response;
            }
        ).orElse(new UserAnswerResponse());

    }

    @Override
    public UserDeleteResponse deleteStudent (Integer Id){
        return userRepository.deleteById(Id).map(
                item -> {
                    UserAnswerResponse response = new UserAnswerResponse();

                    return response;

                }
        )
    }





}
