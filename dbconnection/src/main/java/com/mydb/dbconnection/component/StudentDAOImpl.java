package com.mydb.dbconnection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mydb.dbconnection.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

// import jakarta.transaction.Transactional;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityMan;

    @Autowired
    public StudentDAOImpl(EntityManager ent){
        entityMan = ent;
    }

    // @Override
    // @Transactional
    // public void save(Student stud){
    //     entityMan.persist(stud);
    // }

    @Override
    public Student getDetail(int id){
        try{
            return entityMan.find(Student.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createStudent(Student stud){
        // Student student = new Student("ram", "ram@email.com");
        entityMan.persist(stud);
    }

    @Override
    public List<Student> getDetails(){
        TypedQuery<Student> tq = entityMan.createQuery("From Student", Student.class);
        return tq.getResultList();
    }

    @Override
    @Transactional // @Transactional should be present to refelect the changes into the database
    public void updateDetails(int id){
        // TypedQuery<Student> tq = entityMan.createQuery("From Student where id = 
        Student stud = entityMan.find(Student.class, id);
        stud.setName("abhi");
        entityMan.merge(stud);
    }

    @Override
    public List<Student> type1(){
        TypedQuery<Student> tq = entityMan.createQuery("From student s where s.email like '%@gmail.com'", Student.class);
        return tq.getResultList();
    }

    @Override
    public List<Student> type2(String name){
        TypedQuery<Student> tq = entityMan.createQuery("From student s where s.name = :name", Student.class);
        tq.setParameter("name", name);
        return tq.getResultList();
    }

    @Override
    @Transactional
    public void deletionObj(int id){
        Student st = entityMan.find(Student.class, id);
        System.out.println(st.toString());
        entityMan.remove(st); //clear function?
    }


    @Override
    @Transactional
    public void deleteMultiple(){
        // TypedQuery<Student> tQuery = entityMan.createQuery("delete from Student where email=:emailAddress", Student.class).executeUpdate();
        try{
            // int numRows = entityMan.createQuery("DELETE FROM Student s WHERE s.email = 'abhinay@gail.com'").executeUpdate();
            int numRows = entityMan.createQuery("DELETE FROM Student").executeUpdate();
            System.out.println("the no of student removed are " + numRows);            
        }catch(Exception e){
            System.out.println("the searched email is not found ");
            throw new RuntimeException("Something went wrong ");
        }
        
        // tQuery.setParameter("emailAddress", "abhinay@gmail.com");
        // int val = entityMan.executeUpdate();
        
    }
}
