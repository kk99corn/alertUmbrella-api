package com.kk99corn.alertUmbrella.controller;

import com.kk99corn.alertUmbrella.domain.vo.AreaVO;
import com.kk99corn.alertUmbrella.model.ApiResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {
	// https://www.data.go.kr/iim/api/selectAPIAcountView.do
	private final String host = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
	private final String serviceKey = "szk5CxTs%2F%2BerRJAUTQdc1y0wtbf4ao24VyAim0D%2FMUBWIlElmSN8cWzGvzhTDu1hoyaKWyHHzCeTcmRwTEpFoQ%3D%3D";

	@Operation(summary = "지역 날씨 조회", description = "지역 날씨 조회 API")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@GetMapping("weather")
	public ResponseEntity<ApiResponseMessage> getWeather(
			@RequestParam(value = "x") Integer x,
			@RequestParam(value = "y") Integer y
	) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
		// 현재시간
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String baseDate = simpleDateFormat.format(now);
		simpleDateFormat = new SimpleDateFormat("HHmm");
		String baseTime = simpleDateFormat.format(now);

		String urlBuilder = host
				+ "?serviceKey=" + serviceKey
				+ "&pageNo=1"
				+ "&numOfRows=1000"
				+ "&dataType=JSON"
				+ "&base_date=" + baseDate
				+ "&base_time=" + baseTime
				+ "&nx=" + x
				+ "&ny=" + y;

		URL url = new URL(urlBuilder);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder resultJsonText = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			resultJsonText.append(line);
		}
		rd.close();
		conn.disconnect();

		int status = 0;
		status = HttpStatus.OK.value();

		message.setStatus(status);
		message.setDescription("");
		message.setData(resultJsonText.toString());

		return new ResponseEntity<>(message, headers, message.getStatus());

	}
}
