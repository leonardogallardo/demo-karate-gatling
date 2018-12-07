# Karate Gatling demo

Projeto criado para demonstrar a integração entre karate e katling pro TDC.

Slides da palestra:
> https://docs.google.com/presentation/d/1ZIqGiVtEdsDja7UfdjNQflaJgC_pCJ0y_JClO8NmTss/edit?usp=sharing

- Para rodar todos testes funcionais em paralelo e gerar relatório HTML
> `mvn clean test`

- Para rodar um teste funcional único
> `mvn clean test -Dtest="CatsRunner"`

- Para rodar testes de performance
> mvn clean test-compile gatling:test

Meu contato
https://www.linkedin.com/in/leonardoggallardo/