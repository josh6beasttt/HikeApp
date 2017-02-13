import com.google.gson.Gson;
import json.set.HikeJson;
import json.set.PersonJson;
import record.RecordGetter;
import record.RecordSetter;
import record.RecordUpdater;

import static spark.SparkBase.port;
import static spark.Spark.*;

public class HikingSpots {
    public static void main(String[] args) {
        String portNumber = System.getenv("PORT");
        port(Integer.parseInt(portNumber));

        //TODO: Add authentication for users and app and also way to get ID whether it be through an API or credentials provided by user
        //Ignore IDs until we figure out how we want to get them and store them
        get("/person/", (req, res) -> {
            String userId = "";

            String json = RecordGetter.getPerson(userId);

            res.status(200);
            res.body("{\"msg\":\"Success\"");
            return json;
        });

        get("/hike/", (req, res) -> {
            String userId = "";

            String json = RecordGetter.getHike(userId);

            res.status(200);
            res.body("{\"msg\":\"Success\"");
            return json;
        });

        post("/person/", (req, res) -> {

            Gson gson = new Gson();
            PersonJson json = gson.fromJson(req.body(), PersonJson.class);

            RecordSetter.setPerson(json);

            res.status(200);
            res.body("{\"msg\":\"Success\"");
            return "success";
        });

        post("/hike/", (req, res) -> {

            Gson gson = new Gson();
            HikeJson json = gson.fromJson(req.body(), HikeJson.class);

            RecordSetter.setHike(json);

            res.status(200);
            res.body("{\"msg\":\"Success\"");
            return "success";
        });

        put("/person/", (req, res) -> {

            Gson gson = new Gson();
            json.update.PersonJson json = gson.fromJson(req.body(), json.update.PersonJson.class);

            RecordUpdater.updatePerson(json);

            return "success";
        });

        put("/hike/", (req, res) -> {

            Gson gson = new Gson();
            json.update.HikeJson json = gson.fromJson(req.body(), json.update.HikeJson.class);

            RecordUpdater.updateHike(json);

            return "success";
        });
    }
}
