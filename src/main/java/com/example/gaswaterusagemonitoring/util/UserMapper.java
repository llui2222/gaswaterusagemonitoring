package com.example.gaswaterusagemonitoring.util;

import com.example.gaswaterusagemonitoring.entity.UserDb;
import io.tej.SwaggerCodgen.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDb toUserEntity(User user);
    List<User> toUserDtoList(List<UserDb> userList);
}
