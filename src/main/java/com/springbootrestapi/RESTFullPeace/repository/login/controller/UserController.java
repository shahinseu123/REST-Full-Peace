package com.springbootrestapi.RESTFullPeace.repository.login.controller;


	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.Authentication;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

import com.springbootrestapi.RESTFullPeace.login.model.User;
import com.springbootrestapi.RESTFullPeace.repository.login.service.UserService;

	
	@Controller
	public class UserController {
		
	   @Autowired	
	   private UserService userService;
	   
	   @RequestMapping(value ={"/", "/login"},method=RequestMethod.GET)
	   public ModelAndView login(){
		   ModelAndView model = new ModelAndView();
		   model.setViewName("user/login");
		   return model;
		      
	   }
	  @RequestMapping(value ={"/signup"}, method=RequestMethod.GET)
	  public ModelAndView signup(){
		  ModelAndView model = new ModelAndView();
		   User user = new User();
		   model.addObject("user", user);
		   model.setViewName("user/signup");
		   return model;
		  
	  }
	  @RequestMapping(value ={"/signup"}, method=RequestMethod.POST)
	  public ModelAndView createUser(@Valid User user, BindingResult bindingResult){
		  ModelAndView model = new ModelAndView();
		  User userExists = userService.findUserByEmail(user.getEmail());
		    if(userExists != null){
		    	bindingResult.rejectValue("email", "error.user", "This email already exists!");
		    }
		    if(bindingResult.hasErrors()){
		    	model.setViewName("user/signup");
		    }
		    else{
		    	userService.saveUser(user);
		    	model.addObject("msg", "User has been register successfully");
		    	model.addObject("user", new User());
		    }
		return model;
	  
	}
	  @RequestMapping(value ={"/home/home"}, method=RequestMethod.GET)
	  public ModelAndView home(){
		  ModelAndView model = new ModelAndView();
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  User user = userService.findUserByEmail(auth.getName());
		  model.addObject("user", user.getFirstname()+" "+ user.getLastname());
		  model.setViewName("home/home");
		  
		return model;
		  
	  }
	  public ModelAndView accessDenied(){
		  ModelAndView model = new ModelAndView();
		  model.setViewName("error/access_denied");
		  
		return model;
		  
	  }
	  
	

}
