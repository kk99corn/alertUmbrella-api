package com.kk99corn.alertUmbrella.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@Operation(summary = "test hello", description = "hello api example")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@GetMapping("member")
	public Member getMember(@RequestParam("memberSeq") int memberSeq){
		return memberService.findByMemberSeq(memberSeq);
	}

	@GetMapping("test")
	public ResponseEntity<ApiResponseMessage> test() {
		Member member = memberService.findByMemberSeq(1);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		ApiResponseMessage message = new ApiResponseMessage();
		message.setStatus(200);
		message.setDescription("");
		message.setData(member);

		return new ResponseEntity<>(message, headers, HttpStatus.OK);
	}

	@GetMapping("members")
	public ResponseEntity<ApiResponseMessage> getMembers() {
		List<Member> memberList = memberService.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		ApiResponseMessage message = new ApiResponseMessage();
		message.setStatus(200);
		message.setDescription("");
		message.setData(memberList);

		return new ResponseEntity<>(message, headers, HttpStatus.OK);
	}
}
