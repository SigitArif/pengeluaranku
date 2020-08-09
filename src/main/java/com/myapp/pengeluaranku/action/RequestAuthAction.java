package com.myapp.pengeluaranku.action;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.util.JwtDecoder;


@Aspect
@Component
public class RequestAuthAction {

    private static Logger logger = LoggerFactory.getLogger(RequestAuthAction.class.getName());

    @Autowired
    JwtDecoder jwtDecoder;

    @Pointcut("@annotation(com.cariparkir.workshop.action.RequestAuth)")
    public void requestAuthMethods() {}

    @Around("requestAuthMethods()")
    public Object exec(ProceedingJoinPoint pjp) throws Throwable {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String value = request.getHeader("Authorization");
        if (value != null) {
            String username = jwtDecoder.getUsername(value);
            if (!username.isEmpty()) {
                Object retval = pjp.proceed();
                return retval;
            }else{
                throw new PengeluarankuException("Unauthorize", HttpStatus.UNAUTHORIZED, StatusCode.UNAUTHORIZED);
            }
        } else {
            throw new PengeluarankuException("Unauthorize", HttpStatus.UNAUTHORIZED, StatusCode.UNAUTHORIZED);
        }

    }

}
