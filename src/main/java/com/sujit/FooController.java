package com.sujit;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.tracing.annotation.NewSpan;

@Controller
public class FooController {

    /**
     * Span for message() is reported correctly in GET call
     * @return
     */
    @Get("/foo")
    public String foo() {
        return message();
    }

    /**
     * Span for message() is not reported correctly as a child in POST call with request body
     * @param name
     * @return
     */
    @Post("/bar")
    public String foo(@Body String name) {
        return message() + name;
    }

    @NewSpan
    public String message() {
        return "Hello";
    }
}
