package org.example.server;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
public class GrpcServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Creer le serveur avec le service associé.
        Server server = ServerBuilder.forPort(50051)
                .addService(new AdditionServiceImpl())
                .build();


        System.out.println("Server starting...");
        server.start();
        System.out.println("Server started on port 50051");


        server.awaitTermination();
}}


