package lk.ijse.regsystem.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.regsystem.hibernate.business.BOFactory;
import lk.ijse.regsystem.hibernate.business.BOType;
import lk.ijse.regsystem.hibernate.business.custom.impl.StudentBOImpl;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardFromController implements Initializable {
    public Label lblTime;
    public JFXButton btnRegistration;
    public JFXButton btnViewDetails;
    public JFXButton btnSetting;
    public Label lblNoOfRegStudents;
    public Label lblNoOfCourses;
    public AnchorPane dashboardContext;
    Parent root = null;
    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            lblNoOfRegStudents.setText(String.valueOf(studentBO.getCount()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadTimeAndDate();
    }

    private void loadTimeAndDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        /*lblDate.setText(f.format(date));*/

        // load Time
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

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
