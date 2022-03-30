package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

public class MathServices {

    private static Mathimplementaction Mathimple = new Mathimplementaction();

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        port(getPort());

        get("/hello", (req, res) -> "Hello Heroku");

        get("/atan", ((req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementaction.Atan(input);
        }));

        get("/sqrt", ((req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementaction.Sqrt(input);
        }));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34001; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}