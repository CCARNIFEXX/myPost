package com.micro.mypost.personacc.rest;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
class LogFilter extends OncePerRequestFilter {
    private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var startTime = System.currentTimeMillis();
        MDC.put("method", request.getMethod());
        MDC.put("url", request.getRequestURI());
        MDC.put("requestID", request.getRequestId());
        log.info("Начали обработку {} {}", request.getMethod(), request.getRequestURI());

        try {
            filterChain.doFilter(request, response);
            var endTime = System.currentTimeMillis();
            log.info("Закончили обработку {}ms", endTime - startTime);
        } catch (ServletException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            MDC.remove("method");
            MDC.remove("url");
            MDC.remove("requestID");
        }


    }
}
