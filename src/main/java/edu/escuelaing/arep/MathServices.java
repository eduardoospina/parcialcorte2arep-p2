package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

public class MathServices {

    public static void main(String[] args) {
        port(getPort());

        get("/hello", (req, res) -> "Hello Heroku");

        get("/sqrt", ((req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementaction.Sqrt(input);
        }));

        get("/atan", ((req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementaction.Atan(input);
        }));

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34002; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}