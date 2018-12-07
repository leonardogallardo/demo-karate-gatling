# Karate Gatling demo

Projeto criado para demonstrar a integração entre Karate e Gatling pro TDC.

Slides da palestra:
> https://docs.google.com/presentation/d/1ZIqGiVtEdsDja7UfdjNQflaJgC_pCJ0y_JClO8NmTss/edit?usp=sharing

##Rodando os testes

- Para rodar todos testes funcionais em paralelo e gerar relatório HTML
> `mvn clean test`

- Para rodar um teste funcional único
> `mvn clean test -Dtest="CatsRunner"`

- Para rodar testes de performance
> mvn clean test-compile gatling:test


##Requisitos para rodar o projeto
- JDK 1.8_112+
- Maven

## Referências
- https://github.com/intuit/karate
- https://gatling.io/
- https://github.com/intuit/karate/tree/master/karate-gatling

##Meu contato
https://www.linkedin.com/in/leonardoggallardo/