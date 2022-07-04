package leon.spring.mvclabsolution.studentmanagement.service;

import java.util.List;

import leon.spring.mvclabsolution.studentmanagement.model.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(long studentId);
	public void save(Student student);
	public void delete(long studentId);
	public boolean isLetters(String str);
	

}
