package com.uam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uam.service.UserService;
import com.uam.util.CustomMessage;
import com.uam.util.RestURIConstants;
import com.uam.util.UserRequest;

@RestController
@RequestMapping("UAM")
public class UsersController {
	
	@Autowired
	
	UserService userService;
	
	 @RequestMapping(value = RestURIConstants.GET_USER_CURRENT_STATUS , method = RequestMethod.POST) 
		public CustomMessage storeCurrentUserStatus(@Validated @RequestBody UserRequest userRequest) {
		 //System.out.println(userService+"--------------------");
		 CustomMessage customMessage  = new CustomMessage();
		 String mobile  = userRequest.getMobile();
		 String lat  = userRequest.getLatitude();
		 String longitude  = userRequest.getLongitude();
		 String status=  userRequest.getStatus();
		 long userId  = userRequest.getUserId();
		if(status==null || status.trim().length() < 1) {
		 if(mobile==null || mobile.trim().length() !=10) {
			 customMessage.setResponceCode("400");
			 customMessage.setResponceMessage("Invalide mobile no.");
			 return customMessage;
		 }
		 if(lat==null || longitude==null ||longitude.trim().length() <=1 || lat.trim().length() <=1) {
			 customMessage.setResponceCode("400");
			 customMessage.setResponceMessage("Invalide longitude or latitude.");
			 return customMessage;
		 }
		 //do some thing here 
		 String count = userService.findMobileNo(mobile);
		 System.out.println(count+"-------------");
		 if(count==null || count.trim().length()==0 || "0".equalsIgnoreCase(count)) {
			 customMessage.setResponceCode("400");
			 customMessage.setResponceMessage("Phone no is not present in database.Please check :"+mobile);
			 return customMessage;
		 }
		}else {
			//user status update to be save here
		}
		 customMessage.setResponceCode("200");
		 customMessage.setResponceMessage("Success.");
		// System.out.println(mobile+"--mobile--"+lat+"--lat--"+longitude+"--longitude--"+status+"--status--"+userId+"--userId--");
			return customMessage;
		}

}
