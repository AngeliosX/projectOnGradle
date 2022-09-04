package com.example.user_service.mapper;

import com.example.user_service.dto.in.UserInDTO;
import com.example.user_service.dto.out.UserOutDTO;
import com.example.user_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserOutDTO userToUserOutDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "password", ignore = true, defaultValue = "Flag123@",
            nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
    @Mapping(target = "rolesSet", ignore = true)
    User userInDTOToUser(UserInDTO userInDTO);
}
