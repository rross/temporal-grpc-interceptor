# Temporal GRPC Interceptor Example

This project demonstrates how to use a GRPC Interceptor for all calls to Temporal Cloud.

* Modify the AppConfig.java file with your own configuration details
* Build and run the Worker class
* build and run the InitiateWorkflow class

Inspect the logs and you will see log lines that look similar to this:

```
17:26:44.211 [main] INFO io.temporal.demo.GrpcClientInterceptor - calling GetWorkflowExecutionHistory
```

This output is coming from the GrpcClientInterceptor class on Line # 20. 
Modify this class as needed.