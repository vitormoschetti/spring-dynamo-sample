package br.com.DynamoDB.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "funcionario")
public class Funcionario {

    @DynamoDBHashKey
    private String funcionarioId;

    @DynamoDBAttribute
    private String nome;

    @DynamoDBAttribute(attributeName = "departamento")
    @DynamoDBTypeConvertedJson(targetType = Departamento.class)
    private Departamento departamento;

}
