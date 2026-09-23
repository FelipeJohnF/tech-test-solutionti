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

Necessário a criação de um database no postgres, e após realizar a execução do arquivo em DATABASE/database.sql.

Necessário apontar também apontar a API para o database, será ainda hoje realizado o upload do .env.example

## Problemas

No momento nem todas as funcionalidades estão ativas, necessário ainda a utilização da API ViaCEP e da adição de um botão para que um usuário "STANDARD" consiga realizar o cadastro de um endereço.

Estou aos poucos iterando as novas funcionalidades. O projeto havia tempo o sufuciente para ser desenvolvido, porém diante da minha disponibilidade não consegui completar todos em requisitos.
