package com.sample;

import com.sample.model.Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 환자 전체 목록을 가지고 있는 Factory 디비 연동 전
 * @author user
 *
 */
public class PatientFactory { // Creator
	public ObservableList<Patient> patient = FXCollections.observableArrayList();
    
	public PatientFactory() throws Exception {

        patient.add(new Patient("장원용"));
        patient.get(0).setSex("남");
        patient.get(0).setHeight("180");
        patient.get(0).setSymptom("지속적인 기침");
        patient.get(0).setSymptom("호흡 곤란");
        patient.get(0).setSymptom("심한 두통");
        patient.get(0).setSymptom("식은땀과 오한이 동반되는 경우");
        patient.get(0).setSymptom("심한 피로감");
   
        
        patient.add(new Patient("최유나"));
        patient.get(1).setSex("여");
        patient.get(1).setSymptom("복통");
        
        patient.add(new Patient("양성수"));
        patient.get(2).setSex("남");
        patient.get(2).setHeight("70");
        patient.get(2).setSymptom("경추성두통");
        patient.get(2).setSymptom("부비동두통");
        patient.get(2).setSymptom("턱관절두통");
        
        patient.add(new Patient("홍길동"));
        patient.add(new Patient("가길동"));
        patient.add(new Patient("나길동"));
        patient.add(new Patient("다길동"));
        patient.add(new Patient("라길동"));
        patient.add(new Patient("마길동"));
        patient.add(new Patient("바길동"));
        patient.add(new Patient("사길동"));
        patient.add(new Patient("아길동"));
        patient.add(new Patient("자길동"));
	}
	
    public ObservableList<Patient> getPatientData() {
        return patient;
    }
    
}
