package lk.ijse.regsystem.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.regsystem.hibernate.business.BOFactory;
import lk.ijse.regsystem.hibernate.business.BOType;
import lk.ijse.regsystem.hibernate.business.custom.impl.StudentBOImpl;
import lk.ijse.regsystem.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.regsystem.hibernate.dto.StudentDTO;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.io.IOException;

public class AddNewStudentFormController {
    public AnchorPane registerNewStudentContext;
    public JFXButton btnCancel;
    public JFXButton btnRegister;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXTextField txtStudentID;
    public JFXTextField txtStudentEmail;
    public JFXTextField txtDOB;
    Parent root = null;

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void cancelOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/RegistrationForm.fxml"));
        setScene();
    }

    public void registerOnAction(MouseEvent mouseEvent) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String address = txtStudentAddress.getText();
        String contact = txtStudentContact.getText();
        String email = txtStudentEmail.getText();
        String dob = txtDOB.getText();
        try {
            if (studentBO.add(new Student(
                    id,name,address,contact,email,dob
            )));{
                new Alert(Alert.AlertType.CONFIRMATION,"Register Student.?").showAndWait();
                txtStudentID.clear();
                txtStudentName.clear();
                txtStudentAddress.clear();
                txtStudentContact.clear();
                txtStudentEmail.clear();
                txtDOB.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Registration Fail.!").showAndWait();
        }
    }

    public void setScene() {
        Stage stage = (Stage) registerNewStudentContext.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
