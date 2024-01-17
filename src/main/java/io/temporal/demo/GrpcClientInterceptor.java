package io.temporal.demo;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClientInterceptor implements ClientInterceptor {
    private final Logger logger;

    public GrpcClientInterceptor() {
        logger = LoggerFactory.getLogger(GrpcClientInterceptor.class);
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
                channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                logger.info("calling {}", methodDescriptor.getBareMethodName() );
                // TODO: modify the headers
                super.start(
                        new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                                responseListener) {

                            @Override
                            public void onMessage(RespT message) {
                                // Uncomment to see the detailed information coming back from the server
                                // logger.info("received {} response from Server: {}", methodDescriptor.getBareMethodName(),message);
                                super.onMessage(message);
                            }
                        },
                        headers);
            }
        };    }
}
