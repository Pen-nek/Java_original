package com.light.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.light.domain.EmployeeVO;
import com.light.service.MyPageService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor

public class MyPageController {


   private MyPageService service;
   
   @GetMapping("/mypage")
   public void show(Model model, HttpSession session) {
      
      int userId = (int)session.getAttribute("userId");

      model.addAttribute("employee", service.show(userId));
   }
   
   
   
   @PostMapping("/emp_modify")
   public String update(EmployeeVO employee, RedirectAttributes rttr) {
      service.emp_modify(employee);
      // rttr.addFlashAttribute("e_id", employee.getE_id());
      return "redirect:/mypage";
   }
}

