package org.schoolrole.test;


import java.util.Iterator;
import java.util.List;

import org.schoolrole.dao.MajorDao;
import org.schoolrole.dao.ClassDao;
import org.schoolrole.dao.RewordandPublishmentDao;
import org.schoolrole.dao.ManagerDao;
import org.schoolrole.dao.StudentDao;
import org.schoolrole.model.Manager;
import org.schoolrole.model.Major;
import org.schoolrole.model.RewordorPublishment;
import org.schoolrole.model.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagerDao managerDao=new ManagerDao();
		Manager manager=managerDao.login("guanliyuan001", "001");
		System.out.println(manager.getPassword());
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.login("200001101", "200001101");//查询是否存在此学生
		System.out.println(student.getAddress());
		System.out.println(studentDao.getStudentByStuNum("200001100").getName());
		List<Student> list=studentDao.getAllStudent();
		Iterator itor=list.iterator();
		while(itor.hasNext()){
			student=(Student) itor.next();
			System.out.println(student.getName());
			
		}
		Student student2=new Student(); 
		student2.setId(10);
		student2.setStudentNumber("10000");
		student2.setName("jvmd");
		//studentDao.insertStudent(student2);
		 MajorDao majorDao=new MajorDao();
		 List<Major> listmajor=majorDao.getAllMajorByCollegeID(3);
		 for(Major major:listmajor){
			 System.out.println(major.getMajorName());
		 }
		 //Major major1=new Major();
		 ClassDao classDao=new ClassDao();
		 classDao.deleteClassByID(7);
		 RewordandPublishmentDao rePubDao=new RewordandPublishmentDao();
		 for(RewordorPublishment repub:rePubDao.getRePub()){
			 System.out.println(repub.getNum());
	
		 }
	}

}
