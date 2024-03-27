package com.limsa.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limsa.log.domain.Login;
import com.limsa.log.repository.LogRepo;

@Service
public class RegService {

    @Autowired
    private LogRepo userRepository;

    public void saveUser(String username, String password) {
        Login user = new Login();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }
}
