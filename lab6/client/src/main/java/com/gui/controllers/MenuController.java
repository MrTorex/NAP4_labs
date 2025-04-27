package com.gui.controllers;

import com.gui.enums.StagePath;
import com.gui.utils.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {

    @FXML private Button stocksEditButton;
    @FXML private Button usersEditButton;
    @FXML private Button logoutButton;
    @FXML private Label helloLabel;

    @FXML
    void onStocksEditButton(ActionEvent event) {
        Loader.loadScene((Stage) stocksEditButton.getScene().getWindow(), StagePath.STOCKS_MANAGEMENT);
    }

    @FXML
    void onUsersEditButton(ActionEvent event) {
        Loader.loadScene((Stage) usersEditButton.getScene().getWindow(), StagePath.USERS_MANAGEMENT);
    }

    @FXML
    void onLogoutButton(ActionEvent event) {
        Loader.loadScene((Stage) logoutButton.getScene().getWindow(), StagePath.LOGIN);
    }
}