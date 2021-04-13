# Answers to the questions of Exercise 1 

   ## a) Identify a couple of examples on the use of AssertJ expressive methods chaining.
        AssertJ's chainning allows to evaluate a variety of things regarding the variable we are asserting.
        For example, when making an assertion over a String we can call .startsWith("<something>").isEqualToIgnoraingCase("<Something>") and many other methods available in their library in any order)

        Example1: 
        On the test named 'whenValidInput_thenCreateEmployee()' a tested is being made to verify if a post to the endpoint that is meant to insert a new employee in the DB is working properly. AssertJ is used in the following line of code: 'assertThat(found).extracting(Employee::getName).containsOnly("bob");'.
        The variable 'found' is defined previously and is a list of all the employees in the DB. In this case, AssertJ is using .extracting() to loop over the elements of the list and apply the method Employee.getName() and then verifying if the result contains only a single name that is "bob".

        Example2:
        On givenEmployees_whenGetEmployees_thenStatus200():
            'assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);' target of assertion is 'response.getStatusCode()'.
            In this line it is being asserted if the status code of the response is 200.

        Example3: 
        On the same test as the previous example:
            'assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");' is similar to example 1, but in this case it is verifying if there are exactly 2 names instead of one. And those 2 names must be "bob" and "alex".



   ## b) Identify an example in which you mock the behavior of the repository (and avoid involving a database).
        On the file 'EmployeeServiceUnitTest' several tests are being performed with a mocked repository. In this tests, we are verifying if the EmployeeService's methods are working properly while the behavior of the Repository involved is predetermined using Mockito. That means that the Service is being tested without the need to have an operating database and an implemented repository to access it.       


   ## c) What is the difference between standard @Mock and @MockBean?
          While @Mock comes from Mockito's library, @MockBean is from SpringBoots library.
          So, when programming tests, usually @Mock is the most adequated, however when we want to perform a test that involves dependencies from a SpringBoot Container and need to mock one of the container beans, @MockBean is the right choice. 


   ## d) What is the role of the file “application-integrationtest.properties”? In which conditions will it beused?
        This file is used to define the application-properties that the tests will obey. For instance, we might want to perform tests using a real database. In that case, we will define the usual properties that are required to connect to a database (url,username,password..etc.) in this file. And when the tests are run, any calls to the database will be fowarded to the database specified in the properties. 
   



