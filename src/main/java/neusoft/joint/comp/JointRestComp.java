package neusoft.joint.comp;

import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.utils.ConvertToJsonString;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Truman on 2017/4/4.
 */
@Component("jointRestComp")
public class JointRestComp {
    private static final Logger logger = LoggerFactory.getLogger(JointRestComp.class);

    public <T> T get(String url, Object requestParams, Class<T> type) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(headers);
        if (requestParams != null) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            Field[] fields = requestParams.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                params.add(new BasicNameValuePair(field.getName(), field.get(requestParams).toString()));
            }
            url = url + "?" + format(params, '&', "UTF-8");
        }
        ResponseEntity<T> response = null;
        try{
            response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, type);
            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info("返回参数：" + ConvertToJsonString.convertToJson(response.getBody()));
            } else {
                logger.info("responseStatusCode: " + response.getStatusCode());
                throw new TracedException(555, "远程服务出现异常，错误代码：" + response.getStatusCode(),
                        "远程服务出现异常，错误代码：" + response.getStatusCode());
            }
        } catch (HttpServerErrorException e) {
            logger.error("请求失败:【HttpServerErrorException】:{}", e.getMessage());
            handleResponse(e.getRawStatusCode(), e.getResponseHeaders());
        } catch (UnknownHttpStatusCodeException e) {
            handleResponse(e.getRawStatusCode(), e.getResponseHeaders());
        } catch (Exception e) {
            logger.error("请求失败:【Exception】:{}", e.getMessage());
            throw new TracedException(555, "业务处理异常", "业务处理异常");
        }
        return response.getBody();
    }

    /**
     * 返回值控制
     * @param httpCode
     * @param headers
     * @param <T>
     * @throws Exception
     */
    private <T> void handleResponse(int httpCode, HttpHeaders headers) throws Exception {
        if (httpCode >= 200 && httpCode < 300) {
            return;
        }
        if (httpCode == 500) {
            int error_code = Integer.parseInt(headers.getFirst("Error-Code"));
            String error_message = headers.getFirst("Message");
            throw new BusiException(error_code, "", URLDecoder.decode(error_message, "UTF-8"));
        }else if(httpCode == 503){
            int error_code = Integer.parseInt(headers.getFirst("Error-Code"));
            String error_message = headers.getFirst("Message");
            throw new BusiException(error_code, "", URLDecoder.decode(error_message, "UTF-8"));
        }else if(httpCode == 555){
            int error_code = Integer.parseInt(headers.getFirst("Error-Code"));
            String error_message = headers.getFirst("Message");
            throw new BusiException(error_code, "", URLDecoder.decode(error_message, "UTF-8"));
        } else {
            throw new BusiException(555, "业务处理异常", "业务处理异常");
        }
    }

    /**
     * get 请求拼接参数
     * @param parameters
     * @param parameterSeparator
     * @param charset
     * @return
     */
    public static String format(List<? extends NameValuePair> parameters, char parameterSeparator, String charset) {
        StringBuilder result = new StringBuilder();
        Iterator i$ = parameters.iterator();

        while(i$.hasNext()) {
            NameValuePair parameter = (NameValuePair)i$.next();
            String name = parameter.getName();
            String value = parameter.getValue();
            if(result.length() > 0) {
                result.append(parameterSeparator);
            }
            result.append(name);
            if(value != null) {
                result.append("=");
                result.append(value);
            }
        }
        return result.toString();
    }

}
