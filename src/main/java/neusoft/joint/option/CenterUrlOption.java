package neusoft.joint.option;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by leon on 2017/6/20.
 */

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "center")
public class CenterUrlOption {

    private String serviceUrl;
    private String s88888;
    private String s90001;
    private String s90002;
    private String s90003;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getS88888() {
        return s88888;
    }

    public void setS88888(String s88888) {
        this.s88888 = s88888;
    }

    public String getS90001() {
        return s90001;
    }

    public void setS90001(String s90001) {
        this.s90001 = s90001;
    }

    public String getS90002() {
        return s90002;
    }

    public void setS90002(String s90002) {
        this.s90002 = s90002;
    }

    public String getS90003() {
        return s90003;
    }

    public void setS90003(String s90003) {
        this.s90003 = s90003;
    }
}
