package com.gui.controllers;

import com.gui.enums.StagePath;
import com.gui.utils.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsersController {

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button delUserButton;

    @FXML
    private Button eraseButton;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TextField firstNameField;

    @FXML
    private TableColumn<?, ?> lastNameColumn;

    @FXML
    private TextField lastNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TableColumn<?, ?> patronymicColumn;

    @FXML
    private TextField patronymicField;

    @FXML
    private Button reInitButton;

    @FXML
    private ComboBox<?> rolesComoBox;

    @FXML
    private Button updateUserButton;

    @FXML
    private TableColumn<?, ?> usernameColumn;

    @FXML
    private TextField usernameField;

    @FXML
    private TableView<?> usersTable;

    @FXML
    private Button backButton;

    @FXML
    void onDelUserButton(ActionEvent event) {}

    @FXML
    void onEraseButton(ActionEvent event) {}

    @FXML
    void onReInitButton(ActionEvent event) {}

    @FXML
    void onUpdateUserButton(ActionEvent event) {}

    @FXML
    void onBackButton(ActionEvent event) {
        Loader.loadScene((Stage) backButton.getScene().getWindow(), StagePath.MENU);
    }
}
