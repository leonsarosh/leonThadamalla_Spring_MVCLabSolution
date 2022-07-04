package leon.spring.mvclabsolution.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import leon.spring.mvclabsolution.studentmanagement.model.Student;
import leon.spring.mvclabsolution.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model themodel) {
		List<Student> students = studentService.findAll();
		themodel.addAttribute("studentlist", students);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel) {
		Student student = new Student();
		themodel.addAttribute("student", student);
		themodel.addAttribute("mode", "Add");
		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model themodel, @RequestParam("studentId") long studentId) {
		Student student = studentService.findById(studentId);
		themodel.addAttribute("student", student);
		themodel.addAttribute("mode", "Update");
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") long studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student = null;
		if (studentId == 0) {
			if (firstName == "" || lastName == "" || course == "" || country == ""
					|| studentService.isLetters(firstName) == false || studentService.isLetters(lastName) == false
					|| studentService.isLetters(course) == false || studentService.isLetters(country) == false) {
				return "redirect:showFormForAdd";
			} else {
				student = new Student(firstName, lastName, course, country);
				studentService.save(student);
				return "redirect:list";
			}
		} else {
			if (firstName == "" || lastName == "" || course == "" || country == "" || studentId == 0
					|| studentService.isLetters(firstName) == false || studentService.isLetters(lastName) == false
					|| studentService.isLetters(course) == false || studentService.isLetters(country) == false) {
				return "redirect:list";
			} else {
				student = studentService.findById(studentId);
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setCourse(course);
				student.setCountry(country);
				studentService.save(student);
				return "redirect:list";
			}
		}
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") long studentId) {
		studentService.delete(studentId);
		return "redirect:list";
	}

}
