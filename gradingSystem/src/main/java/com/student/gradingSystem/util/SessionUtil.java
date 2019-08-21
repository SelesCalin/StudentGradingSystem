package com.student.gradingSystem.util;


import com.student.gradingSystem.domain.entity.enumeration.RoleType;
import com.student.gradingSystem.service.session.Session;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

@Component
public final class SessionUtil {

    private static Map<String, Session> sessionMap;

    private SessionUtil() {
        sessionMap=new HashMap<String,Session>();
    }

    public static void createSession(String token, Integer id, RoleType role){
        Session session = new Session(id,role);
        sessionMap.put(token,session);

    }


    public static void invalidateSession(String token){
        sessionMap.remove(token);
    }

    public static Session getSession(String token){

        return sessionMap.get(token);

    }

    public static Map<String,Session> getSessionMap(){
        return sessionMap;
    }


}
