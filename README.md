# springboot-crud-app-with-postgresql

<h2>SpringBoot Application to Perform CRUD operations for Users.</h2>

Technology Used
---------------
1. Java
2. Spring Boot
3. Spring Data JPA
4. PostgreSQL
5. FlyWay
6. Docker


Install PostgreSQL Using Docker
--------------------------------
>docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres:11

>docker exec postgres psql -U postgres -c"CREATE DATABASE testdb" postgres

Operations
----------
1. Create User
2. Fetch User By ID
3. Fetch All User
4. Update User By Id
5. Delete User By Id


API Endpoints
--------------
1. Create User (http://{HOST}:8080/user-app/api/v1/users  <b>POST</b>)
2. Get All Users (http://{HOST}:8080/user-app/api/v1/users  <b>GET</b>)
3. Get User By Id (http://{HOST}:8080/user-app/api/v1/users/{ID}  <b>GET</b>)
4. Update User By Id (http://{HOST}:8080/user-app/api/v1/users/{ID}  <b>PUT</b>)
5. Delete User By Id (http://{HOST}:8080/user-app/api/v1/users/{ID}  <b>DELETE</b>)
6. Delete All Users (http://{HOST}:8080/user-app/api/v1/users  <b>DELETE</b>)
