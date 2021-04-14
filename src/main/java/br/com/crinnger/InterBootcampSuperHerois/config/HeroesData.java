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
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

public class HeroesData {
    public static void main(String args[]){
      /**  AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(HeroesConstant.DYNAMO_ENDPOINT,HeroesConstant.DYNAMO_REGION))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Heroes_Table");
        Item hero = new Item()
                .withPrimaryKey("id",1)
                .withString("name","Mulher Maravilha")
                .withString("universe","DC")
                .withNumber("films",3);
        PutItemOutcome outcome=table.putItem(hero);

        Item hero2 = new Item()
                .withPrimaryKey("id",2)
                .withString("name","Miss Marvel")
                .withString("universe","MARVEL")
                .withNumber("films",3);
        PutItemOutcome outcome2=table.putItem(hero);**/
    }
}
