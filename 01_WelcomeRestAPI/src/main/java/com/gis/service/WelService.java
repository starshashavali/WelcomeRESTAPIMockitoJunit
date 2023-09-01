package com.gis.service;

import org.springframework.stereotype.Service;
@Service
public class WelService {

	public String welMsg() {
		return "Welcome to Junit 5 Learning ...";
	}
	
	public boolean wishing() {
		String str="Have a good day...";
		return true;
	}

}
