package com.gui.enums;

import lombok.Getter;

@Getter
public enum StagePath {
    LOGIN("/views/login.fxml"),
    REGISTRATION("/views/register.fxml"),
    MENU("/views/menu.fxml"),
    STOCKS_MANAGEMENT("/views/stocks.fxml"), // Изменено с BOOKS_MANAGEMENT
    USERS_MANAGEMENT("/views/users.fxml");

    private final String pathToFxml;

    StagePath(String pathToFxml) {
        this.pathToFxml = pathToFxml;
    }
}