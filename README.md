# Java Springboot RESTAPI

## Introduction
> Adalah sebuah simple project membuat CRUD data Product menggunakan Spring Boot.

## Prerequisites
1. Maven Build Tool
2. OpenJDK
3. IDE (Intelljidea)


### Project ini didevelop menggunakan :
OpenJDK 11
Spring v2.3.5


## Installation

````
git clone https://github.com/odianto/product-rest-api.git
````
kemudian bisa Run Application.java menggunakan Intelljidea, atau bisa langsung di build dengan sintak
````
mvn clean install
````

## API Documentation
### Swagger UI
````
http://localhost:8080/swagger-ui/index.html#
````

### List API & Contoh Request Body
1. Get All Product (GET)
    ````
    http://localhost:8080/api/products/getAllProduct
    ````
2. Find Product (GET)
    ````
    http://localhost:8080/api/products/findProduct/P0001
    ````   
3. Create Product (POST)
    ````
    http://localhost:8080/api/products/createProduct
    ```` 
    ````
    {
      "productId": "P0003",
      "productName": "Test",
      "productDescription": "Test",
      "price": 65000,
      "variety": "Test",
      "rating": 8.2,
      "stock": 100
    }
    ```` 
4. Update Product (POST)
    ````
    http://localhost:8080/api/products/updateProduct
    ```` 
    ````
    {
      "productId": "P0003",
      "productName": "",
      "productDescription": "Update",
      "price": 0,
      "variety": "",
      "rating": 0,
      "stock": 0
    }
    ```` 
5. Delete Product (GET
    ````
    http://localhost:8080/api/products/deleteProduct/P0003
    ````