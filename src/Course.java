
public class Course
{
    /*
    name = string
    grade = String
    units = int
     */
    protected  String nameOfCourse;
    protected  String grade;
    protected  int units;

    public String getName() {
        return nameOfCourse;
    }
    public void setName(String name) {
        this.nameOfCourse = name;
    }

    public String  getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }

//    //(DVC)
//    Course(){}

    //(EVC
    Course(String courseName, String grade, int units){
        this.nameOfCourse = courseName;
        this.grade = grade;
        this.units = units;
    }

    public double getPoints()
    {
        String grade = this.grade;
        if(grade.equals("A")){
            return 4;
        }
        else if(grade.equals("B")){
            return 3;
        } else if(grade.equals("C")){
            return 2;
        } else if (grade.equals("D")){
            return 1;
        }else{
            return 0;
        }
    }

    //Missing my equalsMethod
}
/*
Course is a class containing information (name, grade and number of units, …)
and associated operations(constructors, getters, setters, toString, equals, …)
 You may add more variables and methods to the class.
 */