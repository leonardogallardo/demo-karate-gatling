Feature: cats crud

  Background:
    * def MockUtils = Java.type('mock.MockUtils')
    * eval if (karate.properties['mock.cats.url'] == null) MockUtils.startServer()
    * url karate.properties['mock.cats.url']

  Scenario: Criar, recuperar e modificar um gato
    Given request { name: 'Billie' }
    When method post
    Then status 200
    And match response == { id: '#uuid', name: 'Billie' }
    * def id = response.id

    Given path id
    When method get
    Then status 200
    And match response == { id: '#(id)', name: 'Billie' }

    Given path id
    When request { id: '#(id)', name: 'Bob' }
    When method put
    Then status 200
    And match response == { id: '#(id)', name: 'Bob' }

    When method get
    Then status 200
    And match response contains { id: '#(id)', name: 'Bob' }
