package practice.routes;

import static spark.Spark.get;

import practice.controller.HelloController;
import spark.RouteGroup;

public class HelloRoute {

    public static final RouteGroup helloRoutes = () -> {
        get("", HelloController.helloSpark);
        get("/:id", HelloController.sparkWildCard);
    };

}
