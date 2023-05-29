package com.mayikt.service.impl;

import com.mayikt.common.core.utils.DesensitizationUtil;
import com.mayikt.entity.Admin;
import com.mayikt.entity.Student;
import com.mayikt.entity.Teacher;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import java.util.Date;
import java.util.List;


/**
 * mayikt jwt
 */
public class StudentJwtUtils {
    private static final String TOKEN_HEADER = "token";
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String SUBJECT = "mayikt";
    private static final long EXPIRITION = 1000 * 24 * 60 * 60 * 1;
    private static final String APPSECRET_KEY = "mayikt_secret";

    public static String generateJsonWebToken(Student student) {
        String token = Jwts
                .builder()
                .setSubject(SUBJECT)
                .claim("userId", student.getId())
                .claim("phone", DesensitizationUtil.mobileEncrypt(student.getPhone().toString()))
                .setIssuedAt(new Date())
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;
    }

    public static String generateJsonWebTokenTeacher(Teacher teacher) {
        String token = Jwts
                .builder()
                .setSubject(SUBJECT)
                .claim("userId", teacher.getId())
                .claim("phone", DesensitizationUtil.mobileEncrypt(teacher.getPhone().toString()))
                .setIssuedAt(new Date())
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;
    }

    public static String generateJsonWebTokenAdmin(Admin admin) {
        String token = Jwts
                .builder()
                .setSubject(SUBJECT)
                .claim("userId", admin.getId())
                .claim("phone", DesensitizationUtil.mobileEncrypt(admin.getPhone().toString()))
                .setIssuedAt(new Date())
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;
    }

    /**
     * 校验jwt是否有效（过期+是否真实）
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            System.out.println(new Date(System.currentTimeMillis() + EXPIRITION));
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从jwt中获取用户手机号码
     *
     * @param jwt
     * @return
     */
    public static String getPhone(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(jwt).getBody();
        return claims.get("phone").toString();
    }

//    /**
//     * 从jwt中获取用户权限
//     *
//     * @param jwt
//     * @return
//     */
//    public static List<SimpleGrantedAuthority> getUserRole(String jwt) {
//        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(jwt).getBody();
//        List roles = (List) claims.get(ROLE_CLAIMS);
//        String json = JSONArray.toJSONString(roles);
//        List<SimpleGrantedAuthority> grantedAuthorityList = JSONArray.parseArray(json, SimpleGrantedAuthority.class);
//        return grantedAuthorityList;
//    }


    /**
     * 是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

}
