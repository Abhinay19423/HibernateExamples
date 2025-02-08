package com.mydb.dbconnection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mydb.dbconnection.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
    public List<Student> getDetails(){
        TypedQuery<Student> tq = entityMan.createQuery("From Student", Student.class);
        return tq.getResultList();
    }

    @Override
    public void updateDetails(int id){
        // TypedQuery<Student> tq = entityMan.createQuery("From Student where id = 
        Student stud = entityMan.find(Student.class, id);

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
}
