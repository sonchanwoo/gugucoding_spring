package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MyDateDTO;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    @RequestMapping(value="/basic", method= {RequestMethod.GET,RequestMethod.POST})
    public void basicGet() {
        log.info("basicGet.................");
    }
    
    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
        log.info("basicGet2.................");
    }
    
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        //http://localhost:8080/sample/ex01?name=AAA&age=10
        log.info(""+dto);
        
        return "ex01";
    }
    
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        //파라미터와 멤버의 이름이 다른 경우에 유용
        
        //http://localhost:8080/sample/ex02?name=AAA&age=10
        log.info("name : "+name);
        log.info("age : "+age);
        
        return "ex02";
    }
    
    
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
        //배열도 가능
        
        //http://localhost:8080/sample/ex02List?ids=111&ids=122&dis=331
        log.info("ids : "+ids);
        
        return "ex02List";
    }
    
    @GetMapping("/ex03")
    public void ex03(MyDateDTO dto) {//void타입은 매핑ㅇ이름의 jsp파일로 간다
        //http://localhost:8080/sample/ex03?dueDate=2021/12/31
        //MyDateDTO 참고,.,,,
        log.info("dto : "+dto);
    }
    
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        //java beans(없거나, 빈 기본생정자 + setter/getter)는 자동으로 modelAttribute(소문자낙타표기법으로)
        //그렇지 않은 것은 어노테이션 필요!(model.addAttribute("page", page)와 같다)
        
        //http://localhost:8080/sample/ex04?name=chanwoo&age=24&page=9
        
        log.info("dto : "+dto);
        log.info("page : "+page);
        
        return "/sample/ex04";
    }
    
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
        
        //http://localhost:8080/sample/ex06?
        SampleDTO dto = new  SampleDTO();
        dto.setAge(24);
        dto.setName("chanwoo");
        
        //JSON으로 데이터를 전달하는 건 알겠는데, 화면은 얼로가누..?
        
        return dto;
    }
    
    
    
    
    
    
    
    
    
    
}
