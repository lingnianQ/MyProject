import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * redis --test
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/20 19:21
 */
public class Test01 {
    public static void main(String[] args) {
//连接池的两个参数：配置对象、服务器的地址列表
        GenericObjectPoolConfig cfg = new JedisPoolConfig();
        List list = new ArrayList<>();
        list.add(new JedisShardInfo("192.168.64.140", 6379));
        list.add(new JedisShardInfo("192.168.64.140", 6380));
        list.add(new JedisShardInfo("192.168.64.140", 6381));
        //连接池
        ShardedJedisPool pool = new ShardedJedisPool(cfg, list);
        //从连接池获取数据操作工具对象
        ShardedJedis j = pool.getResource();
        //添加100条数据
        for (int i = 0; i < 100; i++) {
            j.set("k" + i, "v" + i);
        }
        pool.close();
    }
}
