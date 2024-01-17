package io.temporal.demo;


import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface SimpleWorkflow {

    @WorkflowMethod
    String execute(String name);
}
