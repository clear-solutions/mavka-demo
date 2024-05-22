package io.mavka.demo.spring.transactional;

import io.mavka.demo.spring.transactional.dto.User;
import io.mavka.demo.spring.transactional.exception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExceptionHandlingAndRollbackRules {

    @Transactional
    public void createUser(User user) throws CustomException {
        // logic that throws CustomException
    }
}
