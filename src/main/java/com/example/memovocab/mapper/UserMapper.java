package com.example.memovocab.mapper;

import com.example.memovocab.entity.User;
import com.example.memovocab.model.UserDto;
import com.example.memovocab.model.UserPostRequestDto;
import com.example.memovocab.model.UserPostResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToUser(UserPostRequestDto userPostRequestDto);

    UserDto mapToUserDto(User user);

    List<UserDto> mapToUserDtoList(List<User> user);

    UserPostResponseDto mapToUserPostResponseDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserPostRequestDto userPostRequestDto, @MappingTarget User user);

}
