package io.mavka.demo.java;

import java.util.List;

public class RolePrioritizationLogicError {

    public static void main(String[] args) {
        var roles = List.of("ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST");
        getRoleRedirect(roles);
    }

    public static String getRoleRedirect(List<String> roles) {
        String redirect = "/";
        for (String role : roles) {
            if ("ROLE_ADMIN".equals(role)) {
                redirect =  "/admin";
            } else if ("ROLE_USER".equals(role)) {
                redirect = "/user";
            }
        }
        return redirect;
    }
}
