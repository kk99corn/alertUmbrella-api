package com.kk99corn.alertUmbrella.controller;

import com.kk99corn.alertUmbrella.domain.Member;
import com.kk99corn.alertUmbrella.domain.dto.MemberDTO;
import com.kk99corn.alertUmbrella.domain.vo.MemberVO;
import com.kk99corn.alertUmbrella.model.ApiResponseMessage;
import com.kk99corn.alertUmbrella.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

	private final MemberService memberService;

	@Autowired
	private PasswordEncoder passwordEncoder;

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
	public ResponseEntity<ApiResponseMessage> getMember(
			@RequestParam(value = "memberSeq", required = false) Integer memberSeq,
			@RequestParam(value = "memberId", required = false) String memberId,
			@RequestParam(value = "memberPassword", required = false) String memberPassword) {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		MemberVO member = null;
		int status = 0;
		if (memberSeq != null) {
			member = memberService.findByMemberSeq(memberSeq);
			status = HttpStatus.OK.value();
		} else if (memberId != null) {
			member = memberService.findByMemberId(memberId);
			if (member != null) {
				status = HttpStatus.OK.value();
				if (memberPassword != null) {
					if (!passwordEncoder.matches(memberPassword, memberService.findPasswordByMemberId(memberId))) {
						member = null;
						status = HttpStatus.NO_CONTENT.value();
					}
				}
			} else {
				status = HttpStatus.NO_CONTENT.value();
			}
		}

		message.setStatus(status);
		message.setDescription("");
		message.setData(member);

		return new ResponseEntity<>(message, headers, message.getStatus());
	}

	@Operation(summary = "회원 가입", description = "회원 가입 API")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@PostMapping("member")
	public ResponseEntity<ApiResponseMessage> postMember(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("password") String password) {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));


		//동일한 MemberId 체크
		MemberVO memberCheck = memberService.findByMemberId(id);
		if (memberCheck == null) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(id);
			memberDTO.setName(name);
			memberDTO.setPassword(passwordEncoder.encode(password));

			MemberVO member = memberService.joinMember(memberDTO);

			message.setStatus(HttpStatus.OK.value());
			message.setDescription("");
			message.setData(member);
		} else {
			message.setStatus(HttpStatus.NO_CONTENT.value());
			message.setDescription("memberId duplicated");
		}

		return new ResponseEntity<>(message, headers, message.getStatus());
	}

	@Operation(summary = "회원 가입", description = "회원 가입 API")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@PostMapping("test")
	public ResponseEntity<ApiResponseMessage> test(
			@RequestParam("id") String id,
			@RequestParam("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		ApiResponseMessage message = new ApiResponseMessage();

		headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

		//동일한 MemberId 체크
		message.setStatus(HttpStatus.OK.value());
		message.setDescription("");
		message.setData(id + name);

		return new ResponseEntity<>(message, headers, message.getStatus());
	}
}
