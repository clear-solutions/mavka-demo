package io.mavka.demo.spring.transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExceptionHandlingAndRollbackRules {

    @Transactional
    public void createUser(User user) throws CustomException {
        // logic that throws CustomException
    }

    public class CustomException extends Exception {
        // custom exception
    }
}
