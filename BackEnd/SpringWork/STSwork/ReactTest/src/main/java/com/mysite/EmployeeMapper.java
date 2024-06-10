package com.mysite;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {
	
	@Select("select * from emp order by id")
	List<Employee> getAllEmployees();
	
	@Insert("insert into emp values(seq_emp.nextval, #{name}, #{email})")
	void insertEmployee(Employee emp);

	@Delete("delete from emp where id=#{id}")
	void deleteEmployee(int id);
	
	@Update("update emp set name=#{name}, email=#{email} where id=#{id}")
	void updateEmployee(Employee emp);
}
