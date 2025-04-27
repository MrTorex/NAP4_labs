package com.gui.controllers;

import com.gui.enums.StagePath;
import com.gui.utils.AlertUtil;
import com.gui.utils.Loader;
import com.server.enums.Operation;
import com.server.network.Request;
import com.server.network.Response;
import com.server.network.ServerClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private Button loginButton;
    @FXML private PasswordField passwordField;
    @FXML private Button regButton;
    @FXML private TextField usernameField;

    @FXML
    void onLoginButton(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Request request = new Request(Operation.LOGIN, "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");
        Response response = ServerClient.getInstance().sendRequest(request);
        if (response != null && response.isSuccess()) {
            AlertUtil.info("Успех", "Авторизация прошла успешно!");
            Loader.loadScene((Stage) loginButton.getScene().getWindow(), StagePath.MENU);
        } else {
            AlertUtil.error("Ошибка", "Неверные данные для входа или функционал в разработке.");
        }
    }

    @FXML
    void onRegButton(ActionEvent event) {
        Loader.loadScene((Stage) regButton.getScene().getWindow(), StagePath.REGISTRATION);
    }
}