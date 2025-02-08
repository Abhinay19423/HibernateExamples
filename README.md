# hibernate examples 



# retriving the values from the database 
entityMan.find(ClassName.class, column_name)
    -> returns student class values 


entityMan.createQuery("From CLASSNAME", ClassName.class)
    -> return a list of student from the sql 


