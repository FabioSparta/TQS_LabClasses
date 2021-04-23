Feature: Book Search

  Background: A sample library
    Given a book with the title 'DragonBall', written by 'Akira', published in 1975-02-02
    And another book with the title 'DragonBall Super', written by 'Akira', published in 2018-06-10
    And another book with the title 'Game of Thrones', written by 'George RR Martin', published in 2007-04-17
    And another book with the title 'Lusiadas', written by 'Luis de Camoes', published in 1870-05-12
    And another book with the title 'Harry Potter', written by 'JK Rowling', published in 2000-09-20

  Scenario: Search By Date between x and y
    When the customer searches for books published between 1999-02-02 and 2020-02-02
    Then 3 books should have been found
    And Book 1 should have the title 'DragonBall Super'
    And Book 2 should have the title 'Game of Thrones'
    And Book 3 should have the title 'Harry Potter'

  Scenario: Search By Author
    When the customer searches for books by 'Akira'
    Then 2 books should have been found
    And Book 1 should have the title 'DragonBall'
    And Book 2 should have the title 'DragonBall Super'

  Scenario: Search By Title Expression
    When the customer searches for books with title similar to 'Dragon'
    Then 2 books should have been found
    And Book 1 should have the title 'DragonBall'
    And Book 2 should have the title 'DragonBall Super'



