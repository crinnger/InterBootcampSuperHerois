package br.com.crinnger.InterBootcampSuperHerois.config;
import br.com.crinnger.InterBootcampSuperHerois.constans.HeroesConstant;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;

@Configuration
public class HeroesTable {

    public static void main(String args[]) throws Exception{
     /**   AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(HeroesConstant.DYNAMO_ENDPOINT,HeroesConstant.DYNAMO_REGION))
                .build();
        DynamoDB dynamoDB=new DynamoDB(client);

        try{
            System.out.println("Criando tabela, aguarde...");
            Table table = dynamoDB.createTable("Heroes_Table",
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                    Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L,5L)
            );
            table.waitForActive();
            System.out.println("Successo " + table.getDescription().getTableStatus());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }**/
    }
}
