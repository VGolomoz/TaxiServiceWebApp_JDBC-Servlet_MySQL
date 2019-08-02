package com.robosh.myUtils;

import com.robosh.model.entity.enums.Role;
import static com.robosh.web.command.PathCommand.*;
import java.util.*;


/**
 * class that make security for pages that need to be authorized
 *
 * @author Orest Shemelyuk
 */
public class SecurityConfig {
    private static final Map<Role, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> urlPatterns1 = new ArrayList<>();

        urlPatterns1.add(MAKE_ORDER);
        urlPatterns1.add(CLIENT_ACCOUNT);
        urlPatterns1.add(LOGOUT);
        urlPatterns1.add(ENTER_ORDER);

        mapConfig.put(Role.CLIENT, urlPatterns1);

        List<String> urlPatterns2 = new ArrayList<>();
        urlPatterns2.add(SHOW_ALL_ORDERS_PAG);
        urlPatterns2.add(DRIVER_ACCOUNT);
        urlPatterns2.add(LOGOUT);

        mapConfig.put(Role.DRIVER, urlPatterns2);
    }

    public static Set<Role> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(Role role) {
        return mapConfig.get(role);
    }
}
