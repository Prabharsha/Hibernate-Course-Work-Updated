package lk.ijse.regsystem.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.regsystem.hibernate.business.BOFactory;
import lk.ijse.regsystem.hibernate.business.BOType;
import lk.ijse.regsystem.hibernate.business.custom.impl.ProgramBOImpl;
import lk.ijse.regsystem.hibernate.business.custom.impl.StudentBOImpl;
import lk.ijse.regsystem.hibernate.entity.Program;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCourseDetailsFormController implements Initializable {
    public AnchorPane programDetailsContext;
    public JFXButton btnBack;
    public JFXComboBox<String> cmbSelectProgram;
    public TableView tblRegistrationDetails;
    public TableColumn colRegStudentID;
    public TableColumn colRegProgramName;
    public TableColumn colRegDate;
    public TableView tblProgramDetails;
    public TableColumn colProgramID;
    public TableColumn colProDescription;
    public TableColumn colProDuration;
    public TableColumn colProFee;
    public TableView tblStudentDetails;
    public TableColumn colSTDStudentID;
    public TableColumn colSTDName;
    public TableColumn colSTDAddress;
    public TableColumn colSTDContact;
    public TableColumn colSTDEmail;
    public TableColumn colSTDDob;
    Parent root = null;
    List<Program> programs;
    List<Student> students;
    ObservableList<String> allPrograms = FXCollections.observableArrayList();

    ProgramBOImpl programBO = BOFactory.getInstance().getBO(BOType.PROGRAM);
    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        programs = programBO.getAll();
        students = studentBO.getAll();

        //tbl program details
        colProgramID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colProDescription.setCellValueFactory(new PropertyValueFactory<>("ProgramName"));
        colProDuration.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        colProFee.setCellValueFactory(new PropertyValueFactory<>("Fee"));

        //tbl Student Details
        colSTDStudentID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colSTDName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colSTDAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colSTDContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colSTDEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colSTDDob.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));

        //tbl Registration details

        tblProgramDetails.getItems().setAll(programs);
        tblStudentDetails.getItems().setAll(students);

        //cmb
        cmbSelectProgram.requestFocus();
        try {
            List<Program> allProgram = programBO.getAll();
            for (Program program : allProgram) {
                allPrograms.add(
                        program.getProgramName()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        cmbSelectProgram.getItems().setAll(allPrograms);
    }

    public void goBackOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        setScene();
    }

    public void addNewProgramOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/AddNewCourseStream.fxml"));
        setScene();
    }

    public void setScene() {
        Stage stage = (Stage) programDetailsContext.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
    }


}
