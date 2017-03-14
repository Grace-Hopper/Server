# Recepies
## HTTP method allowed

|  Method  |              Description                  |
| -------- | ----------------------------------------- |
| `GET`    | Get a resource or get a list of resources |
| `POST`   | Create a control                          |
| `PUT`    | Update (next version)                     |
| `DELETE` | Delete a resource                         |
## Code Response

|  Code  |                         Description                          |
| ------ | ------------------------------------------------------------ |
| `200`  | Success                                                      |
| `201`  | Success - new resource build.                                |
| `204`  | Success - there is not a resource to response                |
| `400`  | Bad Request - i.e. invalid request                           |
| `401`  | Unauthorized - no token for this resource                    |
| `404`  | Not Found - resource doesn't exist                           |
| `422`  | Unprocessable Entity - i.e. validation error                 |
| `429`  | Request exceeded the limit                                   |
| `500`  | Server error                                                 |
| `503`  | Server holidays                                              |
## API endpoints
### Get user
*[GET] /api/user/{id}
### Create a new user
*[POST] /api/user
### Login user
*[POST] /api/user/{username}/{pass}
### Get recepies
*[GET] /api/recepies

[GET] /api/recepies/{query}

*[GET] /api/recepie/{id}
### Update recepies
[PUT] /api/recepie/{id}
### Delete recepies
[DELETE] /api/recepie/{id}
### Create a new recepies
[POST] /api/recepie
