# managED

<img src="https://user-images.githubusercontent.com/57250845/126905766-bbfa0316-6c5a-4c9e-9817-b54fc8037d64.jpeg" width="250" height="250"/>

## About

managED(Management for Education) is a system developed for college placements. 
The application helps to automate the whole process of college placement. 
It helps the visiting companies select students having relevant skills and grades beforehand, thus allowing them to save significant amount of time.

## Features

1. The Students can create their profile on managED portal. They can add details such as the skills they know, the projects they have worked on, their work experience(Internships), Certificate courses and Academic details.
2. The Admin User (placement officer) can create an interview opening on the portal and search for students with required skills and the CGPA criteria. The admin can then add the students based on the query results.
3. Once an opening is created, the system automatically sends an email regarding the interview process to all the eligible students.
4. The students can then track their status by logging in to their accounts. The portal displays if the interview process is in progress, or if the student is selected or not.
5. The Web Application is responsive and therefore can be accessed through both mobile phone and desktop/laptop.

A copy of the application is deployed on heroku. Link : https://managed-ui.herokuapp.com/
Admin Credentials : Username - admin
                    Password - password

NOTE - Since the application is hosted on a free dyno of heroku, please wait for the application to load (about 1 to 2 minutes) for the first time.

## Screenshots:

<p float="left">
  <img src="https://user-images.githubusercontent.com/57250845/126905784-af249bf6-136f-4db5-81c5-ba52cb3fcb07.png" height="500" width="1000" />
  <img src="https://user-images.githubusercontent.com/57250845/126905809-eace410c-66a6-4b51-b10e-3f1ce7be3e80.png" height="500" width="1000" /> 
  <img src="https://user-images.githubusercontent.com/57250845/126905720-faf4badf-e675-4e78-a354-e62fd3257852.jpeg" width="200" />
  <img src="https://user-images.githubusercontent.com/57250845/126905750-9a16ac6d-8c55-4e2f-9b77-e43203154ca2.jpeg" width="200" />
</p>


## Video Link:

## Stack and Architecture

- The backend and the frontend are decoupled and are connected to each other via REST APIs.
- The backend follows MVC Architecture.
- The backend is purely built using Java Spring Boot.
- Java Version : 8
- Swagger is used for backend documentation : https://digigrad.herokuapp.com/swagger-ui.html


## Installation:
- Clone this repository to your local machine. 
- Open it using any Java IDE like IntelliJ. 
- Build the application
- Run the Application Class (src/main/java/com/abhinav/tutee/TuteeApplication.java)
