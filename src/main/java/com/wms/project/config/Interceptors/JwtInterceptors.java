package com.wms.project.config.Interceptors;

import com.wms.project.common.util.CustomException;
import com.wms.project.common.util.ErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtInterceptors implements HandlerInterceptor {
    @Value("${jwt.secret}")
    private byte[] keyBytes;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws CustomException {
        System.out.println("进入了拦截器");
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bear ")) {
            String token = authHeader.substring(5);
            try{
                Claims claims = Jwts.parser().setSigningKey(keyBytes).parseClaimsJws(token).getBody();
                System.out.println(claims);
            }catch (Exception ex){
//                TODO 将所有的错误信息变成枚举的写法
                System.out.println(ErrorCode.JWT_ERROR.code);
                throw new CustomException(ErrorCode.JWT_ERROR);
            }
        }else{
            throw new CustomException(ErrorCode.NO_JWT);
        }
        return true;
    }
}