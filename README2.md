# Prova para fullstack na Maxima Tech

## Backend

### Tecnologias usadas no Projeto

![java]
![spring]
![maven]
![mysql]
![spring-data-jpa]
![angular]

### Antes de utilizar

Tenha instalado o [JDK](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html) e as variáveis _JAVA_HOME_, _CLASSPATH_ e _PATH_ configuradas.

#### Windows

### Instalação Mysql

* Baixe o [WAMPServer64](https://sourceforge.net/projects/wampserver/files/latest/download), instale e inicie ele
* Abra o navegador e acesse http://localhost/phpmyadmin/
* Entre no phpMyadmin com usuário root e senha em branco
* Crie uma base de dados chamada maximatech

### Para iniciar o backend siga esses passos:

#### Windows

* git clone https://github.com/MalkonF/JavaWeb-Developer-CRUD.git
* Baixe e instale o Spring Tool Suite
* O projeto pode ser aberto pelo [**STS(Spring Tools Suite)**](https://spring.io/tools) na opção _File - Open Projects from File System_.
* Normalmente, o STS baixa as dependências automaticamente ao abrir o projeto, mas se isso não acontecer, clique com botão direito sobre o projeto, vá na opção _Maven_ e depois em _Update Project_.
* Para executar clique com botão direito sobre o projeto e escolha _Run as - Spring Boot App_ . A partir daí os endpoints já estarão disponíveis.

#### Iniciar backend sem abrir IDE

** Linux **

```
 git clone https://github.com/MalkonF/JavaWeb-Developer-CRUD.git
 cd JavaWeb-Developer-CRUD/
 ./mvnw spring-boot:run
 ```
 
 ** Windows **
 
 ```
 git clone https://github.com/MalkonF/JavaWeb-Developer-CRUD.git
 cd JavaWeb-Developer-CRUD/
 ./mvnw.cmd spring-boot:run
 ```
 
## Frontend

```
$ ng --version

Angular CLI: 11.0.4
Node: 12.19.0
OS: win32 x64

Angular:
...
Ivy Workspace:

Package                      Version
------------------------------------------------------
@angular-devkit/architect    0.1100.4 (cli-only)
@angular-devkit/core         11.0.4
@angular-devkit/schematics   11.0.4
@schematics/angular          11.0.4 (cli-only)
@schematics/update           0.1100.4 (cli-only)
```

### Antes de utilizar

Baixe e instale o [Node.js](https://nodejs.org/en/download/)
Instale o Angular CLI. Abra o cmd ou git bash e entre com:

```
npm install -g @angular/cli

```

### Executando o frontend

Para iniciar entre com:

```
 cd JavaWeb-Developer-CRUD/frontend/frontend
 npm install
 ng serve
 Acesse pelo endereço: localhost:4200
```



[java]: https://img.shields.io/badge/Java-11-brightgreen
[spring]: https://img.shields.io/badge/spring--boot-2.1.13-green
[maven]: https://img.shields.io/badge/Ger%20Depend%C3%AAnca-Maven-red
[mysql]: https://img.shields.io/badge/DB-MySql-orange
[spring-data-jpa]: https://img.shields.io/badge/Spring--Data--JPA-2.4.2-brightgreen
[angular]: https://img.shields.io/badge/Angular-11.0.4-red