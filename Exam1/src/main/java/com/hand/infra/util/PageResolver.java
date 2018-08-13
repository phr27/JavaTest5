package com.hand.infra.util;

import com.hand.domain.entity.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PageResolver implements HandlerMethodArgumentResolver {

    private Logger logger = LoggerFactory.getLogger(PageResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Page.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Page p = new Page();
        Integer pageSize = new Integer(webRequest.getParameter("pageSize"));
        Integer page = new Integer(webRequest.getParameter("page"));
        String sort = webRequest.getParameter("sort");

        if (pageSize <= 0) {
            pageSize = 1;
        }
        if (page <= 0) {
            page = 1;
        }
        p.setPage(page);
        p.setPageSize(pageSize);

        if (sort != null) {
            p.setSort(sort.toUpperCase());
        }

        logger.info("page resolver works");
        return p;
    }
}
