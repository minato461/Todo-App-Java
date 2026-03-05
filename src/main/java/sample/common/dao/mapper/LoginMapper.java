package sample.common.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sample.common.dao.entity.Login;

@Mapper
public interface LoginMapper {
	@Select("SELECT * FROM login WHERE username = #{username}")
	Login findByUsername(String username);
}