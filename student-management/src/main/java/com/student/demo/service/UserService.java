package com.student.demo.service;

import com.student.demo.model.request.UserAddRequest;
import com.student.demo.model.request.UserEditRequest;
import com.student.demo.model.response.UserAddResponse;
import com.student.demo.model.response.UserAnswerResponse;
import com.student.demo.model.response.UserDeleteResponse;
import com.student.demo.model.response.UserListResponse;


import java.util.List;

public interface UserService {
    UserAddResponse addNewUser(UserAddRequest request);
    List<UserListResponse> getListUsers();
    boolean editStudent(UserEditRequest request);

    UserAnswerResponse getStudentbyId(Integer Id);

    UserDeleteResponse deleteStudentById (Integer Id);

}

