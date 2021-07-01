package br.com.DynamoDB.repository;

import br.com.DynamoDB.entity.Funcionario;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FuncionarioRepository {

    private DynamoDBMapper dynamoDBMapper;

    public Funcionario save(Funcionario funcionario) {
        dynamoDBMapper.save(funcionario);
        return funcionario;
    }

    public Funcionario getFuncionarioById(String funcionarioId) {
        return dynamoDBMapper.load(Funcionario.class, funcionarioId);
    }

    public String delete(String funcionarioId) {
        Funcionario funcionario = dynamoDBMapper.load(Funcionario.class, funcionarioId);
        dynamoDBMapper.delete(funcionario);
        return "Funcionário Deletado!!";
    }

    public String update(String funcionarioId, Funcionario funcionario) {
        dynamoDBMapper.save(funcionario,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("funcionarioId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(funcionarioId)
                                )));
        return funcionarioId;
    }


}
