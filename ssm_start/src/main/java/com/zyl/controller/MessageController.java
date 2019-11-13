package com.zyl.controller;

import com.zyl.domain.Message;
import com.zyl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
//@SessionAttributes(value = {"t_msg"})
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层findall");
        // 调用业务层service方法
        List<Message> list = messageService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    /**
     * 保存
     * @return
     */
    @RequestMapping("/save")
    public void save(Message message, HttpServletRequest request, HttpServletResponse response) throws IOException {
        messageService.saveMessage(message);
        response.sendRedirect(request.getContextPath()+"/message/findAll");
        return;
    }

    @RequestMapping("/testModel")
    public String testModel(Map<String, Object> map) throws IOException, ServletException {
        map.put("t_msg", "aaa");
        return "forward:/message/show";
    }

    @RequestMapping("/show")
    public String show(@ModelAttribute("t_msg")String msg, HttpServletRequest request) {
//        String msg = (String) map.get("t_msg");
        System.out.println("show msg:"+msg);
        String req_msg = (String) request.getAttribute("t_msg");

//        String sess_msg = (String) request.getSession().getAttribute("t_msg");
        System.out.println("show req_msg:"+req_msg);
//        System.out.println("show sess_msg:"+sess_msg);
        return "list";
    }

}
