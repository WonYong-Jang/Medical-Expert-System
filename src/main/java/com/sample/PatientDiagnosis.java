package com.sample;

public class PatientDiagnosis {
	public String number, name, diagnosis, prescription, doctorOpinion, dateOfDiagnosis;
	
	public static final int NODIAGNOSISED   = 0; //진단 받은적이 없다.
    public static final int DIAGNOSISED = 1; //진단 받은 적이 없다.
    
    private int state;
    
	public PatientDiagnosis() {
		this.number = "1";
		this.name = "name";
		this.diagnosis = "";
		this.prescription = "";
		this.doctorOpinion = "";
		this.state = NODIAGNOSISED; 
		this.dateOfDiagnosis = "";
	}
	public void resetRecord() {
		this.diagnosis = this.prescription = "";
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis += ("\n"+diagnosis);
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setPrescription(String prescription) {
		this.prescription += ("\n"+prescription);
	}
	public String getPrescription() {
		return prescription;
	}
	public void setDoctorOpinion(String doctorOpinion) {
		this.doctorOpinion = doctorOpinion;
	}
	public String getDoctorOpinion() {
		return doctorOpinion;
	}
	public void setDateOfDiagnosis(String dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}
	public String getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}
	public void setState(int state) {
		this.state = state; 
	}
	public int getState() {
		return state;
	}
}
