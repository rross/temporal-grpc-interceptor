package io.temporal.demo;

import io.grpc.ClientInterceptor;
import io.temporal.client.*;
import io.temporal.serviceclient.SimpleSslContextBuilder;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {

    public WorkflowClient getClient() {
        return client;
    }

    private WorkflowClient client;

    public Client() {
        ClientInterceptor interceptor = new GrpcClientInterceptor();
        WorkflowServiceStubs serviceStubs = null;
        String targetNamespace = AppConfig.TARGET_NAMESPACE;
        String targetEndpoint = String.format("%s.tmprl.cloud:7233", targetNamespace);

        try {
            System.out.println(String.format("loading %s", AppConfig.TLS_CERT_PATH));
            InputStream clientCert = new FileInputStream(AppConfig.TLS_CERT_PATH);
            InputStream clientKey = new FileInputStream(AppConfig.TLS_KEY_PATH);

            serviceStubs = WorkflowServiceStubs.newServiceStubs(
                    WorkflowServiceStubsOptions.newBuilder()
                            .setSslContext(SimpleSslContextBuilder.forPKCS8(clientCert, clientKey).build())
                            .setTarget(targetEndpoint)
                            .addGrpcClientInterceptor(interceptor)
                            .build());

        } catch (IOException e) {
            System.err.println("Error loading certificates: " + e.getMessage());
            throw new RuntimeException("Unable to load certificates", e);
        }

        client = WorkflowClient.newInstance(serviceStubs,
                WorkflowClientOptions.newBuilder()
                        .setNamespace(targetNamespace)
                        .build());
    }
}
