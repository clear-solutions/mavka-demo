package io.mavka.demo.spring.transactional;

import io.mavka.demo.spring.transactional.exception.CustomRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionMarkedForRollback {

    private final UserService userService;

    public TransactionMarkedForRollback(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void processUser(User user) {
        try {
            userService.createUser(user);
        } catch (CustomRuntimeException e) {
            // Handle exception
        }
    }

    @Service
    public class UserService {

        @Transactional
        public void createUser(User user) {
            // Simulate an error condition
            if (user == null) {
                throw new CustomRuntimeException();
            }
        }
    }
}
