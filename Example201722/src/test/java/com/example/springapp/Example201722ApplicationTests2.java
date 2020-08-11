package com.example.springapp;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class Example201722ApplicationTests2 {
	@Test
	public void testBasicAuth2() throws Exception {
		try {
			String url = "http://localhost:8095/ldap/user/auth";
			RestTemplate rest = new RestTemplate(
			        new HttpComponentsClientHttpRequestFactory());
			rest.getMessageConverters().add(
			        new MappingJackson2HttpMessageConverter());
			rest.getMessageConverters()
			        .add(new StringHttpMessageConverter());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(
			        "{'userId' : 'abhijit', 'userPassword' : 'abcd123'}",
			        headers);
			ResponseEntity<String> response = rest.exchange(url,
			        HttpMethod.POST, entity, String.class);
			System.out.println(response.getBody());
		} catch (HttpStatusCodeException e) {
			e.printStackTrace();
			if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				String responseString = e
				        .getResponseBodyAsString();
				System.out.println(responseString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
