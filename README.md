
***

# Java gRPC Addition Service

This project demonstrates a simple implementation of a gRPC-based system in Java. It defines a remote addition service allowing a client to send two numbers and receive their sum from a gRPC server. The setup uses Maven, Protocol Buffers, and gRPC libraries.

***

## Project Overview

The project includes two components:
- **gRPC Server**: Exposes an AdditionService implementation (`AdditionServiceImpl`) that performs the addition logic and runs on port `50051`.
- **gRPC Client**: Connects to the server (`AdditionClient`) to send requests and display results.

The communication between the client and server is defined using a `.proto` file (`AdditionService.proto`), which is compiled into Java classes using the `protobuf-maven-plugin`.

***

## Technologies Used

- Java 21  
- Maven  
- gRPC (version 1.60.0)  
- Protocol Buffers (version 4.30.1)  
- Protoc compiler (version 30.1)

***

## Project Structure

```
grpc/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/example/server/
│   │   │   │   ├── GrpcServer.java
│   │   │   │   ├── AdditionServiceImpl.java
│   │   │   ├── org/example/client/
│   │   │   │   ├── AdditionClient.java
│   │   ├── proto/
│   │   │   ├── AdditionService.proto
│   └── test/
│       └── ...
├── pom.xml
└── README.md
```

***

## .proto File Definition

The `AdditionService.proto` file defines the service contract for gRPC:

```
syntax = "proto3";
option java_multiple_files = true;
option java_package = "org.example.grpc";

service AdditionService {
  rpc add (AddRequest) returns (AddResponse);
}

message AddRequest {
  int32 a = 1;
  int32 b = 2;
}

message AddResponse {
  int32 result = 1;
}
```

***

## Building the Project

To compile the protocol buffers and build the project:

```bash
mvn clean compile
```

This command automatically generates Java classes based on the `.proto` definitions and compiles the Java source files.

***

## Running the Server

Start the gRPC server with:

```bash
mvn exec:java -Dexec.mainClass="org.example.server.GrpcServer"
```

You should see:

```
Server starting...
Server started on port 50051
```

***

## Running the Client

In a separate terminal, run the client:

```bash
mvn exec:java -Dexec.mainClass="org.example.client.AdditionClient"
```

Example console output:

```
Sending request: 5 + 3
Received response: 8
```

***

## Key Files Explained

- `AdditionServiceImpl.java`: Implements the gRPC service logic (addition operation).
- `GrpcServer.java`: Creates and starts the gRPC server with the registered service.
- `AdditionClient.java`: Connects to the server and sends requests.
- `AdditionService.proto`: Defines the gRPC contract and message types.

***

## Future Enhancements

- Add unit tests for client-server communication.
- Support more operations (subtraction, multiplication, division).
- Add logging and error handling.

***

## License

This project is provided for educational purposes under the MIT License.

***

Would you like this README written in French too for your internship portfolio?
