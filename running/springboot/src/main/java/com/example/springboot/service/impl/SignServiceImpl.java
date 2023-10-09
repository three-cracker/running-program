package com.example.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.common.ErrorCode;
import com.example.springboot.common.HttpClientUtil;
import com.example.springboot.domain.entity.Activity;
import com.example.springboot.exception.BusinessException;
import com.example.springboot.service.ActivityService;
import com.example.springboot.service.SignService;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private ActivityService activityService;
    @Value("${sky.baidu.ak}")
    private String ak;
    /**
     * 地球半径
     */
    private static final double EARTH_RADIUS = 6378137;
    /**
     * 定位打卡
     */
    public void sign() throws JSONException {
        String userLocation = HttpClientUtil.doGet("https://api.map.baidu.com/location/ip?ak=bmvg8yeOopwOB4aHl5uvx52rgIa3VrPO",null);
        JSONObject jsonObject = JSON.parseObject(userLocation);

        //数据解析
        JSONObject location = jsonObject.getJSONObject("content").getJSONObject("point");
        double userLat = Double.parseDouble(location.getString("x"));
        double userLng = Double.parseDouble(location.getString("y"));

        //获取当前活动的坐标
        Activity activity = activityService.getById(1);
        Map<String, String> map = new HashMap<>();
        map.put("address",activity.getLocation());
        map.put("output","json");
        map.put("ak",ak);
        String activityLngLatJson = HttpClientUtil.doGet("https://api.map.baidu.com/geocoding/v3",map);
        jsonObject = JSON.parseObject(activityLngLatJson);
        //数据解析
         location = jsonObject.getJSONObject("result").getJSONObject("location");
         double activityLat = Double.parseDouble(location.getString("lat"));
        double activityLng = Double.parseDouble(location.getString("lng"));

        // 纬度之差
        double a = userLat - activityLat;
        // 经度之差
        double b = userLng - activityLng;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(userLat) * Math.cos(activityLat) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 米
        s =  s * EARTH_RADIUS;
        if(s>=100){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"打卡距离太远");
        }
    }
}
