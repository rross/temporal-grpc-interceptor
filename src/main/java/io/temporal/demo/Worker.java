package io.temporal.demo;

import io.temporal.worker.WorkerFactory;

import java.util.Random;

public class Worker {
    public static void main(String[] args)  {

        // Generate a fake token for testing purposes
        var token = "Negotiate " + new Random().nextInt();
        UserContext.setUserContext(token);

        Client client = new Client();

        WorkerFactory factory = WorkerFactory.newInstance(client.getClient());
        io.temporal.worker.Worker worker = factory.newWorker(AppConfig.TASK_QUEUE);

        worker.registerWorkflowImplementationTypes(SimpleWorkflowImpl.class);
        worker.registerActivitiesImplementations(new MyActivitiesImpl());
        factory.start();
    }
}
