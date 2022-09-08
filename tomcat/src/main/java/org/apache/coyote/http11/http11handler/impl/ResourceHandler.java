package org.apache.coyote.http11.http11handler.impl;

import java.util.List;
import java.util.Locale;
import nextstep.jwp.model.visitor.Visitor;
import org.apache.coyote.http11.StatusCode;
import org.apache.coyote.http11.http11handler.Http11Handler;
import org.apache.coyote.http11.http11handler.support.HandlerSupporter;
import org.apache.coyote.http11.http11request.Http11Request;
import org.apache.coyote.http11.http11response.Http11Response;

public class ResourceHandler implements Http11Handler {

    private static final List<String> SUPPORT_EXTENSION = List.of("css", "js");

    @Override
    public boolean isProperHandler(Http11Request http11Request) {
        String extension = HandlerSupporter.extractExtension(http11Request.getUri()).toLowerCase(Locale.ROOT);
        return SUPPORT_EXTENSION.contains(extension);
    }

    @Override
    public Http11Response handle(Http11Request http11Request, Visitor visitor) {
        return HandlerSupporter.resourceResponseComponent(http11Request.getUri(), StatusCode.OK);
    }
}
