package Presentation;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import Logic.LoginChecker;

public class LoginSkaerm extends Application{

    public TextField userField;
    public PasswordField passField;
    Label wrongPWLabel;
    GridPane grid;

    @Override
    public void start(Stage stage) throws Exception {

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Text welcomeTxt = new Text("Velkommen til FFL");
        welcomeTxt.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
        welcomeTxt.setStroke(Color.BLACK);
        welcomeTxt.setFill(Color.GHOSTWHITE);


        grid.add(welcomeTxt, 0, 0);

        Label lblUser = new Label("Brugernavn:");
        grid.add(lblUser, 0, 1);
        lblUser.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        lblUser.setTextFill(Color.web("#FFFFFF"));



        userField = new TextField();
        userField.setPromptText("brugernavn");
        grid.add(userField, 1, 1);

        Label lblPassword = new Label("Adgangskode:");
        grid.add(lblPassword, 0, 2);
        lblPassword.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        lblPassword.setTextFill(Color.web("#FFFFFF"));



        passField = new PasswordField();
        passField.setPromptText("adgangskode");
        grid.add(passField, 1, 2);

        Button loginBtn = new Button("Login");
        grid.add(loginBtn, 1, 3);
        loginBtn.setStyle("-fx-background-color: #ff2800; ");
        loginBtn.setFont(Font.font("Tahoma", FontWeight.LIGHT, 13));
        loginBtn.setTextFill(Color.WHITE);
        loginBtn.setOnAction(e-> {
            newScene(LoginChecker.loginChecker(userField.getText(), passField.getText()), stage, StartSkaerm.instance()/*new StartSkaerm()*/);
        });

        wrongPWLabel = new Label();
        grid.add(wrongPWLabel, 1,4);
        wrongPWLabel.setTextFill(Color.web("#FF0000"));
        grid.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: WHITE;");

        Image img = new Image("file:login.png");
        ImageView image = new ImageView(img);
        StackPane root = new StackPane(image, grid);


        Scene scene = new Scene(root);
        stage.setWidth(750);
        stage.setHeight(535);
        stage.setScene(scene);
        stage.show();

    }
    private void newScene(Boolean loginStatus, Stage stage, BorderPane pane) {
        Scene scene = new Scene(pane);
        if(loginStatus) {
            stage.setScene(scene);
            stage.show();
        } else {
            wrongPWLabel.setText("Thats the wrooong number");

        }
    }
}


