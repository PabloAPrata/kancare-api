# KanCare API
API REST para manter o registro de beneficiários de um plano de saúde.

## Status do Projeto
- Em desenvolvimento

## Pré requisitos
1.	JAVA 21
2.	Maven 3
3.	Banco de dados PostgreSQL

## Instalação
1. Clone o repositório:
```bash
	# ssh
$	git glone git@github.com:PabloAPrata/kancare-api.git
   
	# HTTPS
$ https://github.com/PabloAPrata/kancare-api.git
```

2. Navegue até o diretório clonado:
```bash
$	cd kancare-api
```

3. Faça o build da aplicação
```
$	mvn clean install
```

4. Navegue até a pasta **target** que é onde o arquivo foi construido e copie para algum pasta vazia
```BASH
$	cd target;
$	cp kancare-api-0.1.0-SNAPSHOT.jar /Alguma/pasta/Documents/minha_pasta;
```

5. Na nova pasta crie um arquivo chamado  `application.properties` e prencha-o com os seguintes parâmetros:
```
spring.application.name=kancare-api

# DATASOURCE
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

# JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=true

# DATE FORMAT
spring.jackson.date-format=yyyy-MM-dd

```

6. Em `spring.datasource.url` você deve colocar o endereço do seu banco de dados **postgresql** ex: `jdbc:postgresql://localhost:5432/<nome-do-seu-banco-aqui>`.
7. Preencha logo abaixo o **username** e **password** de acesso ao banco., salve e feche o arquivo.
8. Verifique se o serviço do banco está ativo. Se estiver execute o seguinte comando:
```bash
$ java -jar kancare-api-0.1.0-SNAPSHOT.jar
```

9. Pronto, agora o serviço ja está executando.
10. Recomendo algum programa para executar requisições HTTP como o **Postman** para executar as requisições.

