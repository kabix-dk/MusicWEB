package pb.wi.musicweb.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import pb.wi.musicweb.modelFX.AuthorFX;
import pb.wi.musicweb.modelFX.AuthorModel;

public class AuthorController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField nickTextField;
    @FXML
    private Button addButton;

    @FXML
    private TableView<AuthorFX> authorTableView;
    @FXML
    private TableColumn<AuthorFX, String> nameColumn;
    @FXML
    private TableColumn<AuthorFX, String> surnameColumn;
    @FXML
    private TableColumn<AuthorFX, String> nickColumn;

    @FXML
    private MenuItem deleteMenuItem;

    private AuthorModel authorModel;

    public void initialize() {
        this.authorModel = new AuthorModel();
        this.authorModel.init();
        this.authorModel.authorFXObjectPropertyProperty().get().nameProperty().bind(this.nameTextField.textProperty());
        this.authorModel.authorFXObjectPropertyProperty().get().surnameProperty().bind(this.surnameTextField.textProperty());
        this.authorModel.authorFXObjectPropertyProperty().get().nickProperty().bind(this.nickTextField.textProperty());
        this.addButton.disableProperty().bind(this.nameTextField.textProperty().isEmpty().or(this.surnameTextField.textProperty().isEmpty().or(this.nickTextField.textProperty().isEmpty())));

        this.authorTableView.setItems(this.authorModel.getAuthorFXObservableList());
        this.nameColumn.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        this.surnameColumn.setCellValueFactory(cellData-> cellData.getValue().surnameProperty());
        this.nickColumn.setCellValueFactory(cellData-> cellData.getValue().nickProperty());

        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nickColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        this.authorTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.authorModel.setAuthorFXObjectPropertyEdit(newValue);
        });

        this.deleteMenuItem.disableProperty().bind( this.authorTableView.getSelectionModel().selectedItemProperty().isNull());
    }
    
    public void addAuthorOnAction() {
        this.authorModel.saveAuthorInDataBase();
        this.nameTextField.clear();
        this.surnameTextField.clear();
        this.nickTextField.clear();
    }

    public void onEditCommitName(TableColumn.CellEditEvent<AuthorFX, String> authorFXStringCellEditEvent) {
        this.authorModel.getAuthorFXObjectPropertyEdit().setName(authorFXStringCellEditEvent.getNewValue());
        this.authorModel.saveAuthorEditInDataBase();
    }

    public void onEditCommitSurname(TableColumn.CellEditEvent<AuthorFX, String> authorFXStringCellEditEvent) {
        this.authorModel.getAuthorFXObjectPropertyEdit().setSurname(authorFXStringCellEditEvent.getNewValue());
        this.authorModel.saveAuthorEditInDataBase();
    }

    public void onEditCommitNick(TableColumn.CellEditEvent<AuthorFX, String> authorFXStringCellEditEvent) {
        this.authorModel.getAuthorFXObjectPropertyEdit().setNick(authorFXStringCellEditEvent.getNewValue());
        this.authorModel.saveAuthorEditInDataBase();
    }

    public void deleteAuthorOnAction() {
        this.authorModel.deleteAuthorInDataBase();
    }
}
