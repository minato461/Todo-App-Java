package sample.common.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import sample.common.dao.entity.Task;

@Mapper
public interface TaskMapper {
	@Select("SELECT * FROM tasks ORDER BY id ASC")
	List<Task> findAll();
	
	@Insert("INSERT INTO tasks (username, title, content, name, start_date, end_date) " + 
	"VALUES (#{username}), #{title}, #{content}, #{name}, #{startDate}, #{endDate}")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Task task);

}
