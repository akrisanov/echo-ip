package ru.akrisanov.echoIP;

import io.javalin.Javalin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    private static final List<String> IP_HEADERS = Arrays.asList(
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    );

    public static void main(String[] args) {
        var app = Javalin.create();
        app.start("0.0.0.0", 3001);
        app.get("/", ctx -> {
            var ipAddresses = IP_HEADERS.stream()
                    .filter(ctx.headerMap()::containsKey)
                    .collect(Collectors.toMap(Function.identity(), ctx.headerMap()::get));
            ctx.json(ipAddresses);
        });
    }
}
