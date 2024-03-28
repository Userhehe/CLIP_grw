package com.clip.gwr.ctrl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 아이디 찾기
	 * @param vo
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/findId.do")
	public int idFind(UserVo vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String email = request.getParameter("email");
	    log.info("####email : " + email);
	    UserVo userVo = userService.findUserId(email);

	    if (userVo == null || userVo.getUser_id() == null) {
	    	return 0;
	    }

	    return 1;
//	    String setFrom = "dongin7767@naver.com";
//	    MimeMessage message = javaMailSender.createMimeMessage();
	    
//	    try {
//	        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//	        messageHelper.setFrom(setFrom);
//	        messageHelper.setTo(email);
//	        messageHelper.setSubject("CLIP GROUPWARE 아이디 정보입니다.");
//	        messageHelper.setText("입력하신 이메일에 대한 아이디 정보는 " + userVo.getUser_id() + "입니다.");
//	        javaMailSender.send(message);
//	        return 1;
//	    } catch (MailException | MessagingException e) {
//	        e.printStackTrace();
//	        return 0;
//	    }
	}
	
//	@PostMapping(value = "/sendCertnum.do")
//	public String replacePassword(UserVo vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Map<String, Object> map = new HashMap<String, Object>();
//		String id = request.getParameter("id");
//		log.info("####id : " + id);
//		UserVo userVo = userService.findUserEmail(id);
//	    if (userVo == null || userVo.getUser_email() == null) {
//	    	return "{'입력하신 아이디에 대한 이메일이 존재하지 않습니다.'}";
//	    }
//			
//	    // 메일 발송 로직
//	    log.info("####id : " + userVo.getUser_id());
//	    String setFrom = "dongin7767@naver.com";
//	    MimeMessage message = javaMailSender.createMimeMessage();
//	    
//	    Random random = new Random();
//		int ranNum = random.nextInt(900000) + 100000;
//		System.out.println("####ranNum : " + ranNum);
//		
//		String email = userVo.getUser_email();
//		map.put("user_certnum", ranNum);
//		map.put("user_email", email);
//	    
//	    try {
//	        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//	        messageHelper.setFrom(setFrom);
//	        messageHelper.setTo(userVo.getUser_email());
//	        messageHelper.setSubject("CLIP GROUPWARE 인증번호입니다.");
//	        messageHelper.setText("인증번호는 " + ranNum + "입니다.");
//	        javaMailSender.send(message);
//	        
//	        int updateCertnum =  userService.updateUserCertnum(map);
//
//	        return "{'인증번호가 입력된 아이디의 이메일주소로 발송되었습니다.'}";
//	    } catch (MailException | MessagingException e) {
//	        e.printStackTrace();
//	        return "{'인증번호 발송에 실패하였습니다.'}";
//	    }
//	}
	
//	@PostMapping(value = "/checkCertnum.do")
//	public String compareCertNum(UserVo vo, HttpServletRequest request, HttpServletResponse response){
//		Map<String, Object> map = new HashMap<>();
//	    String id = request.getParameter("id");
//	    log.info("####idddd: " + id);
//	    String certnum = request.getParameter("certnum");
//	    
//	    // 사용자가 올바른 숫자를 입력했는지 확인
//	    try {
//	        int certnumber = Integer.parseInt(certnum);
//	        log.info("####certnummm: " + certnum);
//	        map.put("user_id", id);
//	        UserVo userVo = userService.findUserEmail(id);
//	        log.info("####userVo: " + userVo);
//	        String email = userVo.getUser_email();
//	        log.info("####email : " + email);
//	        map.put("user_certnum", certnumber);
//	        map.put("user_email", email);
//
//	        int checkCertnum = userService.comparisonCertNum(map);
//	        log.info("####저장되어있는 인증번호값 : " + checkCertnum); 
//	        if(compareCertNum >= 1 && userVo != null) {
//	            return "{'인증번호가 일치합니다.'}";
//	        } else {
//	            return "{'인증번호가 일치하지 않습니다.'}";
//	        }
//	    } catch (NumberFormatException e) {
//	        // 클라이언트가 숫자가 아닌 값을 입력한 경우 처리
//	        return "{'올바른 형식의 인증번호를 입력해주세요.'}";
//	    }
//	}
	
}
