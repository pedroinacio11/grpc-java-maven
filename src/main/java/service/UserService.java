package service;

import generated.APIResponse;
import generated.Empty;
import generated.LoginRequest;
import generated.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase{

    @Override
    public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();
        String cep = request.getAddress().getCep();

        APIResponse.Builder response = APIResponse.newBuilder();
        if (username.equals(password)){
            response.setResponseMessage("Sucesso").setResponseCode(200);
            System.out.println("cep :" + cep);
        } else {
            response.setResponseMessage("Falha ao efetuar o login").setResponseCode(400);
        }
        
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
    }
}
