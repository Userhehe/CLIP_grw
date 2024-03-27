//package com.clip.gwr.ctrl;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.MailException;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.clip.gwr.conf.RedisKeyExpirationScheduler;
//import com.clip.gwr.model.service.IUserService;
//import com.clip.gwr.vo.UserVo;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@Slf4j
//public class CertnumController {
//	
//	@Autowired
//	private JavaMailSender javaMailSender;
//	
//	@Autowired
//	private IUserService userService;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder; 
//	
//	@Autowired
//    private RedisTemplate<String, Integer> redisTemplate;
//	
//	@Autowired
//	private RedisKeyExpirationScheduler redisKeyExpirationScheduler;
//	
//	@PostMapping("/sendCertnum.do")
//	public int sendCertnum(String id) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		UserVo userVo = userService.findUserEmail(id);
//		// 아이디가 존재하지 않을때
//	    if (userVo == null || userVo.getUser_email() == null) {
//	    	return 0;
//	    }
////	    String setFrom = "dongin7767@naver.com";
////	    MimeMessage message = javaMailSender.createMimeMessage();
//	    
//	    Random random = new Random();
//		int ranNum = random.nextInt(900000) + 100000;
//		System.out.println("####ranNum : " + ranNum);
//		
//		String email = userVo.getUser_email();
//		map.put("user_certnum", ranNum);
//		map.put("user_email", email);
//		
//		String key = "cert_num_" + id; // Redis에 저장할 키 생성
//		
//		ValueOperations<String, Integer> valueOps = redisTemplate.opsForValue();
//        Integer redisCertnum = valueOps.get(key);
//        
//        if(redisCertnum != null) {
//        	redisTemplate.delete(key);
//        }
//		
//        valueOps.set(key, ranNum); // Redis에 랜덤한 값 저장
//        
//        redisKeyExpirationScheduler.setKeyWithExpiration(key, ranNum, 40);
//        
//        // 아이디가 존재할때
//        return 1;
////	    try {
////	        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
////	        messageHelper.setFrom(setFrom);
////	        messageHelper.setTo(userVo.getUser_email());
////	        messageHelper.setSubject("CLIP GROUPWARE 인증번호입니다.");
////	        messageHelper.setText("인증번호는 " + ranNum + "입니다.");
////	        javaMailSender.send(message);
////	        return 1;
////	    } catch (MailException | MessagingException e) {
////	        e.printStackTrace();
////	        return 0;
////	    }
//	}
//	@PostMapping(value = "/checkCertnum.do")
//	public int compareCertNum(int certnum, String id){
//        String key = "cert_num_" + id;
//        ValueOperations<String, Integer> valueOps = redisTemplate.opsForValue();
//        int redisCertnum = valueOps.get(key);
//        log.info("####redisCertnum : " + redisCertnum);
//        log.info("####certnum : " + certnum);
//        if(redisCertnum == certnum) {
//        	// 인증번호가 일치할때
//            return 1;
//        } else {
//        	// 인증번호가 불일치할때
//        	return 0;
//        }
//	}
//	
//	@PostMapping(value = "/updatePasswordForm.do")
//	public String updatePassword(String id, String password){
//		Map<String, Object> map = new HashMap<String, Object>();
//		password = passwordEncoder.encode(password);
//		log.info("####비밀번호 값 : " + password);
//		map.put("password", password);
//		map.put("user_id", id);
//		String key = "cert_num_" + id;
//		try {
//			int updateUser =  userService.updateUserPassword(map);
//			log.info("####updateUser : " + updateUser);
//			redisTemplate.delete(key);
//			return "{ \"message\": \"비밀번호가 변경되었습니다.\" }";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "{ \"message\": \"비밀번호가 변경되지않았습니다.\" }";
//		}
//	}
//	
////	@PostMapping(value = "/deleteRedisKey.do")
////	public String deleteRedisKey(HttpServletRequest request){
////		HttpHeaders headers = new HttpHeaders();
////        headers.set("Content-Type", "text/html; charset=UTF-8");
////		String id = request.getParameter("id");
////		String key = "cert_num_" + id;
////		redisTemplate.delete(key);
////		return "{ \"message\": \"인증번호가 만료되었습니다.\" }";
////	}
//}
