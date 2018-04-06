package com.sample.view;

import com.sample.model.Patient;
import com.sample.util.DateUtil;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DoctorOpinionController {
	
	@FXML
	private TextArea inputPrecription, additionalFields;
	@FXML
	private Label resultNum;
	@FXML
	private Label prescriptionDate;
	@FXML
	private TextField prescriptionPeriod;
	@FXML
	private TextField inputNum1, inputNum2, inputNum3, inputNum4, inputNum5,
					  inputNum6, inputNum7, inputNum8, inputNum9, inputNum10;
	
	private Stage dialogStage;
	private Patient patient;
    private boolean okClicked = false;
    private TextField[] inputNumList; 
    private ChangeListener<String> listner;
    /**
     */
    @FXML
    private void initialize() {
    	inputNumList = new TextField[]{inputNum1,inputNum2,inputNum3,inputNum4,inputNum5,inputNum6,
    									inputNum7,inputNum8,inputNum9,inputNum10};
    	
    	listner = new ChangeListener<String>() { // TextFields  listner
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				try {
					double checkNum = Double.parseDouble(newValue);
					if(0 <= checkNum && 100 >= checkNum) 
					{
						double result= 0 ;
						for(int i =0; i<inputNumList.length ; i++) 
						{
							if(inputNumList[i].getText() != null && inputNumList[i].getText().length() !=0 )
							{
								result += Double.parseDouble(inputNumList[i].getText());
							}
						}
						resultNum.setText(Double.toString(result));
					}
					}catch(NumberFormatException e) {  // 
						Alert alert = new Alert(AlertType.ERROR);
			            alert.initOwner(dialogStage);
			            alert.setTitle("Invalid Fields");
			            alert.setHeaderText("Invalid Fields");
			            alert.setContentText("Please correct invalid fields");

			            alert.showAndWait();
					}
			}
		};
    	
    	inputNum1.textProperty().addListener(listner);
    	inputNum2.textProperty().addListener(listner);
    	inputNum3.textProperty().addListener(listner);
    	inputNum4.textProperty().addListener(listner);
    	inputNum5.textProperty().addListener(listner);
    	inputNum6.textProperty().addListener(listner);
    	inputNum7.textProperty().addListener(listner);
    	inputNum8.textProperty().addListener(listner);
    	inputNum9.textProperty().addListener(listner);
    	inputNum10.textProperty().addListener(listner);
    	
    }
    
    /**
     * 
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setPerson(Patient patient) {
        this.patient = patient;
        inputPrecription.appendText(patient.diagnosis.getPrescription()); //
        resultNum.setText("");
        prescriptionDate.setText(DateUtil.getNowDate());
    }

    /**
     * 
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * 
     */
    @FXML
    private void handleOk() {
    	String resultStr = "\n";
    	String tempStr = inputPrecription.getText();
    	String[] lines = tempStr.split("\\r?\\n"); // 
    	for(int i =1; i<lines.length; i++)
    	{
    			String[] str = lines[i].split("\\[");  // 
    			String num = inputNumList[i-1].getText(); 
    			if(num.length()== 0) num = "0";
    			resultStr += str[0].concat(num +" ó��.\n");
    	}
    	if(additionalFields.getText().length() != 0)
    	{
    		resultStr += "\n"+additionalFields.getText();
    	}
    	resultStr += ("\n\n"+"ó�� �Ⱓ : "+prescriptionPeriod.getText()+" �� /  �հ� : "+resultNum.getText()+" g");
    	resultStr += ("\nó�� ��¥ : "+prescriptionDate.getText());
    	patient.diagnosis.setDoctorOpinion(resultStr); //
    	patient.diagnosis.setDateOfDiagnosis(prescriptionDate.getText()); //
    	patient.diagnosis.setState(1); //
            okClicked = true;
            dialogStage.close();
        
    }
    /**
     *
     */
    @FXML
    private void handleCancle() {
        dialogStage.close();
    }

}
