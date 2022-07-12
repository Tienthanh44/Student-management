package controller;

import com.example.demo.controller.UserController;
import com.example.demo.model.request.UserAddRequest;
import com.example.demo.model.request.UserEditRequest;
import com.example.demo.model.response.UserAddResponse;
import com.example.demo.model.response.UserListResponse;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup (new UserController(userService)).build();

    }

    @Test
    public void testAddUser() throws Exception {
        UserAddRequest request = new UserAddRequest();
        request.setUserName("test");
        request.setGender("test");
        request.setEmail("test");
        request.setPhoneNumber("test");
        request.setStatus("test");

        UserAddResponse response = new UserAddResponse();
        response.setUserName("test");
        response.setGender("test");
        response.setEmail("test");
        response.setPhoneNumber("test");
        response.setStatus("test");

        when(userService.addNewUser(any())).thenReturn(response);

        mockMvc.perform(post("/shop/v1/user/add")
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());

        verify(userService).addNewUser(request);

    }

    @Test
    public void testGetListUsers() throws Exception {
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setUserName("test");
        userListResponse.setStatus("test");
        userListResponse.setEmail("test");
        userListResponse.setGender("test");
        userListResponse.setPhoneNumber("test");

        List<UserListResponse> response = new ArrayList<>();
        response.add(userListResponse);

        when(userService.getListUsers()).thenReturn(response);

        mockMvc.perform(get("/shop/v1/user/list")
                        .header(CONTENT_TYPE, MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

        verify(userService).getListUsers();


    }
    
    @Test
    public void testEditUserBadRequest() throws Exception {
        UserEditRequest request = new UserEditRequest();
        request.setUserName("test");
        request.setEmail("test");
        request.setEmail("test");

        when(userService.editUser(any())).thenReturn(false);


        mockMvc.perform(post("/shop/v1/user/edit")
                        .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verify(userService).editUser(request);

    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/shop/v1/user/delete")
                        .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());


    }




}
