Feature: Deletar todos os gatos

  Background:
    * def MockUtils = Java.type('mock.MockUtils')
    * eval if (karate.properties['mock.cats.url'] == null) MockUtils.startServer()
    * url karate.properties['mock.cats.url']

  Scenario: Recupera todos os gatos e delete cada um pelo id
    When method get
    Then status 200

    * def delete = read('cats-delete-one.feature')
    * def result = call delete response
