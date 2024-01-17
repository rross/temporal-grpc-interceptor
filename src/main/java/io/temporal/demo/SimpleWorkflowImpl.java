package io.temporal.demo;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class SimpleWorkflowImpl implements SimpleWorkflow {

    private final MyActivities activities =
            Workflow.newActivityStub(MyActivities.class,
                    ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(2)).build());
    @Override
    public String execute(String name) {
        return activities.myActivity(name);
    }
}
