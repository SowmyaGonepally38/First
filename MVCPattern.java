/*

The Model View Controller (MVC) design pattern specifies that an application 
consist of a data model, presentation information, and control information. 
The pattern requires that each of these be separated into different objects.
 
The Model contains only the pure application data, it contains no logic describing 
how to present the data to a user.
 
The View presents the model’s data to the user. The view knows how to access 
the model’s data, but it does not know what this data means or what the user can 
do to manipulate it.

The Controller exists between the view and the model. 
It listens to events triggered by the view (or another external source) and
executes the appropriate reaction to these events. 
In most cases, the reaction is to call a method on the model. 
Since the view and the model are connected through a notification mechanism, 
the result of this action is then automatically reflected in the view.

 */

class Student  
{ 
	private String rollNo; 
	private String name; 
	 
	public String getRollNo()  
	{ 
		return rollNo; 
	} 
	 
	public void setRollNo(String rollNo)  
	{ 
		this.rollNo = rollNo; 
	} 
	 
	public String getName()  
	{ 
		return name; 
	} 
	 
	public void setName(String name)  
	{ 
		this.name = name; 
	} 
} 
  
class StudentView  
{ 
	public void printStudentDetails(String studentName, String studentRollNo) 
	{ 
		System.out.println("Student Details: "); 
		System.out.println("Name: " + studentName); 
		System.out.println("Roll No: " + studentRollNo); 
	} 
} 
  
class StudentController  
{ 
	private Student model; 
	private StudentView view; 
  
	public StudentController(Student model, StudentView view) 
	{ 
		this.model = model; 
		this.view = view; 
	} 
  
	public void setStudentName(String name) 
	{ 
		model.setName(name);         
	} 
  
	public String getStudentName() 
	{ 
		return model.getName();         
	} 
  
	public void setStudentRollNo(String rollNo) 
	{ 
		model.setRollNo(rollNo);         
	} 
  
	public String getStudentRollNo() 
	{ 
		return model.getRollNo();         
	} 
  
	public void updateView() 
	{                 
		view.printStudentDetails(model.getName(), model.getRollNo()); 
	} 
	
	public void getStudentDetails() 
	{                 
			model  = StudentService.retriveStudentFromDatabase(); 		
	} 
	    
} 

class StudentService{
	public static Student retriveStudentFromDatabase() 
		{ 
			Student student = new Student(); 
			student.setName("Gopal"); 
			student.setRollNo("14BD1A0532"); 
			return student; 
		} 
}
  
class MVCPattern  
{ 
	public static void main(String[] args)  
	{ 
		StudentView view = new StudentView(); 
		StudentController controller = new StudentController(new Student(), view); 
		
  		controller.getStudentDetails();

		controller.updateView(); 
  
		controller.setStudentName("Vikram Sharma"); 
  
		controller.updateView(); 
	} 

} 