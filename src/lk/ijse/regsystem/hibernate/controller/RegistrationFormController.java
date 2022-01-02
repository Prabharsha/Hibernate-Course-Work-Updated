package lk.ijse.regsystem.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.regsystem.hibernate.business.BOFactory;
import lk.ijse.regsystem.hibernate.business.BOType;
import lk.ijse.regsystem.hibernate.business.custom.impl.ProgramBOImpl;
import lk.ijse.regsystem.hibernate.business.custom.impl.StudentBOImpl;
import lk.ijse.regsystem.hibernate.dto.ProgramDTO;
import lk.ijse.regsystem.hibernate.dto.StudentDTO;
import lk.ijse.regsystem.hibernate.entity.Program;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable {
    public AnchorPane registrationPane;
    public JFXButton btnNewStudent;
    public JFXCheckBox paymentCheckBox;
    public JFXComboBox<String> cmbCourseStream;
    public JFXComboBox<String> cmbStudentId;
    public JFXButton btnCancel;
    public JFXButton btnRegister;
    public TextField txtStudentName;
    public TextField txtStudentAddress;
    public TextField txtStudentContact;
    public TextField txtStudentEmail;
    public TextField txtStudentDOB;
    public TextField txtFees;
    public TextField txtDuration;
    Parent root = null;
    ObservableList<String> allStudentId = FXCollections.observableArrayList();
    ObservableList<String> allProgramName = FXCollections.observableArrayList();

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);
    ProgramBOImpl programBO = BOFactory.getInstance().getBO(BOType.PROGRAM);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbStudentId.requestFocus();
        btnRegister.setDisable(true);
//initialize cmb
        try {
            List<Student> allStudent = studentBO.getAll();
            List<Program> allProgram =  programBO.getAll();

            for (Student student : allStudent) {
                allStudentId.add(
                        student.getsId()
                );
            }

            for (Program program:allProgram){
                allProgramName.add(
                        program.getProgramName()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cmbStudentId.getItems().setAll(allStudentId);
        cmbCourseStream.getItems().setAll(allProgramName);

//listeners
        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue!=null){
         btnNewStudent.setDisable(true);
         setStudentDetails(newValue);
        }
        if(newValue!=null && !cmbCourseStream.getSelectionModel().isEmpty() && paymentCheckBox.isSelected()){
            btnRegister.setDisable(false);
        }else {
            btnRegister.setDisable(true);
        }
        });

        cmbCourseStream.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            if (newValue!=null){
               setProgramDetails(newValue);

                }
            if(newValue!=null && !cmbStudentId.getSelectionModel().isEmpty() && paymentCheckBox.isSelected()){
                btnRegister.setDisable(false);

            }else {
                btnRegister.setDisable(true);
            }
        } );
        paymentCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue==true && !cmbStudentId.getSelectionModel().isEmpty() && !cmbCourseStream.getSelectionModel().isEmpty() ){
                btnRegister.setDisable(false);
            }else {
                btnRegister.setDisable(true);
            }
        });
    }

    private void setProgramDetails(String newValue) {
        try {
            Program temProgram = programBO.find(newValue);
            txtDuration.setText(temProgram.getDuration());
            txtFees.setText(String.valueOf(temProgram.getFee()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setStudentDetails(String newValue) {
        try {
            Student tempStudent = studentBO.find(newValue);
            txtStudentName.setText(tempStudent.getName());
            txtStudentAddress.setText(tempStudent.getAddress());
            txtStudentContact.setText(tempStudent.getContact());
            txtStudentEmail.setText(tempStudent.getEmail());
            txtStudentDOB.setText(tempStudent.getDateOfBirth());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void registerNewStudentOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/AddNewStudent.fxml"));
        setScene();
    }

    public void cancelOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        setScene();
    }

    public void registerOnAction(MouseEvent mouseEvent) {
        try {
            String date = String.valueOf(LocalDate.now());
            System.out.println(date);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setScene() {
        Stage stage = (Stage) registrationPane.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
    }


}
