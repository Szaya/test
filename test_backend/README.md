## How to use the project

1. Open a terminal in the /test_backend folder
2. `mvn clean install`
3. Open Eclipse or any other IDE
4. Import the pom as existing maven project or open folder as project in IntelliJ
5. Alt + F5 in case of Eclipse IDE

## Back-end module assignment

  * The student’s task to fulfill the `com.epam.training.test_backend.tests.SportsBettingBackEndTest` class’ homeworkTest method!
  * The `com.epam.training.test_backend.model` package’s _Event_ and _Bet_ classes shall be used!
  * The `com.epam.training.test_backend.endpointactions` package’s _Events_ class contains the unfinished endpoint actions. The two endpoints are already given but the proper caller methods of them is left for the students!

The result is considered successful if the student fulfilled the model classes, finished the endpoint actions and the given asserts are passed during execution.
For the proper solution the generic list result usage is unavoidable (for further details see the presentation’s 8th slide!)
There is no need to modify default values or create new ones!
The deadline is 3rd of December 2019.

#### The two request URLs and the corresponding JSON responses are:
 * http://localhost:8080/sportsbetting-web/loadEvents
```
[ 
   { 
      "id":2,
      "title":"Fradi vs UTE",
      "type":"Football Match",
      "start":[ 
         2018,
         10,
         30,
         16,
         48,
         58,
         837000000
      ],
      "end":[ 
         2018,
         10,
         30,
         18,
         48,
         58,
         839000000
      ]
   }
]
```

 * http://localhost:8080/sportsbetting-web/loadBets 
```
[ 
   { 
      "id":15,
      "description":"Fradi Ute win bet",
      "type":"Win bet"
   },
   { 
      "id":16,
      "description":"Fradi Ute goals bet",
      "type":"All goals bet"
   }
]
```

***
## Contact: 
In case of question or remark please do not hesitate to reach out for me on [this](mailto:akos_osvald@epam.com) e-mail address!
