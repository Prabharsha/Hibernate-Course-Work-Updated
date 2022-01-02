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
import lk.ijse.regsystem.hibernate.business.custom.impl.ProgramBOImpl;
import lk.ijse.regsystem.hibernate.dto.ProgramDTO;
import lk.ijse.regsystem.hibernate.entity.Program;

import java.io.IOException;

public class AddNewCourseStreamFormController {
    public AnchorPane registerNewProgramContext;
    public JFXButton btnCancel;
    public JFXButton btnRegister;
    public JFXTextField txtProgramId;
    public JFXTextField txtProgramName;
    public JFXTextField txtProgramDuration;
    public JFXTextField txtProgramFees;
    Parent root = null;

    ProgramBOImpl programBO = BOFactory.getInstance().getBO(BOType.PROGRAM);

    public void cancelOnAction(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/ViewCourseDetails.fxml"));
        setScene();

    }

    public void registerOnAction(MouseEvent mouseEvent) {
        String programID = txtProgramId.getText();
        String programName = txtProgramName.getText();
        String programDuration = txtProgramDuration.getText();
        Double fee = Double.parseDouble(txtProgramFees.getText());
        try {
            if(programBO.add(new Program(
                    programID,programName,programDuration,fee
            )));{
                new Alert(Alert.AlertType.CONFIRMATION,"Register Program .?").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setScene(){
        Stage stage =(Stage) registerNewProgramContext.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
