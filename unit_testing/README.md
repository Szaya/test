## Unit testing

Unit test tests a unit of code (methods)

##### Goals:
* correctness of new functionality
* correctness of old features after new functionlity is implemented or code was refactored
* can uncover design issues
* provide additional documentation to the code

##### Unit test needs to be
* _Fast_ - there can be a lot of tests, make them fast
* _Independet_ - test must not depend on each other's state/results
* _Repeatable_ - always gives the same result
* _Self-determinating_ - can decide about itself if test is successful
* _Timely_ - write test when you implement something, not later

##### Some general advices:
* use an existing testing framework, don't write your own
* don't mix testing frameworks
* read the documention of the framework

##### Mocking:
* replace external dependecies with mocks (fake object with defined behavior)
* use mock framework for this
* don't mock core language elements, unless they call external sources (databases, webservices)
* only verify behavior if it's critical, otherwise you get overcompilcated tests (hard to maintain)

## Assignment

The `homework` package has a sample `Main` class and JavaDocs to describe how it is working.

**Rules to follow:**
* Use assertions to validate
* Use annotations to dedicate test methods @Test
* Prepare the starting states/ if you need a new instance of the BankAccount/ e.g @Before
* Report about the final states to the console / with the getAccountDetails / e.g. @After
* Use both constructors of the BankAccount
* Separate given/when/then parts

**Tasks to do:**
1. Write unit tests to cover debit and credit methods of BankAccount, you can use the getAccountDetails to validate.

2. Write unit test to cover AccountFrozenException.

3. Collect your test methods in separate classes according to what
you are testing

**Evaluation Criteria** 

1 task equals 2 points! Additional points can be earned if the rules are followed 
