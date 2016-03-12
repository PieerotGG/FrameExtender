package fr.vandp.pierre.libs;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Pieerot on 12/03/2016 18:30. fr.vandp.pierre.libs.frames for SimpleJFXProgramm
 */
public class LoginFrame extends Application implements EventHandler<ActionEvent> {


    private Stage stage;
    protected String name = "Name";
    protected double widht = 300;
    protected double height = 160;

    //INITIALIZATION DE LA PANEL
    private JFXPanel jfxPanel = new JFXPanel();

    //COMPONENTS
    private Label userName = new Label("UserName:");
    private TextField userJTextField = new TextField();
    private Label passWord = new Label("Password:");
    private PasswordField passwordField = new PasswordField();
    protected Button loginButton = new Button("Sign in");
    protected Button regiserButton = new Button("Register");
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle(this.name);
        stage.setScene(getFirstScene());
        stage.setResizable(false);
        stage.show();
    }

    public GridPane getGridPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(8);
        grid.setGridLinesVisible(false);
        grid.setVgap(8);
        grid.setPadding(new Insets(15, 5, 5, 5));

        //COMPONENT
        grid.add(this.userName, 0, 0);

        grid.add(this.userJTextField, 1, 0);

        grid.add(this.passWord, 0, 1);

        grid.add(this.passwordField, 1, 1);

        this.loginButton.setOnAction(this);
        this.regiserButton.setOnAction(this);
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(this.regiserButton, this.loginButton);
        grid.add(hBox, 1, 2);

        this.choiceBox.getItems().addAll("Français", "English");
        this.choiceBox.setOnAction(this);
        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.BOTTOM_RIGHT);
        hBox1.getChildren().add(this.choiceBox);
        grid.add(hBox1, 1, 3);

        return grid;
    }

    public Scene getFirstScene() {
        return new Scene(getGridPane(), widht, height);
    }


    public Stage getStage() {
        return stage;
    }

    public void setFieldsEnable(boolean enable) {
        this.userJTextField.setEditable(enable);
        this.passwordField.setEditable(enable);
    }

    @Override
    public void handle(ActionEvent event) {

    }

    public void show() {
        launch();
    }

    public void show(String[] args) {
        launch(args);
    }
}

