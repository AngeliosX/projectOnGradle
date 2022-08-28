package com.example.user_service.service.impl;

import com.example.user_service.dto.in.ChangePasswordUserInDTO;
import com.example.user_service.dto.in.UserInDTO;
import com.example.user_service.dto.out.UserOutDTO;
import com.example.user_service.entity.Roles;
import com.example.user_service.entity.User;
import com.example.user_service.exceptions.RoleNotFoundException;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.repository.RoleRepository;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.service.UserServiceI;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService implements UserServiceI {
    private final UserRepository userRepository;

    private  final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserOutDTO createUser(UserInDTO userInDTO) {
        if (userRepository.existsByEmail(userInDTO.getEmail())) {
            throw new RuntimeException();
        }
        User user = userMapper.userInDTOToUser(userInDTO);
        User saveUser = userRepository.save(user);
        return userMapper.userToUserOutDTO(saveUser);
    }

    @Override
    @Transactional
    public UserOutDTO update(UserInDTO userInDTO, Long id) throws UserNotFoundException {
        if (!userRepository.existsById(id) && userRepository.existsByEmail(userInDTO.getEmail())) {
            throw new UserNotFoundException();
        }
        User user = userMapper.userInDTOToUser(userInDTO);
        user.setId(id);
        User saveUser = userRepository.save(user);
        return userMapper.userToUserOutDTO(saveUser);
    }

    @Override
    public Long deleteUser(Long id) throws UserNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public UserOutDTO getUser(Long id) throws UserNotFoundException {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new UserNotFoundException();
        }
        return userMapper.userToUserOutDTO(byId.get());
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordUserInDTO changePasswordUserInDTO) {
        User byEmail = userRepository.findByEmail(changePasswordUserInDTO.getEmail());
        if (!byEmail.getPassword().equals(changePasswordUserInDTO.getOldPassword())) {
            throw new RuntimeException();
        }
        byEmail.setPassword(changePasswordUserInDTO.getNewPassword());
    }

    @Override
    @Transactional
    public UserOutDTO addRoleToUser(UserInDTO userInDTO) throws RoleNotFoundException {
        User addRole = userRepository.findByEmail(userInDTO.getEmail());
        if (addRole.getRolesSet().isEmpty()) {
            throw new RoleNotFoundException();
        }
        User user = userMapper.userInDTOToUser(userInDTO);
        addRole.setRolesSet(user.getRolesSet());
        return userMapper.userToUserOutDTO(addRole);
    }

    @Override
    @Transactional
    public UserOutDTO removeRoleFromUser(Long userId, UserInDTO userInDTO)
            throws UserNotFoundException {
        User delRole = userRepository.findByEmail(userInDTO.getEmail());
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = userMapper.userInDTOToUser(userInDTO);
        delRole.setRolesSet(user.getRolesSet());
        return userMapper.userToUserOutDTO(delRole);
    }

}
