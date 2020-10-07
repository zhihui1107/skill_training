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
    @Select("select * from bas_employees where del_flag=0")
    List<Employee> allEmployee();

    @Select("select * from bas_employees left join bas_cell_employee on " +
            "bas_employees.id=bas_cell_employee.employee_id where bas_employees.del_flag=0 and bas_cell_employee.cell_id is null " +
            "or bas_employees.del_flag=0 and bas_cell_employee.del_flag=1")
    List<Employee> otherEmployee();

    @Select("select * from bas_employees where employeeNo=#{employeeNo} and del_flag=0")
    Employee oneEmployeeNo(String employeeNo);

    @Select("select * from bas_employees where employeeName=#{employeeName} and del_flag=0")
    List<Employee> oneEmployeeName(String employeeName);

    @Select("select * from bas_employees where employeeNo=#{employeeNo} and employeeName=#{employeeName} and del_flag=0")
    Employee oneEmployee(String employeeNo,String employeeName);

    @Select("select * from bas_employees where id=#{id} and del_flag=0")
    Employee selectById(String id);

    @Insert("insert into bas_employees(id,employeeNo,employeeName,workDate,sex,age,telNum,address,email,idCard," +
            "officeId,del_flag,remarks,create_by,create_date,update_by,update_date) " +
            "values(#{id},#{employeeNo},#{employeeName},#{workDate},#{sex},#{age},#{telNum},#{address},#{email}," +
            "#{idCard},#{officeId},#{del_flag},#{remarks},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertEmployee(Employee employee);

    @Update("update bas_employees set employeeNo=#{employeeNo},employeeName=#{employeeName},workDate=#{workDate}," +
            "sex=#{sex},age=#{age},telNum=#{telNum},address=#{address},email=#{email},idCard=#{idCard}," +
            "officeId=#{officeId},del_flag=#{del_flag},remarks=#{remarks}," +
            "update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean updateEmployee(Employee employee);

    @Update("update bas_employees set del_flag=#{del_flag},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean deleteEmployee(Employee employee);
}
