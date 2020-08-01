package per.wei.cloud.until;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import per.wei.cloud.constant.ReturnConstant;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Component("utilImpl")
public class UtilImpl implements Util {

    static int SEQ = 0;            //集群环境下
    static int ROTATION = 99999;    //id发生器最大值

    @Override
    public String objectToJson(Object data) {
        String jsonStringList = null;
        if (data != null) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            jsonObjectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            try {
                jsonStringList = jsonObjectMapper.writeValueAsString(data);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return jsonStringList;
    }

    @Override
    public String listObjectToJson(List<Object> list) {
        String jsonStringList = "[]";
        if (list != null && !list.isEmpty()) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            jsonObjectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            try {
                jsonStringList = jsonObjectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return jsonStringList;
    }

    @Override
    public String listToJson(List<Map<String, Object>> list) {
        String jsonStringList = "[]";
        if (list != null && !list.isEmpty()) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            jsonObjectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            try {
                jsonStringList = jsonObjectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return jsonStringList;
    }

    @Override
    public Map jsonToMap(String json) {
        Map mapResult = null;
        if (json != null) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            try {
                mapResult = jsonObjectMapper.readValue(json, Map.class);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
//                log.error(e.getMessage());
            }
        }
        return mapResult;
    }


    /**
     * 取得返回日期
     */
    @Override
    public String dateAdd(String date, String dateType, int addNumber) {
        SimpleDateFormat sdformatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        Date dat = null;
        try {
            dat = sdformatOut.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("无效的日期格式");
        }
        if (dateType.equals("d")) {
            calendar.add(Calendar.DATE, addNumber);
        }
        if (dateType.equals("h")) {
            calendar.add(Calendar.HOUR, addNumber);
        }
        if (dateType.equals("m")) {
            calendar.add(Calendar.MINUTE, addNumber);
        }
        if (dateType.equals("M")) {
            calendar.add(Calendar.MONTH, addNumber);
        }
        if (dateType.equals("y")) {
            calendar.add(Calendar.YEAR, addNumber);
        }
        if (dateType.equals("s")) {
            calendar.add(Calendar.SECOND, addNumber);
        }
        Date calDate = calendar.getTime();
        return sdformatOut.format(calDate);
    }

    /**
     * 取得当前日期
     */
    @Override
    public String toDay(String dataType) {
        SimpleDateFormat sdfOutDate = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(dataType)) {
            sdfOutDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return sdfOutDate.format(Calendar.getInstance().getTime());
    }

    @Override
    public Date dateAddDate(Date date, String dateType, int addNumber) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (dateType.equals("d")) {
            calendar.add(Calendar.DATE, addNumber);
        }
        if (dateType.equals("h")) {
            calendar.add(Calendar.HOUR, addNumber);
        }
        if (dateType.equals("m")) {
            calendar.add(Calendar.MINUTE, addNumber);
        }
        if (dateType.equals("M")) {
            calendar.add(Calendar.MONTH, addNumber);
        }
        if (dateType.equals("y")) {
            calendar.add(Calendar.YEAR, addNumber);
        }
        if (dateType.equals("s")) {
            calendar.add(Calendar.SECOND, addNumber);
        }
        return calendar.getTime();
    }

    @Override
    public Date toDayDate(String dataType) {
        SimpleDateFormat sdfOutDate = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(dataType)) {
            sdfOutDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return Calendar.getInstance().getTime();
    }

    @Override
    public List<Map<String, Object>> jsonToList(String json) {
        List listJson = null;
        if (StringUtils.isNotEmpty(json)) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            JavaType javaType = jsonObjectMapper.getTypeFactory().constructParametricType(ArrayList.class, HashMap.class);
            try {
                listJson = jsonObjectMapper.readValue(json, javaType);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return listJson;
    }

    @Override
    public String mapToJson(Map<String, Object> map) {
        String jsonStringMap = null;
        if (!map.isEmpty()) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            jsonObjectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            try {
                jsonStringMap = jsonObjectMapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return jsonStringMap;
    }

    @Override
    public String jsonResult(String status, String msg, String content) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(ReturnConstant.STATUS, status);
        resultMap.put(ReturnConstant.MSG, msg);
        Map<String, Object> contentMap = new HashMap<String, Object>();
        contentMap.put(ReturnConstant.MSG, content);
        resultMap.put(ReturnConstant.RESULT, contentMap);
        return mapToJson(resultMap);
    }

    @Override
    public String getPrimary() {
        if (SEQ > ROTATION) {
            SEQ = 0;
        }
        return String.format("%1$ty%1$tm%1$td%1$tH%1$tM%1$tS%1$tL%2$05d", System.currentTimeMillis(), ++SEQ);
    }

    @Override
    public Map<String,Object> createEmptyResult() {
        Map<String, Object> content = new HashMap<>();
        content.put(ReturnConstant.RESULT,null);
        content.put(ReturnConstant.INFO,null);
        return content;
    }

    @Override
    public ResponseEntity createErrorResult(Map<String, Object> content, Object result, Object info) {
        if(content==null){
            content = createEmptyResult();
        }
        content.put(ReturnConstant.RESULT,result);
        content.put(ReturnConstant.INFO,info);
        content.put(ReturnConstant.STATUS,ReturnConstant.FAILSTATUS);
        content.put(ReturnConstant.MSG,ReturnConstant.FAILMSG);
        return ResponseEntity.ok(content);
    }

    @Override
    public ResponseEntity createOkResult(Map<String, Object> content, Object result, Object info) {
        if(content==null){
            content = createEmptyResult();
        }
        content.put(ReturnConstant.RESULT,result);
        content.put(ReturnConstant.INFO,info);
        content.put(ReturnConstant.STATUS,ReturnConstant.PASSSTATUS);
        content.put(ReturnConstant.MSG,ReturnConstant.PASSMSG);
        return ResponseEntity.ok(content);
    }
}
