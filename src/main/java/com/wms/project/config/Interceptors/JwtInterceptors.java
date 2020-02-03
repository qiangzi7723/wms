package com.wms.project.config.Interceptors;

import com.wms.project.common.util.CustomException;
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
            System.out.println("输出token信息" + token);
            try{
                Claims claims = Jwts.parser().setSigningKey(keyBytes).parseClaimsJws(token).getBody();
                System.out.println(claims);
            }catch (Exception ex){
                throw new CustomException(-1001,"JWT解析失败");
            }
        }else{
            throw new CustomException(-1002,"没有带上JWT信息");
        }
        return true;
    }
}






//
//public class JwtFilter extends OncePerRequestFilter {
//
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("走到过滤器了");
//        if (authHeader != null && authHeader.startsWith("Bear ")) {
////             说明有token头信息
//            String token = authHeader.substring(5);
//            System.out.println("输出token信息" + token);
//            try{
//                Claims claims = Jwts.parser().setSigningKey(keyBytes).parseClaimsJws(token).getBody();
//                System.out.println(claims);
//            }    catch (Exception ex){
//                throw ex;
//            }
//        }
//
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//
//    }
//}