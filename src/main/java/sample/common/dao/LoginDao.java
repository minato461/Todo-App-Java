package sample.common.dao;

import org.apache.ibatis.annotations.Mapper;

import sample.common.dao.entity.Login;

@Mapper
public interface LoginDao {
	Login findUser(String username);
}
