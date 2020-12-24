package per.wei.cloud.until;

import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 工具类
 * pengwei
 */
public interface Util {

    public String objectToJson(Object data);       //list转字符
    public String listObjectToJson(List<Object> list);       //list转字符
    public String listToJson(List<Map<String, Object>> list);       //list转字符
    public Map jsonToMap(String json);  //json字符转Map

    public String dateAdd(String date, String dateType, int addNumber);
    public String toDay(String dataType);
    public Date dateAddDate(Date date, String dateType, int addNumber);
    public Date toDayDate(String dataType);
    public List<Map<String, Object>> jsonToList(String json);
    public String mapToJson(Map<String, Object> map);
    public String jsonResult(String status, String msg, String content);   //创建返回结果
    public String getPrimary();
    public Map<String,Object> createEmptyResult();
    public ResponseEntity createErrorResult(Map<String, Object> content, Object result, String info);
    public ResponseEntity createOkResult(Map<String, Object> content, Object result, String info);

}
