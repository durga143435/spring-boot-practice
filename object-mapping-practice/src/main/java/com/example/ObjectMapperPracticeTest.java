package com.example;

import com.example.dtos.SampleUser;
import com.example.dtos.User;
import com.example.dtos.service1.AccountDto;
import com.example.dtos.service1.TransactionDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ObjectMapperPracticeTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        TransactionDto transaction1 = new TransactionDto();
        transaction1.setAmount(new BigDecimal(1000));
        transaction1.setTxnDate("1-04-26");
        transaction1.setTxnId("tx-01");
        transaction1.setTxnType("shopping");

        TransactionDto transaction2 = new TransactionDto();
        transaction2.setAmount(new BigDecimal(2500));
        transaction2.setTxnDate("27-03-26");
        transaction2.setTxnId("tx-02");
        transaction2.setTxnType("personal");


        AccountDto account = new AccountDto();
        account.setAccountId("1231");
        account.setAccountName("saving");
        account.setBalance(new BigDecimal(5000));
        account.setCurrency("rupee");
        account.setTransactions(Set.of(transaction1, transaction2));

        User user = new User();
        user.setAccount(account);
        user.setAge(30);
        user.setName("Ram");
        user.setLastName("jagu");

        //Deserialization
        // reading a json file and converting into a java object
        File jsonFile = new File(System.getProperty("user.dir") + "/jsonFile.txt");
        try {
            User myUser = mapper.readValue(jsonFile, User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //reading a json which is array of same objects and converting it into a java object using TypeReference<>
        File usersFile = new File(System.getProperty("user.dir") + "/listOfUsers.json");
        List<User> users = null;
        try {
            users = mapper.readValue(usersFile, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //reading a json which is array of same objects and converting it into a java object using JavaType
        //we use JavaType when we type is defined at runtime

        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
        mapper.readValue(usersFile, type);
        System.out.println(users);

        //Serialization
        // Java to Json and write it as String Object
        String jsonOut = mapper.writeValueAsString(user);
        System.out.println(jsonOut);

        User user2 = user;
        String usersJson = mapper.writeValueAsString(List.of(user, user2));

        // Java to Json and write it as byte[] Object
        byte[] result = mapper.writeValueAsBytes(user);
        System.out.println(result);

        //convert one java object into another

        Map<String, Object> map = Map.of("name", "Durga",
                "age", 25);
        SampleUser user1 = mapper.convertValue(map, SampleUser.class);

        System.out.println("user1: "+ user1);


        System.out.println("===============================================================");
        JsonNode node = mapper.readTree(jsonFile);
        JsonNode path = node.path("account")
                .path("transations");
        System.out.println(path);

        for(JsonNode eachNode: path){
            System.out.println(eachNode.path("amount"));

        }


    }
}
