package per.wei.cloud.client;

import feign.hystrix.FallbackFactory;

import java.util.Map;

/**
 * @author wei
 * @date 2020/8/7 13:44
 **/
public class DBClientFallBackFactory implements FallbackFactory<DbClient> {
    @Override
    public DbClient create(Throwable throwable) {
        return new DbClient() {
            @Override
            public String Dbgetmenulist() {
                return null;
            }

            @Override
            public String DbcheckUserPermission(Map<String, Object> map) {
                return null;
            }

            @Override
            public String DbcheckUser(Map<String, Object> map) {
                return null;
            }


            @Override
            public String DbgetmenulistByUser(Map map) {
                return null;
            }

            @Override
            public String test() {
                return null;
            }
        };
    }
}
