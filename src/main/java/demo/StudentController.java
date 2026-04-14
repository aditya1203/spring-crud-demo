package demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class this rest api controller
@RestController
//with this Base URL becomes "https//localhost:8080/student"
@RequestMapping("/student")
public class StudentController {
	private List<Student> students=new ArrayList<>();
	
	//Post Request adding data
	@PostMapping
	public String addStudent(@RequestBody Student student) {
		//@Requestbody JSON -> Java Object
		students.add(student);
		return "Students Added Successfully" ;
	}
	//Read all the students
	@GetMapping
	public List<Student> getAllStudent(){
		return students;
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		return students.stream()
				.filter(s->s.getId()==id)
				.findFirst()
				.orElse(null);
				
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		students.removeIf(s->s.getId()==id);
		return "Student Deleted";
	}
	
}
