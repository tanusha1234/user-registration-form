# user-registration-form

Spring-based RESTful web application with H2 database that manages user registrations.  
A user registration consisting of a username, email address, and the date that user registered(System date by default-created date).  

REST endpoints:
==================
[POST]add: http://localhost:8080/users
    sample json request body to post:
          {
            "userName": "Anusha",
            "emailAddress": "anusha.t8989@gmail.com"
          }
          
[DELETE]delete by id:http://localhost:8080/users/{id}
    example: http://localhost:8080/users/1
    
[Get]get all users: http://localhost:8080/users

[Get]get user by id : http://localhost:8080/users/{id}
     example: http://localhost:8080/users/1
     
(Note: included unit and/or integration tests to verify the application)
