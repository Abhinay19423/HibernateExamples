package com.mydb.dbconnection.component;

// import org.hibernate.tool.schema.internal.StandardUserDefinedTypeExporter;

import com.mydb.dbconnection.entity.Student;
import java.util.List;

public interface StudentDAO {
    // void save(Student stud);
    Student getDetail(int id);
    List<Student> getDetails();
}
