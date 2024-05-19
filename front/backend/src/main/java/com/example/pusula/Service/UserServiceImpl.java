package com.example.pusula.Service;


import com.example.pusula.DTO.UserDTO;
import com.example.pusula.Entity.User;
import com.example.pusula.Entity.Role;
import com.example.pusula.Repository.RoleDAO;
import com.example.pusula.Repository.UserDAO;
import com.example.pusula.Repository.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;
    private RoleDAO roleDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO,RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }


    @Override
    public UserDTO findById(int id) {
        User user = userDAO.findById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    @Override
    public void save(UserDTO userDTO,int roleID) {
        User user = new User();
        Role role = roleDAO.findById(roleID);
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(role);
        userDAO.save(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);

    }

    @Override
    public void setRole(User user) {
        Role role = roleDAO.findById(2);
        user.setRole(role);
    }
}
