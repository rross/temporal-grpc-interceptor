package io.temporal.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyActivitiesImpl implements MyActivities {
    private static final Logger log = LoggerFactory.getLogger(MyActivitiesImpl.class);

    @Override
    public String myActivity(String input) {
        log.info("myActivity is called with %s", input);
        return "Hello " + input + "!";
    }
}
