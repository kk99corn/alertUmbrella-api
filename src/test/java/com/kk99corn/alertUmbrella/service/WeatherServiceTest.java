package com.kk99corn.alertUmbrella.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
public class WeatherServiceTest {
	private final String serviceKey = "szk5CxTs%2F%2BerRJAUTQdc1y0wtbf4ao24VyAim0D%2FMUBWIlElmSN8cWzGvzhTDu1hoyaKWyHHzCeTcmRwTEpFoQ%3D%3D";
	// private final String serviceKey = "szk5CxTs/+erRJAUTQdc1y0wtbf4ao24VyAim0D/MUBWIlElmSN8cWzGvzhTDu1hoyaKWyHHzCeTcmRwTEpFoQ==";

	@Test
	void weatherApiTest() {
//		// 현재시간
//		Date now = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//		String baseDate = simpleDateFormat.format(now);
//		simpleDateFormat = new SimpleDateFormat("HHmm");
//		String baseTime = simpleDateFormat.format(now);
//		System.out.println("baseDate = " + baseDate);
//		System.out.println("baseDate = " + baseTime);
//
//		// RestTemplate 객체 생성
//		RestTemplate restTemplate = new RestTemplate();
//
//		// 1. HttpHeaders 객체 생성
//		HttpHeaders headers = new HttpHeaders();
//
//		// 2. 헤더 설정 : ContentType, Accept 설정
//		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//
//		// 요청 URL 및 쿼리스트링 설정
//		String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
//		String queryString = "?serviceKey=szk5CxTs%2F%2BerRJAUTQdc1y0wtbf4ao24VyAim0D%2FMUBWIlElmSN8cWzGvzhTDu1hoyaKWyHHzCeTcmRwTEpFoQ%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20220606&base_time=1100&nx=55&ny=128";
//		UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + queryString).build();
////		UriComponents url = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst")
////				//.queryParam("ServiceKey", URLEncoder.encode(serviceKey, StandardCharsets.UTF_8))
////				.queryParam("serviceKey", "szk5CxTs%2F%2BerRJAUTQdc1y0wtbf4ao24VyAim0D%2FMUBWIlElmSN8cWzGvzhTDu1hoyaKWyHHzCeTcmRwTEpFoQ%3D%3D")
////				.queryParam("pageNo", 1)
////				.queryParam("numOfRows", 1000)
////				.queryParam("dataType", "JSON")
////				.queryParam("base_date", baseDate)
////				.queryParam("base_time", "1100")
////				.queryParam("nx", 55)
////				.queryParam("ny", 128)
////				.build();
//
//		//System.out.println("url = " + url.toString());
//
//		// HTTP GET 요청
//		ResponseEntity<String> response = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);
//		System.out.println("response = " + response);
	}

	@Test
	void apiTest() throws IOException {

		// 현재시간
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String baseDate = simpleDateFormat.format(now);
		simpleDateFormat = new SimpleDateFormat("HHmm");
		String baseTime = simpleDateFormat.format(now);

		String urlBuilder = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst" + "?"
				+ URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) + "=szk5CxTs%2F%2BerRJAUTQdc1y0wtbf4ao24VyAim0D%2FMUBWIlElmSN8cWzGvzhTDu1hoyaKWyHHzCeTcmRwTEpFoQ%3D%3D" + /*Service Key*/
				"&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8) + /*페이지번호*/
				"&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1000", StandardCharsets.UTF_8) + /*한 페이지 결과 수*/
				"&" + URLEncoder.encode("dataType", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("JSON", StandardCharsets.UTF_8) + /*요청자료형식(XML/JSON) Default: XML*/
				"&" + URLEncoder.encode("base_date", StandardCharsets.UTF_8) + "=" + URLEncoder.encode(baseDate, StandardCharsets.UTF_8) + /*‘21년 6월 28일 발표*/
				"&" + URLEncoder.encode("base_time", StandardCharsets.UTF_8) + "=" + URLEncoder.encode(baseTime, StandardCharsets.UTF_8) + /*06시 발표(정시단위) */
				"&" + URLEncoder.encode("nx", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("55", StandardCharsets.UTF_8) + /*예보지점의 X 좌표값*/
				"&" + URLEncoder.encode("ny", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("128", StandardCharsets.UTF_8);/*URL*//*예보지점의 Y 좌표값*/
		URL url = new URL(urlBuilder);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
	}
}
