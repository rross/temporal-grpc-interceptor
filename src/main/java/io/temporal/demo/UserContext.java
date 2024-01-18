package io.temporal.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UserContext {

    final static Logger log = LoggerFactory.getLogger(UserContext.class);

    private UserContext() {
    }

    private static InheritableThreadLocal<UserInfo> currentUserContext = new InheritableThreadLocal<>();

    public static void setUserContext(String userId) {
        log.info("Setting userId to {}", userId);
        currentUserContext.set(new UserInfo(userId));
    }

    public static UserInfo getUserContext() {
        return currentUserContext.get();
    }

    public static void clear() {
        log.info("Clearing user context");
        currentUserContext.remove();
    }
}
