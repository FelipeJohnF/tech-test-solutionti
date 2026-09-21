# Java API

## API utilizando JAVA + SpringBoot + JWT Token

Foi realizado o desenvolvimento na arquitetura Service + Controller + DTO seguindo as convenções padrões. No momento, os endpoints de consulta de usuário e endereços estão funcionando corretamente. O principal problema foi a integração com o FrontEnd; deste modo, o projeto que desenvolvi é possível apenas analisar o código em si.

## Execução dos Endpoints

Para execução do endpoint basta:

```bash
./mvnw spring-boot:run
```

Caso ocorra falha de permissão de execução (Linux)

```bash
  chmod +x mvnw
```

## Para database

Necessário a criação de um database no postgres, e após realizar a execução do arquivo em DATABASE/database.sql

## Problemas

O principal problema foi no momento em que realizei a integração com o JWT, a falta da funcionabilidade de login / signup foi o que comprometeu a visualização das funcionalidades, no momento é possível criar um usuário manualmente com o hash da senha ocorrendo em bcrypt, porém não há certeza de que o endpoint de login funcionará.

O projeto havia tempo o sufuciente para ser desenvolvido, porém diante da minha disponibilidade não consegui completar todos em requisitos. Que fique claro que eu compreendo que o código não é entregável em circuntâncias comerciais e etc.
