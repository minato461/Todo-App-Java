package sample.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.common.dao.entity.Login;
import sample.common.dao.mapper.LoginMapper;
import sample.common.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper loginMapper;
	
	// ユーザー認識処理：ログイン画面から送られてきた「ID」「PW」を引数として受け取る
	@Override
	public Login authenticate(String username, String password) {
		Login user = loginMapper.findUser(username);
		
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
