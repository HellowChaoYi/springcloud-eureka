package test;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

import test.model.Jsonresult;
import test.model.User;
import test.model.YamlProperties_t;




@CrossOrigin
@ComponentScan
@Configuration
@RestController
@RequestMapping("/db")
public class DbController {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public  YamlProperties_t yamlProperties;

	@RequestMapping(value="/getyml")
	@SentinelResource(value="getyml")
	public Jsonresult getyml(){
		Jsonresult jr=new Jsonresult();
	   
		List<YamlProperties_t> testlist = new ArrayList<YamlProperties_t>();
		testlist.add(yamlProperties);
	    jr.setData(testlist);
	    jr.setCount(1000);
	    jr.setCode(0);
//		String jsonres = Jsonuntil.listtojson(testlist);
	    return jr;
	}
    @RequestMapping(value="/getUsers" )
    public List<Map<String, Object>> getDbType(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
        String sql = "select * from userlogin where username = '"+username+"' and password = "+password;
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        try{
        	 list =  jdbcTemplate.queryForList(sql);
        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println(e.toString());
        }
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet( );
                if(entries != null) {
                    Iterator<Entry<String, Object>> iterator = entries.iterator( );
                    while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

}
