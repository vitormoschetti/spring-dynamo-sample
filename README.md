## Para rodar AWS DynamoDB localmente
 
Para instanciar um dynamoDb local precisamos dos seguintes passos:

* baixar um zip disponível pela própria AWS no seguinte link - [dynamoDB-download](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)
* Descompactar o zip.
* Através do CMD, acessar a pasta onde foi descompactada o zip e executar o seguinte comando para iniciar o dynamoDb:
    * ```bash
      java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
      ```

* Para criar as tabelas:
    * Faça a configuração do AWS CLI (pode utilizar dados fake) a partir de um terminal utilizando o seguinte comando:
     * ```bash
         aws configure
         ```

* Acessar a pasta do projeto usando o mesmo CMD ou GIT BASH acima, e executar o seguinte comando: 
    *  ```bash
         aws dynamodb create-table --cli-input-json file://tabelas/Funcionario.json --endpoint-url http://localhost:8000
         ```
         
* Para listar as tabelas criadas:
     * ```bash
         aws dynamodb list-tables --endpoint-url http://localhost:8000
         ```
          
* Para deletar a tabela criada:
     * ```bash
          aws dynamodb delete-table --table-name NAME --endpoint-url http://localhost:8000
         ```
