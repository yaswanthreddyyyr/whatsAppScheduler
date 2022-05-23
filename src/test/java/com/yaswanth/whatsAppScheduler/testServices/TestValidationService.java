package com.yaswanth.whatsAppScheduler.testServices;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.yaswanth.whatsAppScheduler.service.ValidationService;

@SpringBootTest
public class TestValidationService {
	@Autowired
	ValidationService validationService;
	
	@Test
	public void testValidatePhone() {
		String testCase1="918688721990";
		String testCase2="Some Garbage";
		String testCase3="8688721990";
		String testCase4="819688721990";
		String testCase5="911234567890";
		assertThat(validationService.validatePhone(testCase1)).isTrue();
		assertThat(validationService.validatePhone(testCase2)).isFalse();
		assertThat(validationService.validatePhone(testCase3)).isFalse();
		assertThat(validationService.validatePhone(testCase4)).isFalse();
		assertThat(validationService.validatePhone(testCase5)).isFalse();
		
		
	}
	@Test
	public void testValiateDate() throws Exception {
		String testCase1="2022/05/24 23:59";//Valid Format
		String testCase2="2022/05/2423:59";//InValid Format
		String testCase3="Some Invalid String";//Invalid Date and time
		String testCase4="2022/05/24 24:59"; //Invalid Hours
		String testCase5="2022/05/24 23:61"; //Invalid Minutes
		assertThat(validationService.validateDateAndTime(testCase1)).isTrue();
		assertThat(validationService.validateDateAndTime(testCase2)).isFalse();
		assertThat(validationService.validateDateAndTime(testCase3)).isFalse();
		assertThat(validationService.validateDateAndTime(testCase4)).isFalse();
		assertThat(validationService.validateDateAndTime(testCase5)).isFalse();
		
		
	}
	
	@Test
	public void testValidMessage() {
		assertThat(validationService.validateMessage("")).isFalse();
		assertThat(validationService.validateMessage("Any Message")).isTrue();
	}
	
}
