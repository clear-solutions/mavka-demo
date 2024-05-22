package io.mavka.demo.spring.transactional;

import io.mavka.demo.spring.transactional.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IgnoringProxyMechanism {

    @Transactional
    public void createUser(User user) {
        internalMethod(user);
    }

    @Transactional
    public void internalMethod(User user) {
    }
}
