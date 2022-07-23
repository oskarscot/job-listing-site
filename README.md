# What is this?
This is a simple job listing website featuring a web api and a frontend which I made whilst learning Spring Boot and Vue.js. I want to expend it to feature profiles and many other features which I want to work on as I learn. This project is a bit of a playground for learning and improving my skills.

# Features
- [x] Basic web API
- [ ] Basic frontend
- [ ] Profile system
- [ ] Job listing page
- [ ] Company panel (publishing offers, reviewing applicants)

# Web API
The web API is a simple REST API which is used to communicate with the frontend.

Simple GET request:
```
http://localhost:8080/api/v1/listing
```
Response:
```json
[
    {
        "id": "62dc2b65ea85f94e8fc33860",
        "name": "Team Member",
        "description": "Make a burger",
        "salary": 7.5,
        "jobType": "Full-Time",
        "location": "Kirkcaldy, Scotland",
        "employer": "McDonald's",
        "posted": "2022-07-23T16:51:44.169Z"
    },
    {
        "id": "62dc3a52fea7a56a4d46927f",
        "name": "Barista",
        "description": "Make coffee and serve customers",
        "salary": 10.0,
        "jobType": "Full-Time",
        "location": "Kirkcaldy, Scotland",
        "employer": "Starbucks",
        "posted": "2022-07-23T16:51:44.169Z"
    }
]
```

Get a specific job listing:
```
http://localhost:8080/api/v1/listing/62dc2b65ea85f94e8fc33860
```

Reponse:
```json
{
    "id": "62dc2b65ea85f94e8fc33860",
    "name": "Team Member",
    "description": "Make a burger",
    "salary": 7.5,
    "jobType": "Full-Time",
    "location": "Kirkcaldy, Scotland",
    "employer": "McDonald's",
    "posted": "2022-07-23T16:51:44.169Z"
}
```

Delete a job listing:
```
http://localhost:8080/api/v1/listing/62dc2b65ea85f94e8fc33860
```

Response is just 200 OK if successful or error otherwise.

Adding a job listing:
```
http://localhost:8080/api/v1/listing
```

Body:
```json
{
    "name": "Team Member",
    "description": "Make a burger",
    "salary": 7.5,
    "jobType": "Full-Time",
    "location": "Kirkcaldy, Scotland",
    "employer": "McDonald's",
    "posted": "2022-07-23T16:51:44.169Z"
}
```

Response is 200 OK if successful or error otherwise.
