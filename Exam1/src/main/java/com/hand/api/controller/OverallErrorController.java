package com.hand.api.controller;

import com.hand.infra.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class OverallErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(PATH)
    @ResponseStatus(HttpStatus.OK)
    public ServerResponse<Object> handle(HttpServletRequest request) {
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(new ServletRequestAttributes(request), false);
        Integer status = (Integer) attributes.get("status");
        String message = (String) attributes.get("error");

        return ServerResponse.createError(status, message);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}

