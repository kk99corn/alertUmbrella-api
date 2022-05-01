package com.kk99corn.alertUmbrella.controller;

import com.kk99corn.alertUmbrella.DTO.member.MemberDTO;
import com.kk99corn.alertUmbrella.domain.Member;
import com.kk99corn.alertUmbrella.model.ApiResponseMessage;
import com.kk99corn.alertUmbrella.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@Operation(summary = "회원번호로 회원 조회", description = "회원번호로 회원 조회 API")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@GetMapping("member")
	public ResponseEntity<ApiResponseMessage> getMember(@RequestParam("memberSeq") int memberSeq) {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		Member member = memberService.findByMemberSeq(memberSeq);

		message.setStatus(HttpStatus.OK.value());
		message.setDescription("");
		message.setData(member);

		return new ResponseEntity<>(message, headers, message.getStatus());
	}

	@PostMapping("member")
	public ResponseEntity<ApiResponseMessage> postMember(@RequestParam("id") String id, @RequestParam("password") String password) {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPassword(password);

		Member member = memberService.joinMember(memberDTO);

		message.setStatus(HttpStatus.OK.value());
		message.setDescription("");
		message.setData(member);

		return new ResponseEntity<>(message, headers, message.getStatus());
	}
}
