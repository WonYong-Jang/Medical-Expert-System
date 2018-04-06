package com.sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Symptom {
	public ObservableList<String> allSymptomList = FXCollections.observableArrayList();
	public ObservableList<String> symptomList = FXCollections.observableArrayList();
	public ObservableList<String> headList = FXCollections.observableArrayList();
	public ObservableList<String> camouflageList = FXCollections.observableArrayList();
	public ObservableList<String> liverList = FXCollections.observableArrayList();
	public ObservableList<String> heartList = FXCollections.observableArrayList();
	public ObservableList<String> climactericList = FXCollections.observableArrayList();
	public ObservableList<String> etcList = FXCollections.observableArrayList();
	//public ArrayList<String> symptomArr;
	public Symptom() {
		//setSymptomList();
		setHeadList();
		setCamouflageList();
		setLiverList();
		setHeartList();
		setClimactericList();
		setEtcList();
		setAllSymptomList();
	}
	public ObservableList<String> getSymptomList() {
        return symptomList;
    }
    public void setSymptomList() {
    	symptomList.addAll();
    }
    public void setHeadList() {
    	headList.addAll("1차성 두통","긴장성 두통","편두통","군발두통","2차성 두통");
    }
    public ObservableList<String> getHeadList() {
    	return headList;
    }
    public void setCamouflageList() {
    	camouflageList.addAll("");
    }
    public ObservableList<String> getCamouflageList() {
    	return camouflageList;
    }
    public void setLiverList() {
    	liverList.addAll("");
    }
    public ObservableList<String> getLiverList() {
    	return liverList;
    }
    public void setHeartList() {
    	heartList.addAll("");
    }
    public ObservableList<String> getHeartList() {
    	return heartList;
    }
    public void setClimactericList() {
    	climactericList.addAll("");
    }
    public ObservableList<String> getClimactericList() {
    	return climactericList;
    }
    public void setEtcList() { // 기타
    	etcList.addAll("��ȭ�ҷ�","��ġ���","����","���� �󺹺�","���� �Ϻ���","�������","���̹���","�� �Ḳ","����","�� �ڻ�","ü��",
    			"��ġ����","�󿭰�","����","���� �αٰŸ�","�Ҿ���","�뺯 ����","�忰����","�Ʒ��� ���� ��","�뺯 ����","�Ҹ���","���� ����",
    			"�Ǹ���","���� ��������","�İ���","���� ��","ȫ�� ���ۿ� ����","���� ����","Ʈ�� ����","ȫ�� ���ۿ� ����","���� ���� ��������",
    			"���,�߿� ������ ����","���� ������","���� Ž","��ġ���� ���� ������","���� ���� 7,80% ������","������ Ʈ��");
    }
    public ObservableList<String> getEtcList() {
    	return etcList;
    }
    public void setAllSymptomList() {  
    	allSymptomList.addAll(headList);
    	allSymptomList.addAll(camouflageList);
    	allSymptomList.addAll(liverList);
    	allSymptomList.addAll(heartList);
    	allSymptomList.addAll(climactericList);
    	allSymptomList.addAll(etcList);
    }
    public ObservableList<String> getAllSymptomList() {
    	return allSymptomList;
    }
}
