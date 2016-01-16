import static spark.SparkBase.port;
import static spark.Spark.*;

public class HikingSpots {
    public static void main(String[] args) {
        String portNumber = System.getenv("port");
        port(Integer.parseInt(portNumber));

        get("/person/", (req, res) -> {

            return "success";
        });

        get("/hike/", (req, res) -> {

            return "success";
        });

        post("/person/", (req, res) -> {

            return "success";
        });
    }
}
