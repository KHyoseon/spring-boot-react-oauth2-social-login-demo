package com.example.springsocial.security.oauth2.user;

import java.util.HashMap;
import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {

    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getName() {
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        if (properties == null)     return null;

        HashMap hashMap = (HashMap)attributes.get("kakao_account");
        HashMap profileHashMap =(HashMap) hashMap.get("profile");

        return (String) profileHashMap.get("nickname");
    }

    @Override
    public String getEmail() {
        // 수정한부분
        for(Object key: attributes.keySet()){
            System.out.println(key);
        }
        System.out.println("=====kakao_account=====");
        HashMap hashMap = (HashMap) attributes.get("kakao_account");
        System.out.println(hashMap);
//        for(Object key: lhs.keySet()){
//            System.out.println(key);
//        }
        return (String) hashMap.get("email");
    }
}
