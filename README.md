

## Desafio Tecnico DBServer

### [Bug Bank](https://bugbank.netlify.app/)

>*O banco com bugs e falhas do seu jeito.*
>
>*É um Bug Bank, para que? É pratique de testes e automação de testes.*
  
---  

#### O projeto é exclusivamente para [DBServer](https://db.tec.br/).
  
---  

:clipboard: Realizar Transferência entre Contas Passo –a –passo :

:heavy_check_mark: Acessar o site [Bug Bank](https://bugbank.netlify.app/)

:heavy_check_mark: Criar duas contas com Saldo e salvar os seus dados.

:heavy_check_mark: Acessar uma conta e realizar uma transferência de valor para outra.

:heavy_check_mark: Validar a saída e entrada de valores das contas envolvidas
  
---  

### Ferramentas que foi ulitizado?

![](img/cucumber.png)


_O projeto utiliza o Cucumber, uma ferramenta de software de código aberto utilizada para o desenvolvimento de testes automatizados baseados em comportamento (BDD - Behavior-Driven Development)._

:green_book: [Cucumber Documentos (BDD - Behavior-Driven Development)](https://cucumber.io/docs/bdd/)


#### Construido com a estrutura:

:pushpin: [MAVEN](https://maven.apache.org/download.cgi)

:pushpin: [JAVA 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

#### Dependencias:

:pushpin: [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.21.0)

:pushpin: [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.8.0)

:pushpin: [Cucumber Java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java/7.18.0)

:pushpin: [Cucumber TestNG](https://mvnrepository.com/artifact/io.cucumber/cucumber-testng/7.18.0)

:pushpin: [Json simple](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1)

:pushpin: [Java Faker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker/1.0.2)
  
---  

### Baixando o projeto / Executando o Projeto

Abra o prompt de comando. Execute o comando abaixo para clonar o repositório:
```bash  
git clone https://github.com/loopfagundes/db_cucumber_web
```  

#### Executando o Projeto:
Para executar na sua máquina local e através de sua IDE:

```bash  
src/test/java/app.netlify.bugbank/TestRunner.class  
```  
Quando executar o teste, o padrão navegador Chrome será aberto automaticamente.

Para executar no Firefox ou Edge,  caminho para acessar pastas dentro IDE:

```bash  
src/main/java/app.netlify.bugbank/drivers/DriverFactory.class 
```  

Dentro do bloco de `Try/Catch`:

```bash  
Driver.valueOf(System.getProperty("driver", "chrome").toUpperCase());  
```  

Existem as opções entre aspas "chrome", "firefox" ou "edge", todas em minúsculas.
  
---
#### Report:

Após a execução do projeto, para visualizar o relatório: 
Abra a pasta de report e selecione o arquivo `report.html`.
Clique com o botão direito do mouse, vá em "Open in", depois "Browser" e escolha o navegador da sua preferência.

---  
Feito com bug, café e muito esforço :beetle::coffee:
