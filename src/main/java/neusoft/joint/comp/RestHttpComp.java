package neusoft.joint.comp;


import com.fasterxml.jackson.databind.JsonNode;
import ivy.json.Json2;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.net.URLDecoder;

@Component
public class RestHttpComp {

	public static final Logger logger = LoggerFactory.getLogger(RestHttpComp.class);

	RestTemplate restTemplate = new RestTemplate();

	private <T> T exchange(String url, HttpMethod method, HttpHeaders header, Object requestEntity, Class<T> clazz,
						   Object... uriVariables) throws Exception {

		HttpEntity<JsonNode> httpEntity = new HttpEntity<JsonNode>(Json2.mapper.valueToTree(requestEntity), header);

		ResponseEntity<T> response = null;
		try {
			response = restTemplate.exchange(url, method, httpEntity, clazz, uriVariables);
		} catch (HttpServerErrorException e) {
			handleResponse(e.getRawStatusCode(), e.getResponseHeaders());
		} catch (UnknownHttpStatusCodeException e) {
			handleResponse(e.getRawStatusCode(), e.getResponseHeaders());
		} catch (Exception e) {
			throw new TracedException(555, "业务处理异常", "业务处理异常");
		}

		return response.getBody();

	}

	private <T> void handleResponse(int httpCode, HttpHeaders headers) throws Exception {
		logger.info("Response Code:" + httpCode);
		if (httpCode >= 200 && httpCode < 300) {
			return;
		}
		if (httpCode >= 500 && httpCode < 600) {
			int error_code = Integer.parseInt(headers.getFirst("Error-Code"));
			String error_message = headers.getFirst("Message");
			logger.error("HTTP ERROR CODE:" + error_code);
			logger.error("HTTP ERROR MESSAGE:" + URLDecoder.decode(error_message, "UTF-8"));
			throw new TracedException(error_code, "", URLDecoder.decode(error_message, "UTF-8"));

		} else {
			throw new TracedException(555, "业务处理异常", "业务处理异常");
		}
	}

	public <T> T getJson(String url, HttpHeaders header, Class<T> clazz, Object... uriVariables) throws Exception {
		return exchange(url, HttpMethod.GET, header, null, clazz, uriVariables);
	}

	public <T> T postJson(String url, HttpHeaders header, Class<T> clazz, Object requestEntity, Object... uriVariables)
			throws Exception {
		return exchange(url, HttpMethod.POST, header, requestEntity, clazz, uriVariables);
	}
}
