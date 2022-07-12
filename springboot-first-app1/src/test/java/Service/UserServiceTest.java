package Service;


import com.example.demo.entity.Users;
import com.example.demo.model.request.UserAddRequest;
import com.example.demo.model.request.UserEditRequest;
import com.example.demo.model.response.UserAddResponse;
import com.example.demo.model.response.UserListResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceimpl;
import org.apache.tomcat.jni.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceimpl userServiceimpl;

    @Mock
    private UserRepository userRepository;


    @Test
    public void testAddNewUser() {
        UserAddRequest request = new UserAddRequest();
        request.setUserName("Test");
        request.setGender("Test");
        request.setEmail("Test");
        request.setPhoneNumber("Test");
        request.setStatus("Test");

        when(userRepository.save(any())).thenReturn(new User());

        UserAddResponse response = new UserAddResponse();
        response.setUserName("Test");
        response.setGender("Test");
        response.setEmail("Test");
        response.setPhoneNumber("Test");
        response.setStatus("Test");

        assertEquals(response, userServiceimpl.addNewUser(request));
    }

    @Test
    public void testGetListUsers() {
        Users user = new Users();
        user.setUserName("test");
        user.setStatus("test");
        user.setEmail("test");
        user.setPassword("test");
        user.setPhoneNumber("test");

        List<Users> listUsers = new ArrayList<>();
        listUsers.add(user);

        when(userRepository.findAll()).thenReturn(listUsers);
        int actual = userServiceimpl.getListUsers().size();
        assertEquals(1, actual);


    }

    @Test
    public void testEditUserNoDataFound() {
        UserEditRequest request = new UserEditRequest();
        request.setUserName("Test");
        request.setEmail("Test2");
        request.setEmail("Test2");

        when(userRepository.findById(anyString())).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> userServiceimpl.editUser(request));
    }

    @Test
    public void testEditUserHasData() {
        UserEditRequest request = new UserEditRequest();
        request.setUserName("Test");
        request.setEmail("Test2");
        request.setEmail("Test2");

        Users users = new Users();
        users.setUserName("Test");
        users.setStatus("Test");
        users.setEmail("Test2");
        users.setPassword("Test");
        users.setPhoneNumber("Test2");
        when(userRepository.findById(anyString())).thenReturn(Optional.of(users));
        when(userRepository.save(any())).thenReturn(new Users());

        assertDoesNotThrow(() -> userServiceimpl.editUser(request));


    }
}
