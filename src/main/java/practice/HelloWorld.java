package practice;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.BasicConfigurator;
import practice.routes.HelloRoute;
import practice.util.ViewUtil;

public class HelloWorld {

    public static void main(String[] args) {
        port(8080);
        BasicConfigurator.configure();

        path("/hello", HelloRoute.helloRoutes);

        get("/template", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("subject", "hi");
            return ViewUtil.render(model, "index.html");
        });

        notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Custom 404\"}";
        });

        internalServerError((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Custom 500 handling\"}";
        });
    }

}

