package com;

import com.gui.enums.StagePath;
import com.gui.utils.Loader;
import com.server.enums.Operation;
import com.server.network.Request;
import com.server.network.Response;
import com.server.network.ServerClient;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/logo.png"))));
        primaryStage.setTitle("Бизнес Акула");
        try {
            Loader.loadSceneWithThrowException(primaryStage, StagePath.LOGIN);
        } catch (IOException e) {
            System.err.println("Failed to start application: " + e.getMessage());
            e.printStackTrace();
        }
        primaryStage.show();
    }

    @Override
    public void stop() {
        ServerClient client = ServerClient.getInstance();
        if (client != null) {
            try {
                Request request = new Request(Operation.DISCONNECT, null);
                Response response = client.sendRequest(request);
                if (response != null && response.isSuccess()) {
                    System.out.println("Disconnected successfully from the server.");
                }
            } catch (Exception e) {
                System.err.println("Failed to send disconnect request: " + e.getMessage());
            } finally {
                client.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}