package demo.mybatis.MyBatis05_01.mapper;

import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis05_01.domain.Teacher;

import java.util.List;


@Repository
public interface TeacherMapper {
		
	Teacher getById(int id);

	/**
	 * 分页查询教师
	 * @param sort  排序字段
	 * @param dir   排序方向
	 * @param start  本页起始位置
	 * @param limit  每页记录数
     * @return
     */
	List<Teacher> findTeacherByPage(String sort, String dir, int start, int limit);

}
