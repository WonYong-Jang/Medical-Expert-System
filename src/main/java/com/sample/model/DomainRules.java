package com.sample.model;

import java.util.ArrayList;
import java.util.Arrays;

public class DomainRules {
	public ArrayList<ArrayList<String>> domainRules; //
	public ArrayList<String> childDomain;

	public DomainRules() {
		setDomainRules();
	}
	public void setDomainRules() {
		domainRules = new ArrayList<ArrayList<String>>();
		childDomain = new ArrayList<String>(Arrays.asList("호흡 곤란","심한 두통","심한 피로감"));
		
	}
	public ArrayList<ArrayList<String>> getDomainRules() {
		return domainRules;
	}
	public ArrayList<String> getChildDomain() {
		return childDomain;
	}
}
