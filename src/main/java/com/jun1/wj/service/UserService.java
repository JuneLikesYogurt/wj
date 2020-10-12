package com.jun1.wj.service;

import com.jun1.wj.dao.UserDAO;
import com.jun1.wj.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* Service 负责业务逻辑，跟功能相关的代码一般写在这里，
   编写、调用各种方法对 DAO 取得的数据进行操作*/
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }
}
