package demo.mybatis.MyBatis06_01.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis06_01.domain.Teacher;


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
//	List<Teacher> findTeacherByPage(@Param("sort") String sort, @Param("dir") String dir, @Param("start") int start, @Param("limit") int limit);


	/**
	 * 分页查询教师
	 * @param params 参数
	 * @return
     */
//	List<Teacher> findTeacherByPage(Map<String, Object> params);


	List<Teacher> findTeacherByPage(@Param("params") Map<String, Object> params, @Param("start") int start, @Param("limit") int limit);

}
