# Getting started

## Generate services production files with Maven  

### Run below command  

 `mvnw -X package`

## Run database service with Docker  

 `docker run --rm -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=books -p 3306:3306 -d mysql:8.0.22`  

## Run app from a terminal  

`java -jar target\rest_db_auth-0.0.1-SNAPSHOT.jar`  

## The app will be served at `http:\\localhost:8443\`

# How to use it  

## Anonimous user  

### Allowed to get ID and title of all books  

  `curl --location --request GET 'https://localhost:8443/api/v1/books/basic'`

### Allowed to get all comments and info of a book

  `curl --location --request GET 'https://localhost:8443/api/v1/books/1'`

## Role user (all above +)  

### Allowed to get all books information  

  `curl --location --request GET 'https://localhost:8443/api/v1/books/' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQYWJsbyIsImlhdCI6MTY3Mzk2MzkwNywiZXhwIjoxNjc0MDUwMzA3fQ.aEqiEYwrgFY-FNgCvDOuj-tmeAsip3nhi94q3BzCBUvgrzbBrwcLUDrlWfnnRCq8NWkYgfbKDbqK2Xw7fnYwuQ'`

### Allowed to create a new book  

  `curl --location --request POST 'https://localhost:8443/api/v1/books/' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQYWJsbyIsImlhdCI6MTY3Mzk2MzkwNywiZXhwIjoxNjc0MDUwMzA3fQ.aEqiEYwrgFY-FNgCvDOuj-tmeAsip3nhi94q3BzCBUvgrzbBrwcLUDrlWfnnRCq8NWkYgfbKDbqK2Xw7fnYwuQ' --header 'Content-Type: application/json' --data-raw '{
    "title" : "libro 3",
    "summary" : "string",
    "author" : "string",
    "publisher": "string",
    "date" : "string"
    }'`

### Allowed to post a comment

  `curl --location --request POST 'https://localhost:8443/api/v1/comments/' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQYWJsbyIsImlhdCI6MTY3Mzk2MzkwNywiZXhwIjoxNjc0MDUwMzA3fQ.aEqiEYwrgFY-FNgCvDOuj-tmeAsip3nhi94q3BzCBUvgrzbBrwcLUDrlWfnnRCq8NWkYgfbKDbqK2Xw7fnYwuQ' \
--header 'Content-Type: application/json' \
--data-raw '{
    "text" : "libro 3",
    "rating" : 3,
    "userId" : 1,
    "bookId":1
}'`

### Allowed to get a single comment

`curl --location --request GET 'https://localhost:8443/api/v1/comments/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQYWJsbyIsImlhdCI6MTY3Mzk2MzkwNywiZXhwIjoxNjc0MDUwMzA3fQ.aEqiEYwrgFY-FNgCvDOuj-tmeAsip3nhi94q3BzCBUvgrzbBrwcLUDrlWfnnRCq8NWkYgfbKDbqK2Xw7fnYwuQ'`

## Role admin (all above +)

### Delete a book  

`curl --location --request DELETE 'https://localhost:8443/api/v1/books/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQYWJsbyIsImlhdCI6MTY3Mzk2MzkwNywiZXhwIjoxNjc0MDUwMzA3fQ.aEqiEYwrgFY-FNgCvDOuj-tmeAsip3nhi94q3BzCBUvgrzbBrwcLUDrlWfnnRCq8NWkYgfbKDbqK2Xw7fnYwuQ'`

### Delete a comment  

`curl --location --request DELETE 'https://localhost:8443/api/v1/comments/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQYWJsbyIsImlhdCI6MTY3Mzk2MzkwNywiZXhwIjoxNjc0MDUwMzA3fQ.aEqiEYwrgFY-FNgCvDOuj-tmeAsip3nhi94q3BzCBUvgrzbBrwcLUDrlWfnnRCq8NWkYgfbKDbqK2Xw7fnYwuQ'`
