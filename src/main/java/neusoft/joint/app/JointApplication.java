package neusoft.joint.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {"holaivy.kepler", "neusoft", "cn.gov.mohrss.mobile.platform"})
public class JointApplication {
    public static void main(String[] args) {
        SpringApplication.run(JointApplication.class, args);
    }
}
