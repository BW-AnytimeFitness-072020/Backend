# Backend
API Documentation
BASE URL: https://dry-tundra-72055.herokuapp.com/

Attach endpoints to the end of the base URL in order to make HTTP Requests.
**Table of Contents:**
User registration and LOGIN
instructor registration and LOGIN
User GET and UPDATE
instructor GET and UPDATE
course CREATE, GET, and DELETE


|Requests|Endpoints|Description|
|---|---|---|
|POST Users Registration|/createnewuser|POST request to register new user|
|POST instructor Registration|/createinstructor|POST request to register new instructor|
|POST Users Login|/login|POST request to login new user|
|GET Add User Courses|/users/user/addcourse/{courseid}|GET request to add a course to users courselist|

|GET courses|/courses/courses|GET request to get all courses|
|PUT Users|/users/user/{userid}|PUT request to update/add user info|
|GET Course By ID|/courses/course/{courseid}|GET request to get course by given ID|
|DELETE Course by id|/courses/course/{courseid}|DELETE request to delete a course by id|
|DELETE User by id|/users/user/{userid}|DELETE request to delete a User by id|




**[POST] Registration for Users**

URL: https://dry-tundra-72055.herokuapp.com/createnewuser

**Request body should include:**
|Input|Input Type|
|---|---|
|username (required)|string|
|password (required)|string|
|email (required)|email|

An example of how the body should appear:
```
{
    "username": "allen",
    "password": "1234567",
    "email": "email@address.com"
}
```
You will recieve all of the user's information including info.
```
{
    "id": 3,
    "username": "allen",
    "email": "email@address.com"
}
```
**[POST] Login for Users**

URL: https://dry-tundra-72055.herokuapp.com/login

**Request body should include:**
|Input|Input Type|
|---|---|
|username (required)|string|
|password (required)|string|

An example of how the body should appear:
```
{
    "username": "allen",
    "password": "1234567"
}
```

**What will be returned:**
You will recieve the user id, username and a JWT.
```
{
    "id": 3,
    "username": "allen",
    "token" : "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjgsImlhdCI6MTU5MDUxNzcwNn0.oApQinTQPd2YuihjsSwk9WnMna6CfI95kx6rxh0-Jg4"
}
```
**[GET] Get Info for ALL Users (ADMIN ROLE ONLY)**

URL: https://dry-tundra-72055.herokuapp.com/users/users

**What will be returned:**
You will recieve an array of user objects with all their info.
```
[
    {
        "userid": 3,
        "username": "admin",
        "email": "admin@local.local",
        "instructorcourses": [
            {
                "courseid": 18,
                "coursename": "YOGA",
                "type": "cardio",
                "hasvalueforstarttime": true,
                "starttime": 8,
                "hasvalueforduration": true,
                "duration": 45,
                "intensitylevel": "Easy",
                "location": "Michigan",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 55,
                "users": [
                    {
                        "user": {
                            "userid": 6,
                            "username": "puttat",
                            "email": "puttat@school.lambda",
                            "instructorcourses": [],
                            "roles": [
                                {
                                    "role": {
                                        "roleid": 2,
                                        "name": "USER"
                                    }
                                }
                            ]
                        }
                    },
                    {
                        "user": {
                            "userid": 4,
                            "username": "cinnamon",
                            "email": "cinnamon@local.local",
                            "instructorcourses": [],
                            "roles": [
                                {
                                    "role": {
                                        "roleid": 2,
                                        "name": "USER"
                                    }
                                }
                            ]
                        }
                    }
                ]
            },
            {
                "courseid": 11,
                "coursename": "Zoomba",
                "type": "Cardio",
                "hasvalueforstarttime": true,
                "starttime": 12,
                "hasvalueforduration": true,
                "duration": 50,
                "intensitylevel": "Medium",
                "location": "Florida",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 25,
                "users": [
                    {
                        "user": {
                            "userid": 6,
                            "username": "puttat",
                            "email": "puttat@school.lambda",
                            "instructorcourses": [],
                            "roles": [
                                {
                                    "role": {
                                        "roleid": 2,
                                        "name": "USER"
                                    }
                                }
                            ]
                        }
                    },
                    {
                        "user": {
                            "userid": 7,
                            "username": "misskitty",
                            "email": "misskitty@local.local",
                            "instructorcourses": [
                                {
                                    "courseid": 12,
                                    "coursename": "Wing Chun",
                                    "type": "Combat",
                                    "hasvalueforstarttime": true,
                                    "starttime": 6,
                                    "hasvalueforduration": true,
                                    "duration": 45,
                                    "intensitylevel": "Easy",
                                    "location": "Virginia",
                                    "hasvalueforsizecapacity": true,
                                    "sizecapacity": 15,
                                    "users": []
                                },
                                {
                                    "courseid": 17,
                                    "coursename": "Jiu Jitsu",
                                    "type": "Combat",
                                    "hasvalueforstarttime": true,
                                    "starttime": 19,
                                    "hasvalueforduration": true,
                                    "duration": 30,
                                    "intensitylevel": "Hard",
                                    "location": "Brazil",
                                    "hasvalueforsizecapacity": true,
                                    "sizecapacity": 110,
                                    "users": []
                                },
                                {
                                    "courseid": 16,
                                    "coursename": "Hip Hop",
                                    "type": "Dance",
                                    "hasvalueforstarttime": true,
                                    "starttime": 9,
                                    "hasvalueforduration": true,
                                    "duration": 60,
                                    "intensitylevel": "Easy",
                                    "location": "Texas",
                                    "hasvalueforsizecapacity": true,
                                    "sizecapacity": 45,
                                    "users": []
                                }
                            ],
                            "roles": [
                                {
                                    "role": {
                                        "roleid": 1,
                                        "name": "ADMIN"
                                    }
                                }
                            ]
                        }
                    }
                ]
            },
            {
                "courseid": 15,
                "coursename": "Ballet",
                "type": "Dance",
                "hasvalueforstarttime": true,
                "starttime": 13,
                "hasvalueforduration": true,
                "duration": 50,
                "intensitylevel": "Hard",
                "location": "New Jersey",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 25,
                "users": []
            }
        ],
        "roles": [
            {
                "role": {
                    "roleid": 1,
                    "name": "ADMIN"
                }
            },
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "courses": []
    },
    {
        "userid": 4,
        "username": "cinnamon",
        "email": "cinnamon@local.local",
        "instructorcourses": [],
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "courses": [
            {
                "course": {
                    "courseid": 8,
                    "coursename": null,
                    "type": null,
                    "hasvalueforstarttime": false,
                    "starttime": 0,
                    "hasvalueforduration": false,
                    "duration": 0,
                    "intensitylevel": null,
                    "location": null,
                    "hasvalueforsizecapacity": false,
                    "sizecapacity": 0,
                    "instructor": null
                }
            },
            {
                "course": {
                    "courseid": 18,
                    "coursename": "YOGA",
                    "type": "cardio",
                    "hasvalueforstarttime": true,
                    "starttime": 8,
                    "hasvalueforduration": true,
                    "duration": 45,
                    "intensitylevel": "Easy",
                    "location": "Michigan",
                    "hasvalueforsizecapacity": true,
                    "sizecapacity": 55,
                    "instructor": {
                        "userid": 3,
                        "username": "admin",
                        "email": "admin@local.local",
                        "roles": [
                            {
                                "role": {
                                    "roleid": 1,
                                    "name": "ADMIN"
                                }
                            },
                            {
                                "role": {
                                    "roleid": 2,
                                    "name": "USER"
                                }
                            }
                        ]
                    }
                }
            },
            {
                "course": {
                    "courseid": 19,
                    "coursename": "HIIT",
                    "type": "Cardio",
                    "hasvalueforstarttime": true,
                    "starttime": 19,
                    "hasvalueforduration": true,
                    "duration": 30,
                    "intensitylevel": "Medium",
                    "location": "Kentucky",
                    "hasvalueforsizecapacity": true,
                    "sizecapacity": 105,
                    "instructor": {
                        "userid": 5,
                        "username": "barnbarn",
                        "email": "barnbarn@local.local",
                        "roles": [
                            {
                                "role": {
                                    "roleid": 1,
                                    "name": "ADMIN"
                                }
                            }
                        ]
                    }
                }
            }
        ]
    },
    {
        "userid": 5,
        "username": "barnbarn",
        "email": "barnbarn@local.local",
        "instructorcourses": [
            {
                "courseid": 13,
                "coursename": "Tibo",
                "type": "Cardio",
                "hasvalueforstarttime": true,
                "starttime": 19,
                "hasvalueforduration": true,
                "duration": 30,
                "intensitylevel": "Medium",
                "location": "California",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 100,
                "users": [
                    {
                        "user": {
                            "userid": 7,
                            "username": "misskitty",
                            "email": "misskitty@local.local",
                            "instructorcourses": [
                                {
                                    "courseid": 12,
                                    "coursename": "Wing Chun",
                                    "type": "Combat",
                                    "hasvalueforstarttime": true,
                                    "starttime": 6,
                                    "hasvalueforduration": true,
                                    "duration": 45,
                                    "intensitylevel": "Easy",
                                    "location": "Virginia",
                                    "hasvalueforsizecapacity": true,
                                    "sizecapacity": 15,
                                    "users": []
                                },
                                {
                                    "courseid": 17,
                                    "coursename": "Jiu Jitsu",
                                    "type": "Combat",
                                    "hasvalueforstarttime": true,
                                    "starttime": 19,
                                    "hasvalueforduration": true,
                                    "duration": 30,
                                    "intensitylevel": "Hard",
                                    "location": "Brazil",
                                    "hasvalueforsizecapacity": true,
                                    "sizecapacity": 110,
                                    "users": []
                                },
                                {
                                    "courseid": 16,
                                    "coursename": "Hip Hop",
                                    "type": "Dance",
                                    "hasvalueforstarttime": true,
                                    "starttime": 9,
                                    "hasvalueforduration": true,
                                    "duration": 60,
                                    "intensitylevel": "Easy",
                                    "location": "Texas",
                                    "hasvalueforsizecapacity": true,
                                    "sizecapacity": 45,
                                    "users": []
                                }
                            ],
                            "roles": [
                                {
                                    "role": {
                                        "roleid": 1,
                                        "name": "ADMIN"
                                    }
                                }
                            ]
                        }
                    }
                ]
            },
            {
                "courseid": 19,
                "coursename": "HIIT",
                "type": "Cardio",
                "hasvalueforstarttime": true,
                "starttime": 19,
                "hasvalueforduration": true,
                "duration": 30,
                "intensitylevel": "Medium",
                "location": "Kentucky",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 105,
                "users": [
                    {
                        "user": {
                            "userid": 4,
                            "username": "cinnamon",
                            "email": "cinnamon@local.local",
                            "instructorcourses": [],
                            "roles": [
                                {
                                    "role": {
                                        "roleid": 2,
                                        "name": "USER"
                                    }
                                }
                            ]
                        }
                    }
                ]
            },
            {
                "courseid": 14,
                "coursename": "YOGA",
                "type": "cardio",
                "hasvalueforstarttime": true,
                "starttime": 8,
                "hasvalueforduration": true,
                "duration": 45,
                "intensitylevel": "Easy",
                "location": "Indiana",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 55,
                "users": []
            },
            {
                "courseid": 20,
                "coursename": "Parkour",
                "type": "Cardio",
                "hasvalueforstarttime": true,
                "starttime": 17,
                "hasvalueforduration": true,
                "duration": 80,
                "intensitylevel": "Hard",
                "location": "New York",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 55,
                "users": []
            }
        ],
        "roles": [
            {
                "role": {
                    "roleid": 1,
                    "name": "ADMIN"
                }
            }
        ],
        "courses": []
    },
    {
        "userid": 6,
        "username": "puttat",
        "email": "puttat@school.lambda",
        "instructorcourses": [],
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "courses": [
            {
                "course": {
                    "courseid": 9,
                    "coursename": null,
                    "type": null,
                    "hasvalueforstarttime": false,
                    "starttime": 0,
                    "hasvalueforduration": false,
                    "duration": 0,
                    "intensitylevel": null,
                    "location": null,
                    "hasvalueforsizecapacity": false,
                    "sizecapacity": 0,
                    "instructor": null
                }
            },
            {
                "course": {
                    "courseid": 11,
                    "coursename": "Zoomba",
                    "type": "Cardio",
                    "hasvalueforstarttime": true,
                    "starttime": 12,
                    "hasvalueforduration": true,
                    "duration": 50,
                    "intensitylevel": "Medium",
                    "location": "Florida",
                    "hasvalueforsizecapacity": true,
                    "sizecapacity": 25,
                    "instructor": {
                        "userid": 3,
                        "username": "admin",
                        "email": "admin@local.local",
                        "roles": [
                            {
                                "role": {
                                    "roleid": 1,
                                    "name": "ADMIN"
                                }
                            },
                            {
                                "role": {
                                    "roleid": 2,
                                    "name": "USER"
                                }
                            }
                        ]
                    }
                }
            },
            {
                "course": {
                    "courseid": 18,
                    "coursename": "YOGA",
                    "type": "cardio",
                    "hasvalueforstarttime": true,
                    "starttime": 8,
                    "hasvalueforduration": true,
                    "duration": 45,
                    "intensitylevel": "Easy",
                    "location": "Michigan",
                    "hasvalueforsizecapacity": true,
                    "sizecapacity": 55,
                    "instructor": {
                        "userid": 3,
                        "username": "admin",
                        "email": "admin@local.local",
                        "roles": [
                            {
                                "role": {
                                    "roleid": 1,
                                    "name": "ADMIN"
                                }
                            },
                            {
                                "role": {
                                    "roleid": 2,
                                    "name": "USER"
                                }
                            }
                        ]
                    }
                }
            }
        ]
    },
    {
        "userid": 7,
        "username": "misskitty",
        "email": "misskitty@local.local",
        "instructorcourses": [
            {
                "courseid": 12,
                "coursename": "Wing Chun",
                "type": "Combat",
                "hasvalueforstarttime": true,
                "starttime": 6,
                "hasvalueforduration": true,
                "duration": 45,
                "intensitylevel": "Easy",
                "location": "Virginia",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 15,
                "users": []
            },
            {
                "courseid": 17,
                "coursename": "Jiu Jitsu",
                "type": "Combat",
                "hasvalueforstarttime": true,
                "starttime": 19,
                "hasvalueforduration": true,
                "duration": 30,
                "intensitylevel": "Hard",
                "location": "Brazil",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 110,
                "users": []
            },
            {
                "courseid": 16,
                "coursename": "Hip Hop",
                "type": "Dance",
                "hasvalueforstarttime": true,
                "starttime": 9,
                "hasvalueforduration": true,
                "duration": 60,
                "intensitylevel": "Easy",
                "location": "Texas",
                "hasvalueforsizecapacity": true,
                "sizecapacity": 45,
                "users": []
            }
        ],
        "roles": [
            {
                "role": {
                    "roleid": 1,
                    "name": "ADMIN"
                }
            }
        ],
        "courses": [
            {
                "course": {
                    "courseid": 10,
                    "coursename": null,
                    "type": null,
                    "hasvalueforstarttime": false,
                    "starttime": 0,
                    "hasvalueforduration": false,
                    "duration": 0,
                    "intensitylevel": null,
                    "location": null,
                    "hasvalueforsizecapacity": false,
                    "sizecapacity": 0,
                    "instructor": null
                }
            },
            {
                "course": {
                    "courseid": 11,
                    "coursename": "Zoomba",
                    "type": "Cardio",
                    "hasvalueforstarttime": true,
                    "starttime": 12,
                    "hasvalueforduration": true,
                    "duration": 50,
                    "intensitylevel": "Medium",
                    "location": "Florida",
                    "hasvalueforsizecapacity": true,
                    "sizecapacity": 25,
                    "instructor": {
                        "userid": 3,
                        "username": "admin",
                        "email": "admin@local.local",
                        "roles": [
                            {
                                "role": {
                                    "roleid": 1,
                                    "name": "ADMIN"
                                }
                            },
                            {
                                "role": {
                                    "roleid": 2,
                                    "name": "USER"
                                }
                            }
                        ]
                    }
                }
            },
            {
                "course": {
                    "courseid": 13,
                    "coursename": "Tibo",
                    "type": "Cardio",
                    "hasvalueforstarttime": true,
                    "starttime": 19,
                    "hasvalueforduration": true,
                    "duration": 30,
                    "intensitylevel": "Medium",
                    "location": "California",
                    "hasvalueforsizecapacity": true,
                    "sizecapacity": 100,
                    "instructor": {
                        "userid": 5,
                        "username": "barnbarn",
                        "email": "barnbarn@local.local",
                        "roles": [
                            {
                                "role": {
                                    "roleid": 1,
                                    "name": "ADMIN"
                                }
                            }
                        ]
                    }
                }
            }
        ]
    }
]
```

**[Patch] Update info for User based on the User's Id**

URL: https://dry-tundra-72055.herokuapp.com/users/user/:id



An example of how the body should appear:
```
{
  "courses": [
    {
      "course": {
        "courseid": 0,
        "coursename": "string",
        "duration": 0,
        "hasvalueforduration": true,
        "hasvalueforsizecapacity": true,
        "hasvalueforstarttime": true,
        "intensitylevel": "string",
        "location": "string",
        "sizecapacity": 0,
        "starttime": 0,
        "type": "string",
        "users": [
          null
        ]
      }
    }
  ],
  "email": "string",
  "instructorcourses": [
    {
      "courseid": 0,
      "coursename": "string",
      "duration": 0,
      "hasvalueforduration": true,
      "hasvalueforsizecapacity": true,
      "hasvalueforstarttime": true,
      "intensitylevel": "string",
      "location": "string",
      "sizecapacity": 0,
      "starttime": 0,
      "type": "string",
      "users": [
        null
      ]
    }
  ],
  "password": "string",
  "passwordNoEncrypt": "string",
  "roles": [
    {
      "role": {
        "name": "string",
        "roleid": 0,
        "users": [
          null
        ]
      }
    }
  ],
  "userid": 0,
  "username": "string"
}
```

**What will be returned:**
HttpStatus of:.
```
200: OK,

204: No Content

401: Unauthorized

or

403: Forbidden

```

**[GET] Get Info for ALL Courses**

URL: https://dry-tundra-72055.herokuapp.com/courses/courses

**What will be returned:**
You will recieve an array of Course objects with all their info.
```
[
    {
        "courseid": 8,
        "coursename": null,
        "type": null,
        "hasvalueforstarttime": false,
        "starttime": 0,
        "hasvalueforduration": false,
        "duration": 0,
        "intensitylevel": null,
        "location": null,
        "hasvalueforsizecapacity": false,
        "sizecapacity": 0,
        "instructor": null,
        "users": [
            {
                "user": {
                    "userid": 4,
                    "username": "cinnamon",
                    "email": "cinnamon@local.local",
                    "instructorcourses": [],
                    "roles": [
                        {
                            "role": {
                                "roleid": 2,
                                "name": "USER"
                            }
                        }
                    ]
                }
            }
        ]
    },
    {
        "courseid": 9,
        "coursename": null,
        "type": null,
        "hasvalueforstarttime": false,
        "starttime": 0,
        "hasvalueforduration": false,
        "duration": 0,
        "intensitylevel": null,
        "location": null,
        "hasvalueforsizecapacity": false,
        "sizecapacity": 0,
        "instructor": null,
        "users": [
            {
                "user": {
                    "userid": 6,
                    "username": "puttat",
                    "email": "puttat@school.lambda",
                    "instructorcourses": [],
                    "roles": [
                        {
                            "role": {
                                "roleid": 2,
                                "name": "USER"
                            }
                        }
                    ]
                }
            }
        ]
    },
    {
        "courseid": 10,
        "coursename": null,
        "type": null,
        "hasvalueforstarttime": false,
        "starttime": 0,
        "hasvalueforduration": false,
        "duration": 0,
        "intensitylevel": null,
        "location": null,
        "hasvalueforsizecapacity": false,
        "sizecapacity": 0,
        "instructor": null,
        "users": [
            {
                "user": {
                    "userid": 7,
                    "username": "misskitty",
                    "email": "misskitty@local.local",
                    "instructorcourses": [
                        {
                            "courseid": 17,
                            "coursename": "Jiu Jitsu",
                            "type": "Combat",
                            "hasvalueforstarttime": true,
                            "starttime": 19,
                            "hasvalueforduration": true,
                            "duration": 30,
                            "intensitylevel": "Hard",
                            "location": "Brazil",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 110,
                            "users": []
                        },
                        {
                            "courseid": 12,
                            "coursename": "Wing Chun",
                            "type": "Combat",
                            "hasvalueforstarttime": true,
                            "starttime": 6,
                            "hasvalueforduration": true,
                            "duration": 45,
                            "intensitylevel": "Easy",
                            "location": "Virginia",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 15,
                            "users": []
                        },
                        {
                            "courseid": 16,
                            "coursename": "Hip Hop",
                            "type": "Dance",
                            "hasvalueforstarttime": true,
                            "starttime": 9,
                            "hasvalueforduration": true,
                            "duration": 60,
                            "intensitylevel": "Easy",
                            "location": "Texas",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 45,
                            "users": []
                        }
                    ],
                    "roles": [
                        {
                            "role": {
                                "roleid": 1,
                                "name": "ADMIN"
                            }
                        }
                    ]
                }
            }
        ]
    },
    {
        "courseid": 11,
        "coursename": "Zoomba",
        "type": "Cardio",
        "hasvalueforstarttime": true,
        "starttime": 12,
        "hasvalueforduration": true,
        "duration": 50,
        "intensitylevel": "Medium",
        "location": "Florida",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 25,
        "instructor": {
            "userid": 3,
            "username": "admin",
            "email": "admin@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                },
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                }
            ]
        },
        "users": [
            {
                "user": {
                    "userid": 6,
                    "username": "puttat",
                    "email": "puttat@school.lambda",
                    "instructorcourses": [],
                    "roles": [
                        {
                            "role": {
                                "roleid": 2,
                                "name": "USER"
                            }
                        }
                    ]
                }
            },
            {
                "user": {
                    "userid": 7,
                    "username": "misskitty",
                    "email": "misskitty@local.local",
                    "instructorcourses": [
                        {
                            "courseid": 17,
                            "coursename": "Jiu Jitsu",
                            "type": "Combat",
                            "hasvalueforstarttime": true,
                            "starttime": 19,
                            "hasvalueforduration": true,
                            "duration": 30,
                            "intensitylevel": "Hard",
                            "location": "Brazil",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 110,
                            "users": []
                        },
                        {
                            "courseid": 12,
                            "coursename": "Wing Chun",
                            "type": "Combat",
                            "hasvalueforstarttime": true,
                            "starttime": 6,
                            "hasvalueforduration": true,
                            "duration": 45,
                            "intensitylevel": "Easy",
                            "location": "Virginia",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 15,
                            "users": []
                        },
                        {
                            "courseid": 16,
                            "coursename": "Hip Hop",
                            "type": "Dance",
                            "hasvalueforstarttime": true,
                            "starttime": 9,
                            "hasvalueforduration": true,
                            "duration": 60,
                            "intensitylevel": "Easy",
                            "location": "Texas",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 45,
                            "users": []
                        }
                    ],
                    "roles": [
                        {
                            "role": {
                                "roleid": 1,
                                "name": "ADMIN"
                            }
                        }
                    ]
                }
            }
        ]
    },
    {
        "courseid": 12,
        "coursename": "Wing Chun",
        "type": "Combat",
        "hasvalueforstarttime": true,
        "starttime": 6,
        "hasvalueforduration": true,
        "duration": 45,
        "intensitylevel": "Easy",
        "location": "Virginia",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 15,
        "instructor": {
            "userid": 7,
            "username": "misskitty",
            "email": "misskitty@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ]
        },
        "users": []
    },
    {
        "courseid": 13,
        "coursename": "Tibo",
        "type": "Cardio",
        "hasvalueforstarttime": true,
        "starttime": 19,
        "hasvalueforduration": true,
        "duration": 30,
        "intensitylevel": "Medium",
        "location": "California",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 100,
        "instructor": {
            "userid": 5,
            "username": "barnbarn",
            "email": "barnbarn@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ]
        },
        "users": [
            {
                "user": {
                    "userid": 7,
                    "username": "misskitty",
                    "email": "misskitty@local.local",
                    "instructorcourses": [
                        {
                            "courseid": 17,
                            "coursename": "Jiu Jitsu",
                            "type": "Combat",
                            "hasvalueforstarttime": true,
                            "starttime": 19,
                            "hasvalueforduration": true,
                            "duration": 30,
                            "intensitylevel": "Hard",
                            "location": "Brazil",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 110,
                            "users": []
                        },
                        {
                            "courseid": 12,
                            "coursename": "Wing Chun",
                            "type": "Combat",
                            "hasvalueforstarttime": true,
                            "starttime": 6,
                            "hasvalueforduration": true,
                            "duration": 45,
                            "intensitylevel": "Easy",
                            "location": "Virginia",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 15,
                            "users": []
                        },
                        {
                            "courseid": 16,
                            "coursename": "Hip Hop",
                            "type": "Dance",
                            "hasvalueforstarttime": true,
                            "starttime": 9,
                            "hasvalueforduration": true,
                            "duration": 60,
                            "intensitylevel": "Easy",
                            "location": "Texas",
                            "hasvalueforsizecapacity": true,
                            "sizecapacity": 45,
                            "users": []
                        }
                    ],
                    "roles": [
                        {
                            "role": {
                                "roleid": 1,
                                "name": "ADMIN"
                            }
                        }
                    ]
                }
            }
        ]
    },
    {
        "courseid": 14,
        "coursename": "YOGA",
        "type": "cardio",
        "hasvalueforstarttime": true,
        "starttime": 8,
        "hasvalueforduration": true,
        "duration": 45,
        "intensitylevel": "Easy",
        "location": "Indiana",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 55,
        "instructor": {
            "userid": 5,
            "username": "barnbarn",
            "email": "barnbarn@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ]
        },
        "users": []
    },
    {
        "courseid": 15,
        "coursename": "Ballet",
        "type": "Dance",
        "hasvalueforstarttime": true,
        "starttime": 13,
        "hasvalueforduration": true,
        "duration": 50,
        "intensitylevel": "Hard",
        "location": "New Jersey",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 25,
        "instructor": {
            "userid": 3,
            "username": "admin",
            "email": "admin@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                },
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                }
            ]
        },
        "users": []
    },
    {
        "courseid": 16,
        "coursename": "Hip Hop",
        "type": "Dance",
        "hasvalueforstarttime": true,
        "starttime": 9,
        "hasvalueforduration": true,
        "duration": 60,
        "intensitylevel": "Easy",
        "location": "Texas",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 45,
        "instructor": {
            "userid": 7,
            "username": "misskitty",
            "email": "misskitty@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ]
        },
        "users": []
    },
    {
        "courseid": 17,
        "coursename": "Jiu Jitsu",
        "type": "Combat",
        "hasvalueforstarttime": true,
        "starttime": 19,
        "hasvalueforduration": true,
        "duration": 30,
        "intensitylevel": "Hard",
        "location": "Brazil",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 110,
        "instructor": {
            "userid": 7,
            "username": "misskitty",
            "email": "misskitty@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ]
        },
        "users": []
    },
    {
        "courseid": 18,
        "coursename": "YOGA",
        "type": "cardio",
        "hasvalueforstarttime": true,
        "starttime": 8,
        "hasvalueforduration": true,
        "duration": 45,
        "intensitylevel": "Easy",
        "location": "Michigan",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 55,
        "instructor": {
            "userid": 3,
            "username": "admin",
            "email": "admin@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                },
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                }
            ]
        },
        "users": [
            {
                "user": {
                    "userid": 6,
                    "username": "puttat",
                    "email": "puttat@school.lambda",
                    "instructorcourses": [],
                    "roles": [
                        {
                            "role": {
                                "roleid": 2,
                                "name": "USER"
                            }
                        }
                    ]
                }
            },
            {
                "user": {
                    "userid": 4,
                    "username": "cinnamon",
                    "email": "cinnamon@local.local",
                    "instructorcourses": [],
                    "roles": [
                        {
                            "role": {
                                "roleid": 2,
                                "name": "USER"
                            }
                        }
                    ]
                }
            }
        ]
    },
    {
        "courseid": 19,
        "coursename": "HIIT",
        "type": "Cardio",
        "hasvalueforstarttime": true,
        "starttime": 19,
        "hasvalueforduration": true,
        "duration": 30,
        "intensitylevel": "Medium",
        "location": "Kentucky",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 105,
        "instructor": {
            "userid": 5,
            "username": "barnbarn",
            "email": "barnbarn@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ]
        },
        "users": [
            {
                "user": {
                    "userid": 4,
                    "username": "cinnamon",
                    "email": "cinnamon@local.local",
                    "instructorcourses": [],
                    "roles": [
                        {
                            "role": {
                                "roleid": 2,
                                "name": "USER"
                            }
                        }
                    ]
                }
            }
        ]
    },
    {
        "courseid": 20,
        "coursename": "Parkour",
        "type": "Cardio",
        "hasvalueforstarttime": true,
        "starttime": 17,
        "hasvalueforduration": true,
        "duration": 80,
        "intensitylevel": "Hard",
        "location": "New York",
        "hasvalueforsizecapacity": true,
        "sizecapacity": 55,
        "instructor": {
            "userid": 5,
            "username": "barnbarn",
            "email": "barnbarn@local.local",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ]
        },
        "users": []
    }
]
```

**[DELETE] Remove Course from database based on the courseId (ADMIN ROLE ONLY**

URL: https://dry-tundra-72055.herokuapp.com/courses/course/:id
**What will be returned:**
You will recieve a message object that the strain was deleted.
```
200: OK 

204: No Content

401: Unauthorized

or

Forbidden
```
