package com.kk99corn.alertUmbrella.controller;

import com.kk99corn.alertUmbrella.domain.Area;
import com.kk99corn.alertUmbrella.domain.vo.AreaDetailVO;
import com.kk99corn.alertUmbrella.domain.vo.AreaVO;
import com.kk99corn.alertUmbrella.model.ApiResponseMessage;
import com.kk99corn.alertUmbrella.service.AreaDetailService;
import com.kk99corn.alertUmbrella.service.AreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AreaController {

	private final AreaService areaService;
	private final AreaDetailService areaDetailService;

	public AreaController(AreaService areaService, AreaDetailService areaDetailService) {
		this.areaService = areaService;
		this.areaDetailService = areaDetailService;
	}

	@Operation(summary = "지역시퀀스로 지역 조회", description = "지역시퀀스로 지역 조회 API")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@GetMapping("area")
	public ResponseEntity<ApiResponseMessage> getArea(
			@RequestParam(value = "areaSeq", required = false) Integer areaSeq) {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		int status = 0;
		if (areaSeq != null) {
			AreaVO areaVO = areaService.findByAreaSeq(areaSeq);
			status = HttpStatus.OK.value();
			message.setData(areaVO);
		} else {
			List<AreaVO> areaList = areaService.findAll();
			status = HttpStatus.OK.value();
			message.setData(areaList);
		}

		message.setStatus(status);
		message.setDescription("");

		return new ResponseEntity<>(message, headers, message.getStatus());
	}

	@Operation(summary = "지역시퀀스로 상세지역 조회", description = "지역시퀀스로 상세지역 조회 API")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@GetMapping("areaDetail")
	public ResponseEntity<ApiResponseMessage> getAreaDetail(
			@RequestParam(value = "areaSeq", required = true) Integer areaSeq) {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		int status = 0;
		List<AreaDetailVO> areaDetailVOList = null;
		if (areaSeq != null) {
			areaDetailVOList = areaDetailService.findByAreaSeq(areaSeq);
			status = HttpStatus.OK.value();
		}

		message.setStatus(status);
		message.setDescription("");
		message.setData(areaDetailVOList);

		return new ResponseEntity<>(message, headers, message.getStatus());
	}

}
