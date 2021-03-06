package com.myapp.pengeluaranku.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class CORSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (httpServletRequest.getHeader("Origin") != null) {
            // CORS "pre-flight" request
            httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            httpServletResponse.addHeader("Access-Control-Allow-Headers", "Authorization, X-Requested-With, " +
                   "Content-Type, Accept");
            httpServletResponse.addHeader("Access-Control-Max-Age", "1800");    // 30 min
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
