package com.example.assignment02gc200472583;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    /*
    * A method to read file and parse JSON objects
    */
    public static ApiResponse getCharactersFromJSONFile(String fileName)
    {
        Gson gson = new Gson();
        ApiResponse response = null;

        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                ){
            response = gson.fromJson(jsonReader, ApiResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return response;
    }

    /*
     * A method which parse JSON objects from api directly
     */
    public static ApiResponse getCharactersFromThronesAPI()
    {
        String uri = "https://thronesapi.com/api/v2/Characters";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Appended the response body string to make api easily usable
            String responseInString = response.body();
            responseInString = "{\"characters\": " + responseInString + "}";

            Gson gson = new Gson();
            return gson.fromJson(responseInString, ApiResponse.class);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /*
     * A method which get api object from the id
     */
    public static Character getCharacterInfo(int id)
    {
        String uri = "https://thronesapi.com/api/v2/Characters/" + id;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            //String responseInString = response.body();
            //responseInString = "{\"characters\": " + responseInString + "}";

            Gson gson = new Gson();
            return gson.fromJson(response.body(), Character.class);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
