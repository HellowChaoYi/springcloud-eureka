package per.wei.cloud.client;

import feign.hystrix.FallbackFactory;

/**
 * @author wei
 * @date 2020/8/7 13:44
 **/
public class DBClientFallBackFactory implements FallbackFactory<DbClient> {
    @Override
    public DbClient create(Throwable throwable) {
        return new DbClient() {
            @Override
            public String resttest() {
                System.out.println("faild");
                return null;
            }
        };
    }
}
