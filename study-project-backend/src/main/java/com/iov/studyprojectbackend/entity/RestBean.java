package com.iov.studyprojectbackend.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

public record RestBean<T>(int code, T data, String message) {
    public static <K> RestBean<K> success(K data){
        return new RestBean<K>(200,data,"请求成功");
    }
    public static <K> RestBean<K> success(){
        return success(null);
    }
    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);

    }
    public static <K> RestBean<K> fail(int code ,String message){
        return new RestBean<K>(code,null,message);
    }
}
