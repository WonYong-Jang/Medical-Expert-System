package com.sample;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 환자의 증상들을 진단 날짜 별로 가지고 있는 클래스
 */
public class PatientSickness {
	private ObjectProperty<LocalDate> dateOfDiagnosis; //진단 받은 날짜
	private ObservableList<String> symptoms = FXCollections.observableArrayList(); //증상들 리스트
	
	public PatientDiagnosis patientDiagnosis;
	public PatientSickness(PatientDiagnosis diagnosis, ObservableList<String> symptoms) {
		//this.dateOfDiagnosis = new SimpleObjectProperty<LocalDate>(DateUtil.parse(dateOfDiagnosis));
		this.patientDiagnosis= diagnosis;
		this.symptoms.addAll(symptoms);
	}
	public void setDateOfDiagnosis(LocalDate date) {
		this.dateOfDiagnosis.set(date);
	}
	public LocalDate getDateOfDiagnosis() {
		return dateOfDiagnosis.get();
	}
	public ObjectProperty<LocalDate> dateOfDiagnosisProperty() {
		return dateOfDiagnosis;
	}
	public ObservableList<String> getSymptoms() {
    	return symptoms;
    }
}
