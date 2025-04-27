package com.gui.controllers;

import com.gui.enums.StagePath;
import com.gui.utils.AlertUtil;
import com.gui.utils.Loader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lombok.Getter;

public class StocksController {

    @Getter
    public static class Stock {
        private String name;
        private String ticker;
        private double price;
        private int quantity;

        public Stock(String name, String ticker, double price, int quantity) {
            this.name = name;
            this.ticker = ticker;
            this.price = price;
            this.quantity = quantity;
        }

    }

    @Getter
    public static class Company {
        private final String name;

        public Company(String name) {
            this.name = name;
        }

    }

    private final ObservableList<Stock> stocks = FXCollections.observableArrayList();
    private final ObservableList<Company> companies = FXCollections.observableArrayList();

    @FXML private TableView<Stock> stocksTable;
    @FXML private TableColumn<Stock, String> stockNameColumn;
    @FXML private TableColumn<Stock, String> stockTickerColumn;
    @FXML private TableColumn<Stock, Double> stockPriceColumn;
    @FXML private TableColumn<Stock, Integer> stockQuantityColumn;

    @FXML private TableView<Company> companiesTable;
    @FXML private TableColumn<Company, String> companyNameColumn;

    @FXML private ComboBox<Company> companiesComboBox;
    @FXML private TextField stockNameField;
    @FXML private TextField tickerField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;
    @FXML private TextArea infoArea;

    @FXML private Button addStockButton;
    @FXML private Button delStockButton;
    @FXML private Button updateStockButton;
    @FXML private Button eraseButton;
    @FXML private Button addCompanyButton;
    @FXML private Button delCompanyButton;
    @FXML private Button reInitButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        stockNameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        stockTickerColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTicker()));
        stockPriceColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        stockQuantityColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
        stocksTable.setItems(stocks);

        companyNameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        companiesTable.setItems(companies);
        companiesComboBox.setItems(companies);

        companies.add(new Company("Apple Inc."));
        companies.add(new Company("Tesla Inc."));
        stocks.add(new Stock("Apple Stock", "AAPL", 150.0, 100));
        stocks.add(new Stock("Tesla Stock", "TSLA", 700.0, 50));
    }

    @FXML
    void onAddStockButton(ActionEvent event) {
        try {
            String name = stockNameField.getText();
            String ticker = tickerField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            stocks.add(new Stock(name, ticker, price, quantity));
            clearFields();
            AlertUtil.info("Успех", "Акция добавлена!");
        } catch (NumberFormatException e) {
            AlertUtil.error("Ошибка", "Проверьте правильность ввода цены и количества.");
        }
    }

    @FXML
    void onDelStockButton(ActionEvent event) {
        Stock selected = stocksTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            stocks.remove(selected);
            AlertUtil.info("Успех", "Акция удалена!");
        } else {
            AlertUtil.warning("Внимание", "Выберите акцию для удаления.");
        }
    }

    @FXML
    void onUpdateStockButton(ActionEvent event) {
        Stock selected = stocksTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                selected.name = stockNameField.getText();
                selected.ticker = tickerField.getText();
                selected.price = Double.parseDouble(priceField.getText());
                selected.quantity = Integer.parseInt(quantityField.getText());
                stocksTable.refresh();
                clearFields();
                AlertUtil.info("Успех", "Акция обновлена!");
            } catch (NumberFormatException e) {
                AlertUtil.error("Ошибка", "Проверьте правильность ввода цены и количества.");
            }
        } else {
            AlertUtil.warning("Внимание", "Выберите акцию для редактирования.");
        }
    }

    @FXML
    void onEraseButton(ActionEvent event) {
        clearFields();
    }

    @FXML
    void onAddCompanyButton(ActionEvent event) {
        Company selected = companiesComboBox.getSelectionModel().getSelectedItem();
        if (selected != null && !companies.contains(selected)) {
            companies.add(selected);
            AlertUtil.info("Успех", "Компания добавлена!");
        }
    }

    @FXML
    void onDelCompanyButton(ActionEvent event) {
        Company selected = companiesTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            companies.remove(selected);
            AlertUtil.info("Успех", "Компания удалена!");
        }
    }

    @FXML
    void onReInitButton(ActionEvent event) {
        stocksTable.refresh();
        companiesTable.refresh();
    }

    @FXML
    void onBackButton(ActionEvent event) {
        Loader.loadScene((Stage) backButton.getScene().getWindow(), StagePath.MENU);
    }

    private void clearFields() {
        stockNameField.clear();
        tickerField.clear();
        priceField.clear();
        quantityField.clear();
    }
}