package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Tạo getter và setter
@AllArgsConstructor // Tạo constructor của toàn bộ thuộc tính
@NoArgsConstructor // Tạo constructor rỗng
public class UserListResponse {
    private String userName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String status;
}
