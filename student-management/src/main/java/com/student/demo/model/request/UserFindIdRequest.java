package com.student.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data // Tạo getter và setter
@AllArgsConstructor // Tạo constructor của toàn bộ thuộc tính
@NoArgsConstructor // Tạo constructor rỗng
public class UserFindIdRequest {
    private int id;
}