package sample.common.service;

import sample.common.dao.entity.Login;

public interface LoginService {
	public Login authenticate(String username, String password) ;
}
