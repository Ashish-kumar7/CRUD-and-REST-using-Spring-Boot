package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("inside home buddy");
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		System.out.println("inside the addAlien buddy");
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(int aid) {
		System.out.println("inside the getAlien buddy " + aid);
		ModelAndView mv=new ModelAndView("ShowAlien.jsp");
		Alien obj1=repo.findById(aid).orElse(new Alien());
		System.out.println("the object recieved is " + obj1);
		mv.addObject("obj1", obj1);
		System.out.println("after effect " + obj1);
		return mv;
	}
	
	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		System.out.println("inside the updateAlien buddy");
//		int aid1=alien.getAid();
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/deleteAlien")
	public String deleteAlien(Alien alien) {
		System.out.println("inside the deleteAlien buddy");
//		int aid1=alien.getAid();
		repo.delete(alien);
		return "home.jsp";
	}
	
	  @RequestMapping("/findAlien") 
	  public ModelAndView findAlien(String tech) {
		  System.out.println("inside the getAlien buddy " + tech);
		  ModelAndView mv=new ModelAndView("ShowAlien.jsp");
		  System.out.println(repo.findByatech(tech));
		  List<Alien>alien=repo.findByatech(tech);
		  System.out.println("the object recieved is " + alien); 
		  System.out.println(repo.findByatechsorted(tech));
		  mv.addObject("obj1",alien);
		  return mv; 
	  }
	
	//REST way of getaliens (GET request)
	@GetMapping("/aliens")
	@ResponseBody
	public List<Alien> restgetaliens() {
		return repo.findAll();
	}
	
	//REST way of getalien based on aid (GET request)
	@GetMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> restgetalien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	//REST way of inserting data to database (POST request)
	@PostMapping("/alien")
	@ResponseBody
	public Alien restpostalien(@RequestBody Alien alien){
		repo.save(alien);
		return alien;
	}
	
	//REST way of updating data to database (PUT request)
	@PutMapping("/alien")
	@ResponseBody
	public Alien restupdatealien(@RequestBody Alien obj) {
		repo.save(obj);
		return obj;
	}
	
	//REST way of Deleting data from database (DELETE request)
	@DeleteMapping("/alien/{aid}")
	@ResponseBody
	public String restdeletealien(@PathVariable("aid") int aid) {
		repo.deleteById(aid);
		return "Deleted";
	}
}























