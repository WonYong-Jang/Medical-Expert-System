package com.sample.view;

import java.util.ArrayList;

import com.sample.DroolsTest;
import com.sample.ExpertController;
import com.sample.PatientSickness;
import com.sample.model.DomainRules;
import com.sample.model.Patient;
import com.sample.util.DateUtil;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafx.util.StringConverter;


public class PatientController {
    @FXML
    public TableView<Patient> patientTable; //
    @FXML
    private TableColumn<Patient, String> nameColumn; //
    @FXML
    private ListView<String> patientSurvey;
    @FXML
    private ListView<String> patientSymptoms;
    @FXML
    private ChoiceBox<PatientSickness> dateOfDiagnosis; //
    @FXML
    private Label diagnosisLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label todayLabel;
    @FXML
    private Label prescriptionLabel;
    @FXML
    private Label doctorOpinionLabel;
    // 
    private ExpertController mainApp;
    private DroolsTest drools;
    private DomainRules rules;
    private int numOfVisit;
    /**
     * 
     * initialize() 
     */
    public PatientController() {
    	numOfVisit=0;
    }

    /**
     */
    @FXML
    private void initialize() {
        // 
        nameColumn.setCellValueFactory(new Callback<CellDataFeatures<Patient, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Patient, String> cellData) {
				return cellData.getValue().nameProperty();
			}
		});
        
        // Person information 
        showPatientDetails(null);

        //
        patientTable.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Patient>() {
					@Override
					public void changed(ObservableValue<? extends Patient> observable, Patient oldValue,
							Patient newValue) {
						showPatientDetails(newValue);
					}
				});
        // 
        patientTable.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Patient>() {
					@Override
					public void changed(ObservableValue<? extends Patient> observable, Patient oldValue,
							Patient newValue) {
						showPersomSymptoms(newValue);
					}
				});
    }
    private void showPatientDetails(Patient patient) {
        if (patient != null) {
            // person
            numberLabel.setText(patient.getNumber());
            nameLabel.setText(patient.getName());
            sexLabel.setText(patient.getSex());
            ageLabel.setText(Integer.toString(patient.getAge()));
            heightLabel.setText(patient.getHeight());
            weightLabel.setText(Integer.toString(patient.getWeight()));
            birthdayLabel.setText(DateUtil.format(patient.getBirthday()));
            todayLabel.setText(DateUtil.getNowDateTime());
            diagnosisLabel.setText(patient.diagnosis.getDiagnosis());
            prescriptionLabel.setText(patient.diagnosis.getPrescription());
            doctorOpinionLabel.setText(patient.diagnosis.getDoctorOpinion());
            dateOfDiagnosis.getItems().clear(); // �ٸ� ȯ�ڸ� Ŭ���Ҷ� ���� ȯ���� ������ �״�� ���� �ʱ� ����
            dateOfDiagnosis.getItems().addAll(patient.sickness);
            /*
            numOfVisit = patient.sickness.size(); // �湮 Ƚ�� Count
            for(int i=1; i<=numOfVisit; i++) {
           	dateOfDiagnosis.getItems().add(patient.sickness. //���ܰ� ó�� ���� ��� choice box�� �߰�
    		get(i-1).patientDiagnosis.getDateOfDiagnosis()+" ("+i+")"); // 0�� �ε��� ���� ���ʷ� �߰��� ������.
            }*/
        } else {
            // person
        	numberLabel.setText("");
            nameLabel.setText("");
            sexLabel.setText("");
            ageLabel.setText("");
            heightLabel.setText("");
            weightLabel.setText("");
            birthdayLabel.setText("");
            todayLabel.setText("");
            diagnosisLabel.setText("");
            doctorOpinionLabel.setText("");
            prescriptionLabel.setText("");
            dateOfDiagnosis.getItems().clear();
        }
    }
    private void showPersomSymptoms(Patient patient) { // 
    	patientSurvey.setItems(patient.getSymptoms()); // survey result 
    	patientSymptoms.setItems(patient.getSymptoms());
    }
    private void showDoctorOpinion(Patient patient) { //
    	doctorOpinionLabel.setText(patient.diagnosis.getDoctorOpinion());
    }
    /**
     * 
     */
    @FXML
    private void handleDeletePatient() {
    	int selectedIndex = patientTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            patientTable.getItems().remove(selectedIndex);
        } else {
            // 
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Patient Selected");
            alert.setContentText("Please select a patient in the table.");

            alert.showAndWait();
        }
    }
    /**
     */
    @FXML
    private void handleNewPatient() {
        Patient tempPatient = new Patient();
        boolean okClicked = mainApp.showPatientEditDialog(tempPatient,0); // 0 -> New Patient
        if (okClicked) {
            mainApp.factory.getPatientData().add(tempPatient);
        }
    }

    /**
     */
    @FXML
    private void handleEditPatient() {
        Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            boolean okClicked = mainApp.showPatientEditDialog(selectedPatient,1); // 1 -> Edit Patient
            if (okClicked) {
                showPatientDetails(selectedPatient);
            }

        } else {
            //
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Patient Selected");
            alert.setContentText("Please select a patient in the table.");

            alert.showAndWait();
        }
    }
    @FXML
    private void handleDetails() {
    	Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
    	PatientSickness sickness = dateOfDiagnosis.getSelectionModel().getSelectedItem(); //
    	System.out.println(sickness.getSymptoms());
    	if (selectedPatient != null) {
            boolean okClicked = mainApp.showDetailsDialog(selectedPatient,sickness);
            if (okClicked) {
               // show(selectedPatient);
            }
        }
    	else {
    		//
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Record");
            alert.setHeaderText("No prescription record");
            alert.setContentText("If there is no prescription record,\nit is not accessible.");

            alert.showAndWait();
    	}
    }
    /**
     *  Survey 
     */
    @FXML
    private void fireAllPatient() {
    	Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
    	if(selectedPatient != null) {
    		selectedPatient.symptomArr = new ArrayList<String>(selectedPatient.symptom);
    		doctorOpinionLabel.setText(""); //
    		selectedPatient.diagnosis.resetRecord(); //
    		drools.setPatient(selectedPatient); //
    		drools.startDrools();
    		String diagnosis = selectedPatient.diagnosis.getDiagnosis(); //
    		String prescription = selectedPatient.diagnosis.getPrescription(); //
    		showPatientDiagnosis(diagnosis);
    		showPatientPrescription(prescription);
    	}
    	else {
    		// 
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Patient Selected");
            alert.setContentText("Please select a patient in the table.");

            alert.showAndWait();
    	}
    }
    private void showPatientDiagnosis(String diagnosis) { //
    	diagnosisLabel.setText(diagnosis);
    }
    private void showPatientPrescription(String prescription) { //
    	prescriptionLabel.setText(prescription);
    }
    /**
     *
     */
    @FXML
    private void handleDoctorOpinion() {
    	Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            boolean okClicked = mainApp.showDoctorOpinionDialog(selectedPatient);
            if (okClicked) {
                showDoctorOpinion(selectedPatient);
            }
        }
    }
    /**
     * FireAll 
     */
    @FXML
    private void handleSave() { //
    	Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
    	if(selectedPatient != null && selectedPatient.diagnosis.getState() == 1) { // 
    		//
    		selectedPatient.sickness.add(new PatientSickness(selectedPatient.diagnosis, patientSymptoms.getItems()));
    		
    		int num = selectedPatient.sickness.size();
    		for(int i =0; i<num;i++)
    		{
    			System.out.println(selectedPatient.sickness.get(i).getSymptoms());
    		}
    		dateOfDiagnosis.setConverter(new StringConverter<PatientSickness>() {
				@Override
				public String toString(PatientSickness obj) {
					// TODO Auto-generated method stub
					System.out.println(obj.patientDiagnosis.getDateOfDiagnosis());
					return obj.patientDiagnosis.getDateOfDiagnosis();
				}
				@Override
				public PatientSickness fromString(String string) {
					// TODO Auto-generated method stub
					PatientSickness result = null;
					for(PatientSickness temp : dateOfDiagnosis.getItems()) {
						if(temp.patientDiagnosis.getDateOfDiagnosis().equals(string)) {
							result = temp;
							System.out.println("ã��");
							break;
						}
					}
					return result;
				}
			});
    		dateOfDiagnosis.getItems().clear();
    		dateOfDiagnosis.getItems().addAll(selectedPatient.sickness);
    		
    		 Alert alert = new Alert(AlertType.INFORMATION); //
             alert.initOwner(mainApp.getPrimaryStage());
             alert.setTitle("Saved");
             alert.setHeaderText("Saved");
             alert.setContentText("Saving is complete");

             alert.showAndWait();
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.ERROR); // 
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Input");
            alert.setHeaderText("Input was not completed.");
            alert.setContentText("Please select a patient in the table and \nFill in your doctor's opinion.");

            alert.showAndWait();
    	}
    }
    /**
     * 
     *
     * @param mainApp
     */
    public void setMainApp(ExpertController mainApp) {
        this.mainApp = mainApp;
        // 
        rules = new DomainRules();
        drools = new DroolsTest();
        drools.setDomainRules(rules); // setting domain in drools
        patientTable.setItems(mainApp.factory.getPatientData());
    }
}