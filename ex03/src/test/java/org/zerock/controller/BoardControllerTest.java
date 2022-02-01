package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//WebApplicationContext를 사용하가 위함
@ContextConfiguration({
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {
    @Setter(onMethod_=@Autowired)
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception{
        ModelAndView modelAndView = mockMvc.perform(MockMvcRequestBuilders.get("/board/list?pageNum=2&&amount=10"))//원하는 방식과, 경로
                .andReturn().getModelAndView();

        ModelMap modelMap = modelAndView.getModelMap();

        String viewName = modelAndView.getViewName();


        log.info("\n...................\n modelMap : "
                +modelMap+"\n viewName : "
                +viewName+"\n...................");
    }

    @Test
    public void testRegister() throws Exception{
        ModelAndView modelAndView = mockMvc.perform(MockMvcRequestBuilders.get("/board/register"))//원하는 방식과, 경로
                .andReturn().getModelAndView();

        ModelMap modelMap = modelAndView.getModelMap();

        String viewName = modelAndView.getViewName();


        log.info("\n...................\n modelMap : "
                +modelMap+"\n viewName : "
                +viewName+"\n...................");
    }

    @Test
    public void testRegisterPost() throws Exception{
        ModelAndView modelAndView = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "제에목")
                .param("content", "내에용")
                .param("writer", "작성자")
                )
                .andReturn().getModelAndView();

        ModelMap modelMap = modelAndView.getModelMap();

        String viewName = modelAndView.getViewName();


        log.info("\n...................\n modelMap : "
                +modelMap+"\n viewName : "
                +viewName+"\n...................");
    }
    
    @Test
    public void testGetAndModify() throws Exception{
        ModelAndView modelAndView = mockMvc.perform(MockMvcRequestBuilders.get("/board/get?bno=8"))
                .andReturn().getModelAndView();

        ModelMap modelMap = modelAndView.getModelMap();

        String viewName = modelAndView.getViewName();


        log.info("\n...................\n modelMap : "
                +modelMap+"\n viewName : "
                +viewName+"\n...................");
    }
    
    @Test
    public void testModify() throws Exception{
        ModelAndView modelAndView = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                .param("bno", "4")
                .param("title", "제에목")
                .param("content", "내에용")
                .param("writer", "작성자")
                )
                .andReturn().getModelAndView();

        ModelMap modelMap = modelAndView.getModelMap();

        String viewName = modelAndView.getViewName();


        log.info("\n...................\n modelMap : "
                +modelMap+"\n viewName : "
                +viewName+"\n...................");
    }
    
    @Test
    public void testRemove() throws Exception{
        ModelAndView modelAndView = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                .param("bno", "4")
                )
                .andReturn().getModelAndView();

        ModelMap modelMap = modelAndView.getModelMap();

        String viewName = modelAndView.getViewName();


        log.info("\n...................\n modelMap : "
                +modelMap+"\n viewName : "
                +viewName+"\n...................");
    }
}
