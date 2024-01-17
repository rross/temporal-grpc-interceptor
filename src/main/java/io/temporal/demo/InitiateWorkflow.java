package io.temporal.demo;

import io.temporal.client.WorkflowOptions;

public class InitiateWorkflow {
    public static void main(String[] args)  {
        Client client = new Client();

        WorkflowOptions workflowOptions = WorkflowOptions.newBuilder().
                setWorkflowId("MyWFId").
                setTaskQueue(AppConfig.TASK_QUEUE).build();

        SimpleWorkflow workflow = client.getClient().newWorkflowStub(SimpleWorkflow.class, workflowOptions);

        String response = workflow.execute("GrpcIntercept");

        System.out.println("The response is " + response);
        System.exit(0);
    }
}
