package br.com.crinnger.InterBootcampSuperHerois.document;

import br.com.crinnger.InterBootcampSuperHerois.constans.HeroesConstant;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = HeroesConstant.HEROES_TABLE)
public class Heroes {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    @JsonProperty("id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    @JsonProperty("name")
    private String name;

    @DynamoDBAttribute(attributeName = "universe")
    @JsonProperty("universe")
    private String universe;

    @DynamoDBAttribute(attributeName = "films")
    @JsonProperty("films")
    private int films;
}
