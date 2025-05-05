package com.example.memovocab.mapper;

import com.example.memovocab.entity.User;
import com.example.memovocab.model.UserPostRequestDto;
import com.example.memovocab.model.UserPostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToUser(UserPostRequestDto userPostRequestDto);

    UserPostResponseDto mapToUserPostResponseDto(User user);
}
