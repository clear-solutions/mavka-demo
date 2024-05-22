package io.mavka.demo.spring.transactionl;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncorrectPropagationLevel {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createUser(User user) {
        // create user logic
    }
}
