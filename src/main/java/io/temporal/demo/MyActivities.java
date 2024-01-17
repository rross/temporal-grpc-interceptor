package io.temporal.demo;


import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface MyActivities {
    @ActivityMethod
    String myActivity(String input);
}
