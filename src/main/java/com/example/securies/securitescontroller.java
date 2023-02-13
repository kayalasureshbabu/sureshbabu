package com.example.securies;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class securitescontroller {
	
	@GetMapping("hiii")
	@PreAuthorize("hasRole('Admin')")
	public String login1()
	{
	   return "hi  ksb";
	}
	
	@GetMapping("hii")
	@PreAuthorize("hasRole('USER')")
	public String login2()
	{
	   return "hi  user";
	}
	
//	@GetMapping("hiii")
//	@PreAuthorize("hasrole('manager')")
//	public String login3()
//	{
//	   return "hi  manager";
//	}
	
	@GetMapping("/api/auth")
	
	public String getsecurites()
	{
	   return "display the data";
	}

}
