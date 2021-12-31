package lk.ijse.regsystem.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewCourseDetailsFormController {
    public AnchorPane programDetailsContext;
    public JFXButton btnBack;
    Parent root = null;

    public void goBackOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        setScene();
    }

    public void addNewProgramOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/AddNewCourseStream.fxml"));
        setScene();
    }
    public void setScene(){
        Stage stage =(Stage) programDetailsContext.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
