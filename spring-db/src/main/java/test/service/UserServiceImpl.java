package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.model.User;

import java.util.List;
 

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
 
 
    @Override
    public List<User> hello()throws Exception {
        return userMapper.hello();
    }
}
