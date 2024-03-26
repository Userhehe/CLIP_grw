package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CertnumController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
    private RedisTemplate<String, Integer> redisTemplate;
	
	@PostMapping("/sendCertNum.do")
	public ResponseEntity<String> sendCertNum(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "text/html; charset=UTF-8");
		String id = request.getParameter("id");
		UserVo userVo = userService.findUserEmail(id);
	    if (userVo == null || userVo.getUser_email() == null) {
	    	return new ResponseEntity<>("입력하신 아이디에 대한 이메일이 존재하지 않습니다.", headers, HttpStatus.OK);
	    }
	    String setFrom = "dongin7767@naver.com";
	    MimeMessage message = javaMailSender.createMimeMessage();
	    
	    Random random = new Random();
		int ranNum = random.nextInt(900000) + 100000;
		System.out.println("####ranNum : " + ranNum);
		
		String email = userVo.getUser_email();
		map.put("user_certnum", ranNum);
		map.put("user_email", email);
	    
		String key = "cert_num_" + id; // Redis에 저장할 키 생성
        ValueOperations<String, Integer> valueOps = redisTemplate.opsForValue();
        valueOps.set(key, ranNum); // Redis에 랜덤한 값 저장
        
	    try {
	        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	        messageHelper.setFrom(setFrom);
	        messageHelper.setTo(userVo.getUser_email());
	        messageHelper.setSubject("CLIP GROUPWARE 인증번호입니다.");
	        messageHelper.setText("인증번호는 " + ranNum + "입니다.");
	        javaMailSender.send(message);
	
	        return new ResponseEntity<>("인증번호가 입력된 아이디의 이메일주소로 발송되었습니다.", headers, HttpStatus.OK);
	    } catch (MailException | MessagingException e) {
	        e.printStackTrace();
	        return new ResponseEntity<>("인증번호 발송에 실패하였습니다.", headers, HttpStatus.OK);
	    }
	}
	@PostMapping(value = "/comparisonCertNumForm.do")
	public ResponseEntity<String> compareCertNum(UserVo vo, HttpServletRequest request, HttpServletResponse response){
		HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/html; charset=UTF-8");
        String id = request.getParameter("id");
        String key = "cert_num_" + id;
        ValueOperations<String, Integer> valueOps = redisTemplate.opsForValue();
        int redisCertnum = valueOps.get(key);
        String certnum = request.getParameter("certnum");
        int certnumber = Integer.parseInt(certnum);
        log.info("####redisCertnum : " + redisCertnum);
        log.info("####certnumber : " + certnumber);
        if(redisCertnum == certnumber) {
            return new ResponseEntity<>("인증번호가 일치합니다.", headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("인증번호가 일치하지 않습니다.", headers, HttpStatus.OK);
        }
	}
	
	@PostMapping(value = "/updatePasswordForm.do")
	public ResponseEntity<String> updatePassword(UserVo vo, HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/html; charset=UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
		password = passwordEncoder.encode(password);
		log.info("####비밀번호 값 : " + password);
		map.put("password", password);
		map.put("user_id", id);
		String key = "cert_num_" + id;
		try {
			int updateUser =  userService.updateUserPassword(map);
			log.info("####updateUser : " + updateUser);
			redisTemplate.delete(key);
			return new ResponseEntity<>("비밀번호가 변경되었습니다.", headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("비밀번호가 변경되지않았습니다.", headers, HttpStatus.OK);
		}
	}
}
