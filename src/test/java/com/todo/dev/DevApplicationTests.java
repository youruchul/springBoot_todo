package com.todo.dev;

import com.todo.dev.security.SecurityService;
import com.todo.dev.domain.dto.Members;
import com.todo.dev.domain.request.LoginRequest;
import com.todo.dev.repository.MembersRepository;
import com.todo.dev.security.TokenInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevApplicationTests {
	@Autowired
	MembersRepository membersRepository;
	@Autowired
	SecurityService securityService;
	@Test
	void contextLoads() {
	}
	@Test
	void loginTest(){
		LoginRequest request = new LoginRequest("park","1234");
		Members findMember = membersRepository.findByIdAndPw(request);
		System.out.println(findMember.toString());
	}
	@Test
	void ValueTest(){
		Members member = new Members(1,"park","1234","park","01012341234");
		String token = securityService.createToken(member);
		System.out.println(token);
	}
	@Test
	void parseTokenTest(){
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJwaG9uZU51bWJlciI6IjAxMDEyMzQxMjM0IiwibmFtZSI6InBhcmsiLCJpZCI6MSwiZXhwIjoxNjc2MDAxODQ5fQ.EEQOuTvQ-utp_BcNNU8sk3sng4Nh7D7tScR1GvtqqaEuwouAvblPoN9xEoy8t8VyksJFRk84mD3orK8ARd_L9A";
		TokenInfo info = securityService.parseToken(token);
		System.out.println(info.toString());
	}
	@Test
	void builderTest(){
		Members member = Members
				.builder()
				.id(1)
				.member_id("park")
				.member_pw("1234")
				.name("park")
				.phone_number("01012341234")
				.build();
		System.out.println(member.toString());
	}
}
