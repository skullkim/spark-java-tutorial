package practice.controller;

import spark.Request;
import spark.Response;
import spark.Route;

public class HelloController {

    public static Route helloSpark = (Request req, Response res)-> "hello";

    public static Route sparkWildCard = (req, res) -> {
        return "hello" + req.params(":id") + "1";
    };

}
