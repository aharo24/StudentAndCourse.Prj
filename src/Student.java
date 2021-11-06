import java.util.ArrayList;

class Student {

    String name;
    String id;
    ArrayList<Course> courses = new ArrayList<Course>();

    Student() {
    }    //(DVC)


    //(EVC)
    Student(String name, String id) {
        this.name = name;
        this.id = id;
        courses = new ArrayList<Course>();
    }

    public int completeUnits()
    {
        int x = 0;
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getPoints() > 0) {
                x = x + courses.get(i).units;
            }
        }
        return x;
    }

    public int totalUnits()
    {
        int x = 0;
        for(int i = 0; i < courses.size(); i++) {
            x = x + courses.get(i).units;
        }
        return x;
    }

    void addCourse(Course c) {
        courses.add(c);
    }

    double pointsCalc() // average
    {
        int totalUnits = 0;
        double total_points = 0;

        for (int i = 0; i < courses.size(); i++) {
            totalUnits = totalUnits + courses.get(i).units;
            total_points = total_points + courses.get(i).units * courses.get(i).getPoints();
        }
        return total_points / totalUnits;

    }
    public String toString()
    {
        String gpa = String.valueOf((Math.round(pointsCalc() * 100.0) / 100.0));
        if(gpa.length() < 4) {
            gpa = gpa.concat("0");
        }
        return this.name + "\t" + this.id + "\t" + totalUnits() + "\t\t" + completeUnits() + "\t\t    " + gpa;
    }
}
//    @Override
//    public String toString() {
//        String output = name + "\t\t " + id + "\t   " + totalUnits() + "\t        " + completeUnits() + "\t\t\t\t  " + pointsCalc();
//        return output;
//    }

