## hibernate examples 



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



updating the values in the mysql table and added some changes to Scanner since it is not taking the input from another function after being closed in function one

# updates the values 

Student stud = entityMan.find(Student.class, id);
stud.setName("abhi");
entityMan.merge(stud);


