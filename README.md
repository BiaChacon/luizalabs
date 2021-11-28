<h1 align="center">
<img 
    src="https://user-images.githubusercontent.com/42190754/143725393-3097b619-0b46-4591-b1f8-f646e1d2ec9e.png"
    float="center"
     width="400"
    />
</h1>
<h1 align="center" style="color:#4285BB; font-weight:bold;">
    <a href="#">Desafio Luizalabs</a>
</h1>

<p align="center">
 <a href="#ℹ%EF%B8%8F-sobre">Sobre</a> •
 <a href="#-tecnologias">Tecnologias</a> •
 <a href="#%EF%B8%8F-funcionalidades">Funcionalidades</a> •
 <a href="#-como-executar-o-projeto">Como executar</a> •
 <a href="#-documentação">Documentação</a> •
 <a href="#-autores">Autores</a> •
 <a href="#-licença">Licença</a>
</p>

## ℹ️ Sobre

Desafio técnico Luizalabs, o objetivo é desenvolver um serviço para busca de CEP.

---

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- **Java**
- **SpringBoot**
- **Spring Data JPA**
- **Maven**
- **PostgreSQL**
- **Swagger**
- **JUnit**
- **MockMVC**
- **Mockito**
- **Logger**
- **Actuator**
- **SpringBootAdmin**
- **Postman**

---

## ⚙️ Funcionalidades

- [x] Dado um CEP válido, deve retornar o endereço correspondente.
- [x] Dado um CEP válido, que não exista o endereço, deve substituir um dígito da direita para a esquerda por zero até que o endereço seja localizado (Exemplo: Dado 22333999 tentar com 22333990, 22333900 …).
- [x] Dado um CEP inválido, deve retornar uma mensagem reportando o erro: "CEP inválido".

---

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas: [Git](https://git-scm.com), [PostgreSQL]() e IDE de desenvolvimento configurado para projetos Spring.

#### 🏁 Começar

```bash

# Clone este repositório
$ git clone git@github.com:biachacon/luizalabs.git

```

#### 🗃️ Configurar o Banco de Dados

```bash
# Acesse o arquivo
$ cd apicep/src/main/resources/application.properties

# Comentar configuração heroku que está a partir da linha 6 até 8 e descomentar configuração PostgreSQL que está a partir da linha 12 até 18.
```

```bash
Criar Banco chamado api-cep, utilizando PostgreSQL no pgAdmin.
```

#### 🎲 Rodando a aplicação

```bash

👉 Acessar projeto apicep e executar

👉 A aplicação iniciará na porta:8080 - acesse http://localhost:8080/

```

#### 📈 Rodando a aplicação de monitoramento

```bash
# Acesse o arquivo
$ cd apicep/src/main/resources/application.properties

# Comentar configuração heroku que está na linha 34 e descomentar configuração do cliente local que está na linha 31.

👉 Acessar projeto spring-boot-admin e executar

👉 A aplicação iniciará na porta:8081 - acesse http://localhost:8081/

```

---

## 🗎 Documentação

### **[ 👉 Swagger](https://luizalabs-api-cep.herokuapp.com/swagger-ui.html)**

## 📍 Criar Endereço [POST][/endereco]

### **Request**

- Body

```bash
{
    "cep": "12345678",
    "rua": "Rua",
    "bairro": "Bairro",
    "cidade": "Cidade",
    "estado": "Estado"
}
```

### **Response 201 (application/json)**

```bash
{
    "id": "f34635eb-a4c4-4698-94af-19bdd923a003",
    "cep": "12345678",
    "rua": "Rua",
    "bairro": "Bairro",
    "cidade": "Cidade",
    "estado": "Estado"
}
```

## 📍 Buscar endereço pelo CEP [GET][/endereco/:cep]

### **Response 200 (application/json)**

```bash
{
    "id": "f34635eb-a4c4-4698-94af-19bdd923a003",
    "cep": "12345678",
    "rua": "Rua",
    "bairro": "Bairro",
    "cidade": "Cidade",
    "estado": "Estado"
}
```

---

## Resposta da questão 2

### [👉 Resposta](https://github.com/BiaChacon/luizalabs/blob/master/q2.md)

---

## 👩🏽‍💻 Autores

<table>
  <tr>
    <td align="center"><a href="https://github.com/biachacon"><img src="https://avatars1.githubusercontent.com/u/42190754?s=460&u=a5cbe42a4868b2bac9615226044b9cec15cee418&v=4" width="100px;" alt=""/><br /><sub><b>Bia Chacon</b></sub></a><br /><a href="https://github.com/BiaChacon/luizalabs" title="Code">💻</a></td>
  <tr>
</table>

---

## 📝 Licença

This project is under MIT. See at here [LICENSE](https://github.com/BiaChacon/luizalabs/blob/master/LICENSE) for more informations.

---

