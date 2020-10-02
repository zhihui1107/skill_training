package com.example.skill_training.mapper;

import com.example.skill_training.entity.Company;
import com.example.skill_training.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeMapper {
    @Select("select * from bas_employees")
    List<Employee> allEmployee();

    @Select("select * from bas_employees left join bas_cell_employee on " +
            "bas_employees.id=bas_cell_employee.employee_id where bas_cell_employee.cell_id is null")
    List<Employee> otherEmployee();

    @Select("select * from bas_employees where employeeNo=#{employeeNo}")
    Employee oneEmployeeNo(String employeeNo);

    @Select("select * from bas_employees where employeeName=#{employeeName}")
    List<Employee> oneEmployeeName(String employeeName);

    @Select("select * from bas_employees where employeeNo=#{employeeNo} and employeeName=#{employeeName}")
    Employee oneEmployee(String employeeNo,String employeeName);

    @Select("select * from bas_employees where id=#{id}")
    Employee selectById(String id);

    @Insert("insert into bas_employees(id,employeeNo,employeeName,workDate,sex,age,teNum,address,email,idCard,officeId,create_date) " +
            "values(#{id},#{employeeNo},#{employeeName},#{workDate},#{sex},#{age},#{teNum},#{address},#{email},#{idCard},#{officeId},#{create_date})")
    boolean insertEmployee(Employee employee);

    @Update("update bas_employees set employeeNo=#{employeeNo},employeeName=#{employeeName},workDate=#{workDate}," +
            "sex=#{sex},age=#{age},teNum=#{teNum},address=#{address}," +
            "email=#{email},idCard=#{idCard},officeId=#{officeId},update_date=#{update_date} where id=#{id}")
    boolean updateEmployee(Employee employee);

    @Delete("delete from bas_employees where employeeNo=#{employeeNo}")
    boolean deleteEmployee(String employeeNo);
}
