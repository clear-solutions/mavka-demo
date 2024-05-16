package io.mavka.demo.security;

package io.mavka.demo.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@AllArgsConstructor
@Component
public class KeycloakLogoutHandler implements LogoutHandler {

    private final RestTemplate restClient;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        if (auth != null && auth.getPrincipal() instanceof OidcUser) {
            OidcUser user = (OidcUser) auth.getPrincipal();
            try {
                String tokenValue = user.getIdToken().getTokenValue();
                String url = user.getIssuer() + "/protocol/openid-connect/logout?id_token_hint=" + tokenValue;

                restClient.exchange(url, HttpMethod.GET, null, Void.class);


                response.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                log.error("Logout request to Keycloak failed for user: {} [{}] with error: {}",
                          user.getName(), user.getSubject(), e.getMessage(), e);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            log.error("Invalid authentication information for logout request {}", auth);
        }
    }
}

