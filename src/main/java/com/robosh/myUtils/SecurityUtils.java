package com.robosh.myUtils;

import com.robosh.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * class that check if Person has permission to this page or not
 *
 * @author Orest Shemelyuk
 */
public class SecurityUtils {
    public static boolean isSecurityPage(HttpServletRequest request) {
        Set<Role> roles = SecurityConfig.getAllAppRoles();
        for (Role role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(request.getPathInfo())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPermission(HttpServletRequest request, Role personRole) {
        return SecurityConfig.getUrlPatternsForRole(personRole).contains(request.getPathInfo());
    }
}
