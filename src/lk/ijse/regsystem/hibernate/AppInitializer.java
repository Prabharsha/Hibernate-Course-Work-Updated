package lk.ijse.regsystem.hibernate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.regsystem.hibernate.entity.Registration;
import lk.ijse.regsystem.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/DashBoardForm.fxml"))));
        primaryStage.setTitle("Sipsewana Institute");
        primaryStage.centerOnScreen();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
