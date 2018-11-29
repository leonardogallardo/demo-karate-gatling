# Karate Gatling demo

Projeto criado para demostrar a integração de testes funcionais Karate com testes de performance Gatling.

Slides da palestra:
https://docs.google.com/presentation/d/1ZIqGiVtEdsDja7UfdjNQflaJgC_pCJ0y_JClO8NmTss/edit?usp=sharing

- Rodar testes funcionais
>mvn clean test -Dtest="CatsRunner"

- Rodar testes de performance
> mvn clean test-compile gatling:test`
