package com.example.demo.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/2/9 9:54
 */

@Component
@Endpoint(id = "myservice")
public class MyServiceEndPoint {

    @ReadOperation
    public Map getDockerInfo(){
        //端点的读操作
        return Collections.singletonMap("dockerInfo","docker start...");
    }

    @WriteOperation
    public void stopDocker(){
        //端点的写操作
        System.out.println("docker stopper...");
    }

}
