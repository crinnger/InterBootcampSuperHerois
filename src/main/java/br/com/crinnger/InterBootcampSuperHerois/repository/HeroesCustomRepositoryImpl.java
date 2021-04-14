package br.com.crinnger.InterBootcampSuperHerois.repository;

import br.com.crinnger.InterBootcampSuperHerois.constans.HeroesConstant;
import br.com.crinnger.InterBootcampSuperHerois.document.Heroes;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
public class HeroesCustomRepositoryImpl implements HeroesCustomRepository{

    private final DynamoDB dynamoDB;

    private final DynamoDBMapper dynamoDBMapper;

    private final AmazonDynamoDB amazonDynamoDB;

    @Override
    public void createTable() {

        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(Heroes.class);

        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));

        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
    }

    @Override
    public void loadData() throws IOException {
        Table table = dynamoDB.getTable(HeroesConstant.HEROES_TABLE);
            String id = "5";
            String name = "miss marvel";
            String universe = "marvel";
            int films = 1;
            try {
                table.putItem(new Item()
                        .withPrimaryKey("id", id)
                        .withString("name", name)
                        .withString("universe", universe)
                        .withInt("films", films));
                log.info("PutItem succeeded " + id + " " + name);
            } catch (Exception e) {
                log.error("Unable to add hotel: {} - {}: \n{}", id, name, e.getMessage());
            }
    }
}
