package test.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import test.model.User;

@Mapper
public interface UserMapper {
	List<User> hello()throws Exception;
}
