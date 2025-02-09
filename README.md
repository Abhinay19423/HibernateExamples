##  **HIBERNATE examples**



# Create a student table data entry 
    enter student details  into student table using entityManager 
    -- with the function called persist(class_object);
    ex :    
        public void createStudent(Student stud){
            // Student student = new Student("ram", "ram@email.com");
            entityMan.persist(stud);
        }


# retriving the values from the database 

entityMan.find(ClassName.class, column_name)
    -> returns student class value 

entityMan.createQuery("From CLASSNAME", ClassName.class)
    -> return a list of student from the sql 

    **finding single student by name / email or id**
    @Override
    public Student getDetail(int id){
        try{
            return entityMan.find(Student.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    **finding bulk of student with some matching constraints**
    @Override
    public List<Student> getDetails(){
        TypedQuery<Student> tq = entityMan.createQuery("From Student", Student.class);
        return tq.getResultList();
    }



# Updates the values 

updating the values in the mysql table and added some changes to Scanner since it is not taking the input from another function after being closed in function one

    @Override
    @Transactional // @Transactional should be present to refelect the changes into the database
    public void updateDetails(int id){
        // TypedQuery<Student> tq = entityMan.createQuery("From Student where id = 
        Student stud = entityMan.find(Student.class, id);
        stud.setName("abhi");
        entityMan.merge(stud);
    }

``` java
Student stud = entityMan.find(Student.class, id);
stud.setName("abhi");
entityMan.merge(stud);

```


# Deleting the records
deletion uses the **@Transactional** because it makes changes in the database


    
    ```

    **deleting by single element**
    @Override
    @Transactional
    public void deletionObj(int id){
        Student st = entityMan.find(Student.class, id);
        System.out.println(st.toString());
        entityMan.remove(st); //clear function?
    }



    **deleting bulk of students**
    @Override
    @Transactional
    public void deleteMultiple(){
        // TypedQuery<Student> tQuery = entityMan.createQuery("delete from Student where email=:emailAddress", Student.class).executeUpdate();
        t
    ```ry{
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



