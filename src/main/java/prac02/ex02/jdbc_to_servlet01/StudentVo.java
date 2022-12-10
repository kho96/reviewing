package prac02.ex02.jdbc_to_servlet01;

public class StudentVo {
	private String name;
	private int grade;
	private int myClass;
	private int class_no;

	public StudentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentVo(String name, int grade, int myClass, int class_no) {
		super();
		this.name = name;
		this.grade = grade;
		this.myClass = myClass;
		this.class_no = class_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getMyClass() {
		return myClass;
	}

	public void setMyClass(int myClass) {
		this.myClass = myClass;
	}

	public int getClass_no() {
		return class_no;
	}

	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}

	@Override
	public String toString() {
		return "StudentVo [name=" + name + ", grade=" + grade + ", myClass=" + myClass + ", class_no=" + class_no + "]";
	}

}
