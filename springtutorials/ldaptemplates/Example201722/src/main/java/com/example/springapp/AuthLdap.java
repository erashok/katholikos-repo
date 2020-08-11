package com.example.springapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Component;

@Component
public class AuthLdap {
	private final LdapTemplate ldapTemplate;
	final static Logger logger = LoggerFactory
	        .getLogger(AuthLdap.class);

	@Autowired
	public AuthLdap(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public void verifyCredentials(String userId,
	        String password) {
		LdapQuery query = LdapQueryBuilder.query().where("uid")
		        .is(userId);

		ldapTemplate.authenticate(query, password);
	}

}
