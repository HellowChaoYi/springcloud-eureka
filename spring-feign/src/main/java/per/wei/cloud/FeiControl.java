package per.wei.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import per.wei.cloud.Interface.Logininterface;
import per.wei.cloud.Interface.SchedualServiceHi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@CrossOrigin
@RestController
public class FeiControl implements Logininterface {
	@Autowired
    SchedualServiceHi schedualServiceHi;
	@Autowired
    Logininterface logininterface;
    
	@GetMapping(value = "/index")
    public String sayHi() {
        return schedualServiceHi.sayHiFromClientOne();
    }

	@GetMapping(value = "/getuser")
    public String dblogin(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password) {
        return logininterface.login(username,password);
    }
    
	@GetMapping(value = "/getyml" )
	@HystrixCommand(fallbackMethod = "hiError")
    public String dbgetyml() {
        return logininterface.getyml();
    }

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getyml() {
		// TODO Auto-generated method stub
		return null;
	}
}
