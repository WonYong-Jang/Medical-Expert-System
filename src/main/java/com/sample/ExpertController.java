package com.sample;

import java.io.IOException;

import com.sample.model.Patient;
import com.sample.view.PatientController;
import com.sample.view.PatientEditDialogController;
import com.sample.view.SicknessController;
import com.sample.view.DoctorOpinionController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExpertController extends Application {
	public PatientFactory factory;
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public ExpertController() throws Exception {
        factory = new PatientFactory();
       // drools.setPersonSymptoms(person);
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Medical Expert System");

        initRootLayout();

        showPersonOverview();
    }
    /**
     * RootLayout 초기화 
     */
    public void initRootLayout() {
        try {
            // fxml 연결
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ExpertController.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
           
            rootLayout.setMinSize(1000, 830);
            // 사이즈 조절
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 환자 이름을 클릭시 person information view
     */
    public void showPersonOverview() {
        try {
            // Person information fxml 연결
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ExpertController.class.getResource("view/PatientInfo.fxml"));
            AnchorPane personInfo = (AnchorPane) loader.load();

            // Person information 위치 배치
            rootLayout.setLeft(personInfo);
            
            personInfo.setMaxSize(1000, 800);
            
            PatientController controller = loader.getController();       
            controller.setMainApp(this);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * patient 세부사항을 수정할수 있는 dialog 
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPatientEditDialog(Patient patient, int flag) {
        try {
            // fxml 연결
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ExpertController.class.getResource("view/PatientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // stage
            Stage dialogStage = new Stage();
            
            if(flag==0) dialogStage.setTitle("New Patient");
            else dialogStage.setTitle("Edit Patient");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // 컨트롤러 연결
            PatientEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(patient);
           
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 의사 소견을 작성 할수 있는 dialog
     */
    public boolean showDoctorOpinionDialog(Patient patient) {
    	try {
    		
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ExpertController.class.getResource("view/DoctorOpinion.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Input Prescription");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            DoctorOpinionController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(patient);

            dialogStage.showAndWait();
           
    		return controller.isOkClicked();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    /**
     * 환자가 받았던 증상들 히스토리 보기
     */
    public boolean showDetailsDialog(Patient patient, PatientSickness sickness) {
    	try {
    		
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ExpertController.class.getResource("view/SicknessDetails.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Sickness Details");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            SicknessController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(patient,sickness);

            dialogStage.showAndWait();
           
    		return controller.isOkClicked();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    /**
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}