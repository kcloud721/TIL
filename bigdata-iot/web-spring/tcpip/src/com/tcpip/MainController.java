package com.tcpip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chat.Client;

@Controller
public class MainController {
	
	Client client;
	
	public MainController() {
		client = new Client("13.124.204.170",5555,"[KKKK]");
		try {
			client.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/iot.mc")
	public void iot(HttpServletResponse res) throws IOException {		// 화면이동 없으므로  void
		System.out.println("IoT Send Start...");
		client.sendTarget("/13.124.204.170", "100");
		PrintWriter out = res.getWriter();
		out.print("ok");
		out.close();
	}
	@RequestMapping("/phone.mc")
	public void phone() {		// 화면이동 없으므로  void
		System.out.println("Phone Send Start...");
	}
	
}
