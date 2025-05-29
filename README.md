# Summary
The project has spring security to be able to create user.

### Docker
Start Docker with
```
docker-compose up
```

### MySQL
Export port: ```3306```
#### PhpMyAdmin
To be able to see the MySQL Database:
```http://localhost:9091```

Server: **mysql_db**  
User: **root**  
Password: **root**

## Postman curls
Add the password after run the project

#### Find all task
```
curl --location 'http://localhost:8080/api/tasks' \
--header 'Authorization: Basic dXNlcjo0NWU0MmFkMi04MTczLTQ0YmEtYTY2Ni03ZmQzYWVmZjE1MmU='
```

#### Find task by ID
```
curl --location 'http://localhost:8080/api/tasks/2' \
--header 'Authorization: Basic dXNlcjo0NWU0MmFkMi04MTczLTQ0YmEtYTY2Ni03ZmQzYWVmZjE1MmU='
```

#### Create task
```
curl --location 'http://localhost:8080/api/tasks' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjo0NWU0MmFkMi04MTczLTQ0YmEtYTY2Ni03ZmQzYWVmZjE1MmU=' \
--data '{
    "title": "Title 1",
    "description": "Description 1",
    "done": false,
    "uuid": "123456"
}'
```

#### Update task
```
curl --location --request PUT 'http://localhost:8080/api/tasks/4' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjo0NWU0MmFkMi04MTczLTQ0YmEtYTY2Ni03ZmQzYWVmZjE1MmU=' \
--data '{
    "title": "Title 14",
    "description": "Description 14",
    "done": false
}'
```

#### Update done task
```
curl --location --request PUT 'http://localhost:8080/api/tasks/4/true' \
--header 'Authorization: Basic dXNlcjo0NWU0MmFkMi04MTczLTQ0YmEtYTY2Ni03ZmQzYWVmZjE1MmU='
```

#### Delete task by Id
```
curl --location --request DELETE 'http://localhost:8080/api/tasks/1' \
--header 'Authorization: Basic dXNlcjo0NWU0MmFkMi04MTczLTQ0YmEtYTY2Ni03ZmQzYWVmZjE1MmU='
```

#### Get user
```
curl --location 'http://localhost:8080/api/users'
```

#### Create user
```
curl --location 'http://localhost:8080/api/users' \
--header 'Content-Type: application/json' \
--data '{
    "username": "lesyareth",
    "password": "12345",
    "admin": false
}'
```

## Images
Tasks table
![Task table](tasks.png)

Roles table
![Roles table](roles.png)

User table
![User table](users.png)

User roles table
![User Roles table](user_roles.png)