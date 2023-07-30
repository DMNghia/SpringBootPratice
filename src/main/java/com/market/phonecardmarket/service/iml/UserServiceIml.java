package com.market.phonecardmarket.service.iml;

import com.market.phonecardmarket.dto.UserDTO;
import com.market.phonecardmarket.entity.User;
import com.market.phonecardmarket.mapper.UserMapper;
import com.market.phonecardmarket.repository.IRoleRepository;
import com.market.phonecardmarket.repository.IUserRepository;
import com.market.phonecardmarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class UserServiceIml implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper = new UserMapper();
    @Override
    public Optional<UserDTO> findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        }
        Optional<UserDTO> userDTO = user.map(new Function<User, UserDTO>() {
            @Override
            public UserDTO apply(User user) {
                return userMapper.entityToDTO(user);
            }
        });
        return userDTO;
    }

    @Override
    public UserDTO insert(UserDTO userDTO) {
        User newUser = userRepository.save(userMapper.dtoToEntity(userDTO));
        return userMapper.entityToDTO(newUser);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User updateUser = userRepository.save(userMapper.dtoToEntity(userDTO));
        return userMapper.entityToDTO(updateUser);
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
