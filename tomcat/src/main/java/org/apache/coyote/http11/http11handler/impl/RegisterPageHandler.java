package org.apache.coyote.http11.http11handler.impl;

import nextstep.jwp.model.visitor.Visitor;
import org.apache.coyote.http11.HttpMethod;
import org.apache.coyote.http11.StatusCode;
import org.apache.coyote.http11.http11handler.Http11Handler;
import org.apache.coyote.http11.http11handler.support.HandlerSupporter;
import org.apache.coyote.http11.http11request.Http11Request;
import org.apache.coyote.http11.http11response.Http11Response;

public class RegisterPageHandler implements Http11Handler {

    private static final String URI = "/register";
    private static final String URI_WITH_EXTENSION = "/register.html";
    private static final HttpMethod ALLOWED_HTTP_METHOD = HttpMethod.GET;

    @Override
    public boolean isProperHandler(Http11Request http11Request) {
        return http11Request.getUri().equals(URI) && http11Request.getHttpMethod().equals(ALLOWED_HTTP_METHOD);
    }

    @Override
    public Http11Response handle(Http11Request http11Request, Visitor visitor) {
        return HandlerSupporter.resourceResponseComponent(URI_WITH_EXTENSION, StatusCode.OK);
    }
}
