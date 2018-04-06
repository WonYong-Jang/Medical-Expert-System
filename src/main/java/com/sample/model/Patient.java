package com.sample.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.sample.PatientDiagnosis;
import com.sample.PatientSickness;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 환자 클래스
 *
 */
public class Patient {
	public ObservableList<PatientSickness> sickness = FXCollections.observableArrayList(); //
	public ObservableList<String> symptom = FXCollections.observableArrayList();
	public ArrayList<String> symptomArr; // 
	public PatientDiagnosis diagnosis;
	
	private final StringProperty number;
    private final StringProperty name;
    private final StringProperty sex;
    private final IntegerProperty age;
    private final StringProperty height;
    private final IntegerProperty weight;
    private final ObjectProperty<LocalDate> birthday;
    /**
     *
     */
    public Patient() {
    	this(null);
    }
    /**
     *
     */
    public Patient(String name) {
    	// 
    	this.number = new SimpleStringProperty("ex) 1234");
        this.name = new SimpleStringProperty(name);
        this.sex = new SimpleStringProperty("남/여");
        this.age = new SimpleIntegerProperty(20);
        this.height = new SimpleStringProperty("some height");
        this.weight = new SimpleIntegerProperty(70);
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1991,06,05));
        diagnosis = new PatientDiagnosis();
    }
    public ArrayList<String> getSymptomArr() {
    	return symptomArr;
    }
    public void setSymptomArr(String symptomArr) {
    	this.symptomArr.add(symptomArr);
    }
    
    public void setSymptom(String symptom) {
    	this.symptom.add(symptom);
    }
    public ObservableList<String> getSymptoms() {
    	return symptom;
    }
    public void setSymptoms(ObservableList<String> symptoms) {
    	this.symptom = symptoms;
    }
    
    public String getNumber() {
        return number.get();
    }
    public void setNumber(String number) {
        this.number.set(number);
    }
    public StringProperty numberProperty() {
        return number;
    }
    
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name;
    }

    public String getSex() {
        return sex.get();
    }
    public void setSex(String sex) {
        this.sex.set(sex);
    }
    public StringProperty sexProperty() {
        return sex;
    }

    public int getAge() {
        return age.get();
    }
    public void setAge(int age) {
        this.age.set(age);
    }
    public IntegerProperty ageProperty() {
        return age;
    }
    
    public int getWeight() {
        return weight.get();
    }
    public void setWeight(int weight) {
        this.weight.set(weight);
    }
    public IntegerProperty weightProperty() {
        return weight;
    }
    
    public String getHeight() {
        return height.get();
    }
    public void setHeight(String height) {
        this.height.set(height);
    }
    public StringProperty heightProperty() {
        return height;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
    public PatientDiagnosis getDiagnosis() {
    	return diagnosis;
    }
    
}