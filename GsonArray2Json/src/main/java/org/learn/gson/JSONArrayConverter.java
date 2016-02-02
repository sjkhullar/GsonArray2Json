package org.learn.gson;

import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONArrayConverter 
{
    public static void main( String[] args )
    {
    	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
    	    
    	Person[] personList = Stream.of(
				new Person("Mike", "harvey", 34, "001894536"),
			  	new Person("Nick", "young", 75,  "005425676"),
				new Person("Jack", "slater", 21 ,"009654153"),
				new Person("gary", "hudson", 55,"00564536"))
				.toArray(Person[]::new);
    	//Array to JSON
    	String mapToJson = objGson.toJson(personList);
    	System.out.println("1. Person array to JSON conversion is : \n");
    	System.out.println(mapToJson);
    	
    	//JSON to Array
    	Person[] arrayPerson = objGson.fromJson(mapToJson, Person[].class);
    	System.out.println("2. JSON to Array of persons conversion is :\n");
    	Arrays.stream(arrayPerson).forEach(System.out::println);
    }
}
