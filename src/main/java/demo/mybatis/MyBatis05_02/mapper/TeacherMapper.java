package demo.mybatis.MyBatis05_02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis05_02.domain.Teacher;


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
	List<Teacher> findTeacherByPage(@Param("sort") String sort, @Param("dir") String dir, @Param("start") int start, @Param("limit") int limit);

}
