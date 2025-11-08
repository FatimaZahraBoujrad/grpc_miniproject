package org.example.server;
import addition.AdditionGrpc;
import addition.AdditionService;
import io.grpc.stub.StreamObserver;

public class AdditionServiceImpl extends AdditionGrpc.AdditionImplBase{
    @Override
    public void add(AdditionService.AddRequest request, StreamObserver<AdditionService.AddResponse> responseObserver) {

        int a = request.getA();
        int b = request.getB();
        int sum = a + b;
        // creer uen réponse
        AdditionService.AddResponse response = AdditionService.AddResponse.newBuilder()
                .setSum(sum)
                .build();

        //repondre le client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
