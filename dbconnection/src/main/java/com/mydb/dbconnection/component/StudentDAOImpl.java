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

    //using "like" keyword
    public List<Student> type1(){
        TypedQuery<Student>  tq = entityMan.createQuery("From Student s where s.email like '%@gmail.com'", Student.class);
        return tq.getResultList();
    }

    public List<Student> type2(String name){
        TypedQuery<Student>  tq = entityMan.createQuery("From Student s where s.name=:theData", Student.class);

        //set query paramters
        tq.setParameter("theData",name);

        //return query results
        return tq.getResultList();
    }


}
