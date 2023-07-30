package com.market.phonecardmarket.mapper;

import com.market.phonecardmarket.dto.UserDTO;
import com.market.phonecardmarket.entity.User;
import com.market.phonecardmarket.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {

    @Autowired
    private IRoleRepository roleRepository;

    //Convert User entity to User dto
    public UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setBalance(user.getBalance());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRole().getName());
        userDTO.setStage(user.getStage());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());

        return userDTO;
    }

    //Convert User dto to User entity
    public User dtoToEntity(UserDTO userDTO) {
        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setBalance(userDTO.getBalance());
        user.setAvatar(userDTO.getAvatar());
        user.setPhone(userDTO.getPhone());
        user.setRole(roleRepository.findByName(userDTO.getRole()));
        user.setStage(userDTO.getStage());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUpdatedAt(userDTO.getUpdatedAt());

        return user;
    }
}
