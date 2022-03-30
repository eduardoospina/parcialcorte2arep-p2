package edu.escuelaing.arep;
import org.json.simple.JSONObject;

import java.lang.Math;

public class Mathimplementaction {


    private static JSONObject makeJson(String operation, Double input, Double output){
        JSONObject json = new JSONObject();
        json.put("operation", operation);
        json.put("input", input);
        json.put("output", output);
        return json;
    }

    public static JSONObject Atan(Double input){
        return makeJson("atan", input, Math.atan(input));
    }

    public static JSONObject Sqrt(Double input){
        return makeJson("sqrt", input, Math.sqrt(input));
    }
}
