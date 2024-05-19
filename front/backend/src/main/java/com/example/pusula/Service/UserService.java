package com.example.pusula.Service;

import com.example.pusula.DTO.UserDTO;
import com.example.pusula.Entity.User;

public interface UserService {

    UserDTO findById(int id);
    void save(UserDTO user,int roleID);
    void delete(User user);
    void setRole(User user);

}
