package com.example.skill_training.mapper;

import com.example.skill_training.entity.CellEmployee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CellEmployeeMapper {
    @Select("select * from bas_cell_employee left join bas_employees on bas_cell_employee.employee_id=bas_employees.id " +
            "left join bas_workcell on bas_cell_employee.cell_id=bas_workcell.id")
    List<CellEmployee> allCellEmployee();

    @Select("select * from bas_cell_employee left join bas_employees on bas_cell_employee.employee_id=bas_employees.id " +
            "left join bas_workcell on bas_cell_employee.cell_id=bas_workcell.id where employeeName=#{employeeName}")
    CellEmployee oneCellEmployee_employeeName(String employeeName);

    @Select("select * from bas_cell_employee left join bas_employees on bas_cell_employee.employee_id=bas_employees.id " +
            "left join bas_workcell on bas_cell_employee.cell_id=bas_workcell.id where cellName=#{cellName}")
    List<CellEmployee> oneCellEmployee_cellName(String cellName);

    @Select("select * from bas_cell_employee left join bas_employees on bas_cell_employee.employee_id=bas_employees.id " +
            "left join bas_workcell on bas_cell_employee.cell_id=bas_workcell.id " +
            "where employeeName=#{employeeName} and cellName=#{cellName}")
    CellEmployee oneCellEmployee(String employeeName,String cellName);

    @Select("select * from bas_cell_employee where id=#{id}")
    CellEmployee selectById(String id);

    @Insert("insert into bas_cell_employee(id,employee_id,cell_id,create_date) " +
            "values(#{id},#{employee_id},#{cell_id},#{create_date})")
    boolean insertCellEmployee(CellEmployee cellEmployee);

    @Update("update bas_cell_employee set employee_id=#{employee_id},cell_id=#{cell_id},update_date=#{update_date} where id=#{id}")
    boolean updateCellEmployee(CellEmployee cellEmployee);

    @Delete("delete from bas_cell_employee where employee_id=#{employee_id}")
    boolean deleteCellEmployee(String employee_id);
}
