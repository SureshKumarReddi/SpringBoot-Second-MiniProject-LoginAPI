package com.suresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.bindings.LoginRequest;
import com.suresh.constants.AppConstants;
import com.suresh.models.UserEntity;
import com.suresh.props.AppsProps;
import com.suresh.repositories.UserDetailsRepository;
import com.suresh.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDetailsRepository repository;
	@Autowired
	private AppsProps props;

	@Override
	public String login(LoginRequest request) {
		UserEntity findByUserEmailAndUserPassword = repository.findByUserEmailAndUserPassword(request.getEmail(), request.getPwd());
	
		if(findByUserEmailAndUserPassword==null) {
			return props.getMessages().get(AppConstants.EMAIL_AND_PASSWORD_INCORRECT);
		}
		if(findByUserEmailAndUserPassword.getUserAccountStatus().equals(AppConstants.LOCKED)){
			return props.getMessages().get(AppConstants.USER_ACCOUNT_LOCKED);
		}
		return AppConstants.LOGIN_SUCCESSFULL;
	}

}
