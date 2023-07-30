package com.market.phonecardmarket.service;

import com.market.phonecardmarket.dto.UserDTO;

import java.util.Optional;

public interface IUserService {

    Optional<UserDTO> findById(int id);
    UserDTO insert(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO loginUser(UserDTO userDTO);
    boolean checkEmailExists(String email);
}
