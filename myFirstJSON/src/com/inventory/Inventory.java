package com.inventory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Inventory {
    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("Data/inventory.json");

        // Java Object variable
        Object obj = jsonparser.parse(reader); // THis is my Main Object i.e which includes JSONParser, JSONObject, JSONArray

        // JSON Object ( after type casting)
        JSONObject inventoryobj = (JSONObject) obj; // FIle Inventory.json it will parse the object to JSONObject
        JSONArray array = (JSONArray) inventoryobj.get("inventoryDetails"); // Will now change JSON Object to JSON Array.
        
        for (int i = 0; i < array.size(); i++) {
            JSONObject inventoryDetails = (JSONObject) array.get(i);

            String name = (String) inventoryDetails.get("name");
            double weight = (double) inventoryDetails.get("weight");
            double pricePerKg = (double) inventoryDetails.get("pricePerKg");
            String type = (String) inventoryDetails.get("type");

            System.out.println("inventoryDetail " + i + " is ......");

            System.out.println("Name :: " + name);
            System.out.println("Weight :: " + weight);
            System.out.println("PricePerKg :: " + pricePerKg);
            System.out.println("Type :: " + type);

            double value = weight * pricePerKg;
            System.out.println("*******************************************************");
            System.out.println("****  value for Inventory is :: " + value + " ****");
            System.out.println("*******************************************************");
            System.out.println(""); // If we want to leave a single line space in java, We could use
        }

    }

}
