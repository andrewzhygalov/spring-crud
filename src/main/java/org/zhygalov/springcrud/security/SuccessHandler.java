package org.zhygalov.springcrud.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String base = "/spring-crud";
		String name = UserDetails.class.cast(authentication.getPrincipal()).getUsername();
		httpServletRequest.getSession().setAttribute("userName", name);
		if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect(base + "/admin");
        } else {
            httpServletResponse.sendRedirect(base + "/user");
        }
    }
}
