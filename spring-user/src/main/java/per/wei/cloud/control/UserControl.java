package per.wei.cloud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wei.cloud.service.serviceimpl.BaseDataServiceImpl;
import per.wei.cloud.until.Util;

import java.util.List;

@CrossOrigin
@Controller
public class UserControl {
    @Autowired
    Util util;
    @Autowired
    BaseDataServiceImpl baseDataService;

	@RequestMapping(value = "/login")
    public String getlogin() {
        return "login";
    }
	@RequestMapping(value = "/index")
    public String getIndex() {
        return "index";
    }
	@RequestMapping(value = "/getmenulist")
    public ResponseEntity getmenulist() {
	    List res =baseDataService.getmenulist();
	    ResponseEntity responseEntity = null;
	    if ( res!=null){
	        responseEntity = util.createOkResult(null,res,null);
        }else {
	        responseEntity = util.createErrorResult(null,null,null);
        }
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/gettest")
    public void test(@RequestParam(value = "name",required=false) String sout) {
        System.out.println(sout);
    }
}
