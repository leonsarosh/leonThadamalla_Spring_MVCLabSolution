package leon.spring.mvclabsolution.studentmanagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import leon.spring.mvclabsolution.studentmanagement.model.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException exptn) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = this.session.createQuery("from Student").list();
		return students;
	}

	@Override
	public Student findById(long studentId) {
		Student student = this.session.get(Student.class, studentId);
		return student;
	}

	@Override
	@Transactional
	public void save(Student student) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	@Transactional
	public void delete(long studentId) {
		Transaction tx = this.session.beginTransaction();
		Student student = this.session.get(Student.class, studentId);
		this.session.delete(student);
		tx.commit();
	}

	@Override
	public boolean isLetters(String str) {
		String regex="[a-zA-Z]+";
		return str.matches(regex);
	}

}
