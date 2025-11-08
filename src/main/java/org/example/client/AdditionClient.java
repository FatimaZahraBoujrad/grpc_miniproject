package org.example.client;
import addition.AdditionService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import addition.AdditionGrpc;
import addition.AdditionService.*;
public class AdditionClient {
    public static void main(String[] args) {
        // Créer une chaine qui se connecte au serveur
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Créer un stub pour le client
        AdditionGrpc.AdditionBlockingStub stub = AdditionGrpc.newBlockingStub(channel);


        AdditionService.AddRequest request = AdditionService.AddRequest.newBuilder()
                .setA(5)
                .setB(5)
                .build();

        // appeler le serveur et attendre une réponse
        AddResponse response = stub.add(request);


        System.out.println("Somme: " + response.getSum());
                channel.shutdown();
    }

}
