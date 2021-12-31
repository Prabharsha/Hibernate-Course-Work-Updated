package lk.ijse.regsystem.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFromController {
    public Label lblTime;
    public JFXButton btnRegistration;
    public JFXButton btnViewDetails;
    public JFXButton btnSetting;
    public Label lblNoOfRegStudents;
    public Label lblNoOfCourses;
    public AnchorPane dashboardContext;
    Parent root = null;


    public void exitOnAction(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void goToRegistration(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/RegistrationForm.fxml"));
        setScene();
    }

    public void goToViewDetails(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/ViewCourseDetails.fxml"));
        setScene();
    }

    public void setScene(){
        Stage stage =(Stage) dashboardContext.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
