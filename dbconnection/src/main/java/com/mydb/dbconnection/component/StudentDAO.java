package com.mydb.dbconnection.component;

// import org.hibernate.tool.schema.internal.StandardUserDefinedTypeExporter;

import com.mydb.dbconnection.entity.Student;
import java.util.List;

public interface StudentDAO {
    // void save(Student stud);
    Student getDetail(int id);
    List<Student> getDetails();
<<<<<<< HEAD

    void updateDetails(int id);
    // diff_method_to_retrive
    List<Student> type1();
    List<Student> type2(String name);
=======
>>>>>>> parent of c1bd69c (updating the values in the student table)
}
