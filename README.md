# springboot-crud-app-with-postgresql

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

Technology Used
---------------
1. Java
2. Spring Boot
3. Spring Data JPA
4. PostgreSQL
5. FlyWay
