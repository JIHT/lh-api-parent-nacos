package com.lihua.feedcontrollerapi.common.config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.lihua.common.exception.RRException;
import com.lihua.feedcontrollerapi.common.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class JwtToken {
    private static Logger logger = LoggerFactory.getLogger(JwtToken.class);
    /**
     * 秘钥
     */
    @Value("${jwt.secret}")
    private String secret;
    /**
     * 过期时间(秒)
     */
    @Value("${jwt.expire}")
    private long expire;

    @Autowired
    private RedisUtils redisUtils;

    public String freshRedisToken(String id) {
        String oldToken = getTokenById(id);
        String token = UUID.randomUUID().toString().replace("-", "");
        redisUtils.delete("token:id:" + id);
        redisUtils.delete("token:value:" + oldToken);
        redisUtils.set("token:id:" + id, token, 7200);
        redisUtils.set("token:value:" + token, id, 7200);
        return token;
    }

    public String generateRedisToken(String id) {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisUtils.set("token:id:" + id, token, expire);
        redisUtils.set("token:value:" + token, id, expire);
        return token;
    }

    public String getKeyByToken(String token) {
        String id = redisUtils.get("token:value:"+token);
        if (StrUtil.isBlank(id)) {
            throw new RRException("token无效，请重新登陆");
        }
        return id;
    }

    public String getTokenById(String id) {
        String token = redisUtils.get("token:id:"+id);
        return token;
    }

    /**
     * 生成jwt token
     */
    public String generateToken(String id) {
        Date nowDate = new Date();
        //2小过期
        Date expireDate = getAfterDate(nowDate, 0, 0, 7, 0, 0, 0);
        String freshTime = DateUtil.format(getAfterDate(nowDate, 0, 0, 0, 2, 0, 0), "yyyy-MM-dd HH:mm:ss.SSS");
        return generateSimpleToken(id, expireDate, freshTime);
    }


    /**
     * 生成jwt token
     */
    private String generateSimpleToken(String id, Date expiresAtDate, String freshTime) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Map<String, Object> map = new HashMap<>();
            Date nowDate = new Date();
            map.put("alg", "HS256");
            map.put("type", "JWT");
            String token = JWT.create()
                    /*设置头部信息 Header*/
                    .withHeader(map)
                    /*设置 载荷 Payload*/
                    .withClaim("IdCards", id)
                    .withClaim("RefreshTime", freshTime)
//                    .withIssuer("SERVICE")//签名是有谁生成 例如 服务器
//                    .withSubject("this is test token")//签名的主题
                    //.withNotBefore(new Date())//定义在什么时间之前，该jwt都是不可用的.
//                    .withAudience("APP")//签名的观众 也可以理解谁接受签名的
                    .withIssuedAt(nowDate) //生成签名的时间
                    .withExpiresAt(expiresAtDate)//签名过期的时间
                    /*签名 Signature */
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * 返回一定时间后的日期
     *
     * @param date   开始计时的时间
     * @param year   增加的年
     * @param month  增加的月
     * @param day    增加的日
     * @param hour   增加的小时
     * @param minute 增加的分钟
     * @param second 增加的秒
     * @return
     */
    public Date getAfterDate(Date date, int year, int month, int day, int hour, int minute, int second) {
        if (date == null) {
            date = new Date();
        }

        Calendar cal = new GregorianCalendar();

        cal.setTime(date);
        if (year != 0) {
            cal.add(Calendar.YEAR, year);
        }
        if (month != 0) {
            cal.add(Calendar.MONTH, month);
        }
        if (day != 0) {
            cal.add(Calendar.DATE, day);
        }
        if (hour != 0) {
            cal.add(Calendar.HOUR_OF_DAY, hour);
        }
        if (minute != 0) {
            cal.add(Calendar.MINUTE, minute);
        }
        if (second != 0) {
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime();
    }

//    public BaseTokenContent generateFreshToken(String token) {
//        BaseTokenContent baseTokenContent = new BaseTokenContent();
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            JWTVerifier verifier = JWT.require(algorithm)
////                    .withIssuer("SERVICE")
//                    .build(); //Reusable verifier instance
//            DecodedJWT jwt = verifier.verify(token);
//            baseTokenContent.setToken(jwt.getToken());
//            Map<String, Claim> claims = jwt.getClaims();
//            String idCards = claims.get("IdCards").asString();
//            String refreshTime = claims.get("RefreshTime").asString();
//            baseTokenContent.setIdCards(idCards);
//            Date freshDate = DateUtil.parse(refreshTime);
//            Date expiresAtDate = jwt.getExpiresAt();
//            Date nowDate = new Date();
//            boolean isCreateNew = false;
//            if (DateUtil.between(new Date(), expiresAtDate, DateUnit.HOUR) < 2) { //如果当前时间距离失效时间不足两个小时，则失效时间改为当前时间后两个小时
//                expiresAtDate = getAfterDate(new Date(), 0, 0, 0, 2, 0, 0);
//                //新建token
//                isCreateNew = true;
//            }
//            if (freshDate.before(nowDate)) { //如果当前时间已经超过刷新时间，重新创建token
//                //新建token
//                refreshTime = DateUtil.format(getAfterDate(nowDate, 0, 0, 0, 2, 0, 0), "yyyy-MM-dd HH:mm:ss.SSS");
//                isCreateNew = true;
//            }
//            if (isCreateNew) { //如果有需要 刷新token
//                baseTokenContent.setToken(generateSimpleToken(idCards, expiresAtDate, refreshTime));
//            }
//            return baseTokenContent;
//        } catch (JWTVerificationException exception) {
//            throw new RRException("登录失效，请重新登录", 501);
//        }
//    }

    public String getFreshToken(String token) {
        int leaveSeconds = redisUtils.getLeaveSeconds("token:value:"+token);
        if(leaveSeconds<7200){
            String id = redisUtils.get("token:value:"+token);
            return freshRedisToken(id);
        }
        return token;
    }
}
