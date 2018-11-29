@ignore
Feature: Deleta um gato pelo ID e verifica se foi deletado

  Scenario:
    Given path id
    When method delete
    Then status 200
    And match response == ''

    Given path id
    And header karate-name = 'cats-get-404'
    When method get
    Then status 404
