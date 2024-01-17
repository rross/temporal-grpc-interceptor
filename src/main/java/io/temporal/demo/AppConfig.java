package io.temporal.demo;

public final class AppConfig {
    public static final String TASK_QUEUE = "interceptor";
    public static final String TARGET_NAMESPACE="<namespace>.<account>"; // Temporal Cloud format

    public static final String TLS_CERT_PATH="/path/to/cert.pem";
    public static final String TLS_KEY_PATH="/path/to/cert.key";
}
