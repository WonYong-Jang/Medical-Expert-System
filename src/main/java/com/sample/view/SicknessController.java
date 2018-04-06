package com.sample.view;

import com.sample.PatientSickness;
import com.sample.model.Patient;
import com.sample.util.DateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SicknessController {
    @FXML
    private ListView<String> selectedSymptomsList;
    @FXML
	private TextArea PrescriptionRecord;
  //  @FXML
   // private ListView<String> surveyList;
    
	private Stage dialogStage;
	private Patient patient;
    private boolean okClicked = false;
    
    private ObservableList<String> selectedSymptoms = FXCollections.observableArrayList(); //
    //private ObservableList<String> surveyResult = FXCollections.observableArrayList(); //
    /**
     * ��Ʈ�ѷ� Ŭ������ �ʱ�ȭ�Ѵ�.
     * �� �޼���� fxml ������ �ε�� �� �ڵ����� ȣ��ȴ�.
     */
    @FXML
    private void initialize() {
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setPerson(Patient patient,PatientSickness sickness) {
        this.patient = patient;
        selectedSymptoms = sickness.getSymptoms();
        selectedSymptomsList.setItems(selectedSymptoms); //
        PrescriptionRecord.appendText(sickness.patientDiagnosis.getDoctorOpinion()); //
    }
    /**
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    @FXML
    private void handleOk() {
    	
        okClicked = true;
        dialogStage.close();
    }
    @FXML
    private void handleCancle() {
        dialogStage.close();
    }
}
