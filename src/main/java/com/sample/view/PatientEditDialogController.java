package com.sample.view;

import org.controlsfx.control.textfield.TextFields;

import com.sample.model.Patient;
import com.sample.model.Symptom;
import com.sample.util.DateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
/**
 */
public class PatientEditDialogController {
	
	@FXML
	private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField birthdayField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView<String> selectedSymptomsList;
    @FXML
    private TextField autoCompleteField;
    @FXML
    private TreeView<String> treeView;
    
    private ListView<String> symptomList;
    
    private Symptom symptomModel;
    private Stage dialogStage;
    private Patient patient;
    private boolean okClicked = false;
    private ObservableList<String> selectedSymptoms = FXCollections.observableArrayList(); //
    /**
     */
	@FXML
    private void initialize() {
    	symptomModel = new Symptom();
    	//symptomList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //
    	treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	TextFields.bindAutoCompletion(autoCompleteField,symptomModel.allSymptomList); // 
    	autoCompleteField.setPromptText("Search");
    	
    	TreeItem<String> root = new TreeItem<>("Category");
    	root.setExpanded(true);
    	
    	TreeItem<String> head = new TreeItem<>("Head"); // 
    	TreeItem<String> camouflage = new TreeItem<>("Camouflage"); // 
    	TreeItem<String> liver = new TreeItem<>("liver"); //
    	TreeItem<String> heart = new TreeItem<>("Heart"); //
    	TreeItem<String> climacteric = new TreeItem<>("Climacteric"); //
    	TreeItem<String> etc = new TreeItem<>("Etc"); //
    	
    	root.getChildren().addAll(head,camouflage,liver,heart,climacteric,etc);
    	head.setExpanded(true);
    	camouflage.setExpanded(true);
    	liver.setExpanded(true);
    	heart.setExpanded(true);
    	climacteric.setExpanded(true);
    	etc.setExpanded(true);
    	for(String item : symptomModel.getHeadList()) {
    		head.getChildren().add(new TreeItem<>(item));
    	}
    	for(String item : symptomModel.getCamouflageList()) {
    		camouflage.getChildren().add(new TreeItem<>(item));
    	}
    	for(String item : symptomModel.getEtcList()) {
    		etc.getChildren().add(new TreeItem<>(item));
    	}
    	symptomList = new ListView<String>();
    	symptomList.setItems(symptomModel.getAllSymptomList());
    	
    	treeView.setRoot(root);
    }

    /**
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     *
     * @param person
     */
    public void setPerson(Patient patient) {
        this.patient = patient;
        numberField.setText(patient.getNumber());
        nameField.setText(patient.getName());
        sexField.setText(patient.getSex());
        ageField.setText(Integer.toString(patient.getAge()));
        heightField.setText(patient.getHeight());
        weightField.setText(Integer.toString(patient.getWeight()));
        birthdayField.setText(DateUtil.format(patient.getBirthday()));
        birthdayField.setPromptText("yyyy.mm.dd");
        //datePicker.setAccessibleText(value);
        symptomList.setItems(symptomModel.getSymptomList()); // 
        selectedSymptoms = patient.getSymptoms();
        selectedSymptomsList.setItems(selectedSymptoms); //
    }

    /**
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	patient.setNumber(numberField.getText());
            patient.setName(nameField.getText());
            patient.setSex(sexField.getText());
            patient.setAge(Integer.parseInt(ageField.getText()));
            patient.setHeight(heightField.getText());
            patient.setWeight(Integer.parseInt(weightField.getText()));
            patient.setBirthday(DateUtil.parse(birthdayField.getText()));
            patient.setSymptoms(selectedSymptoms);
            
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     */
    @FXML
    private void handleCancle() {
        dialogStage.close();
    }

    @FXML
    private void handleAdd() {          //
    	String str = autoCompleteField.getText();
    	
    	if(str == null || autoCompleteField.getText().length() ==0 ) { //
    		str += "Please fill in the search box!\n";
    		
    		Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(str);

            alert.showAndWait();
    	}
    	else if (selectedSymptoms.contains(str)) //
    	{
    		Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Duplicate value occurrence !");
            alert.setContentText("Duplicate values can not be entered.");

            alert.showAndWait();
    	}
    	else if(!symptomModel.allSymptomList.contains(str)) { //
    		Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Invalid Fields");
            alert.setContentText("Please correct invalid fields");

            alert.showAndWait();
    	}
    	else 
    	{
    		selectedSymptoms.add(str);
	    	selectedSymptomsList.setItems(selectedSymptoms); 
	    	autoCompleteField.setText("");
    	}
    }
    @FXML
    private void handleDel() { //
    	int selectedIndex = selectedSymptomsList.getSelectionModel().getSelectedIndex();
    	if(selectedIndex >= 0) {
    	selectedSymptoms.remove(selectedIndex);
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("Please select the symptom you want to delete in the table.");

            alert.showAndWait();
    	}
    }
    @FXML
    private void handleAddToLeft() { //
    	int flag = 0, validValue = 0;
    	
    	ObservableList<String> temp = FXCollections.observableArrayList(); //
    	for(TreeItem<String> str : treeView.getSelectionModel().getSelectedItems()) {
    		temp.add(str.getValue());
    	}
    	
    	for(String check : temp) //
    	{  
    		if(selectedSymptoms.contains(check)) flag =1;
    		if(!symptomModel.allSymptomList.contains(check)) validValue =1; 
    	}
    	
    	if(treeView.getSelectionModel().getSelectedIndex() < 0 || validValue ==1) { // 
    		Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("Please select the symptom you want to add in the table.");

            alert.showAndWait();
    	}
    	else if(flag ==1 ) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Duplicate value occurrence !");
            alert.setContentText("Duplicate values can not be entered.");

            alert.showAndWait();
    	}
    	else {
    	selectedSymptoms.addAll(temp);
    	selectedSymptomsList.setItems(selectedSymptoms); 
    	}
    }
    
    /**
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (sexField.getText() == null || sexField.getText().length() == 0) {
            errorMessage += "No valid sex!\n";
        }

        if (ageField.getText() == null || ageField.getText().length() == 0) {
            errorMessage += "No valid age!\n";
        } else {
            //  
            try {
                Integer.parseInt(ageField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid age (must be an integer)!\n";
            }
        }

        if (heightField.getText() == null || heightField.getText().length() == 0) {
            errorMessage += "No valid height!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format yyyy.mm.dd!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // 
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }


}