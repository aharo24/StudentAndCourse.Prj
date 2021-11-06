import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageStudent {

    public static void main(String[] args) {
        String fileName, line;
        String grade, name, id, nameOfCourse;
        int unitsCount, units;
        int totalUnits = 0;
        int completedUnits = 0;


        ArrayList<Student> studentArrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name: ");
        fileName = sc.next();
        try {
            File file = new File(fileName);
            Scanner fileSc = new Scanner(file);

            if (!fileSc.hasNext()) {
                System.out.println("File has no data.");
                System.exit(0);
            }
            while (fileSc.hasNext()) {
                String[] nameArray = fileSc.nextLine().split(",");
                name = nameArray[1] + " " + nameArray[0];
                name = name.strip();
                id = fileSc.next();
                unitsCount = fileSc.nextInt();
                fileSc.nextLine();
                if (name.charAt(0) == ' ') {
                    name = name.replaceFirst(" ", "");
                }

                Student student = new Student(name, id);
                for (int i = 0; i < unitsCount; i++) {
                    nameOfCourse = fileSc.nextLine();
                    grade = fileSc.next();
                    units = fileSc.nextInt();
                    fileSc.nextLine();

                    Course course = new Course(nameOfCourse, grade, units);
                    student.addCourse(course);
                }
                studentArrayList.add(student);
            }
            System.out.println("Name" + "\t\tId" + "\t\tUnits Taken" + "\tUnits Completed" + "   Average");
            for (int i = 0; i < studentArrayList.size(); i++) {
                System.out.println(studentArrayList.get(i));
                totalUnits = totalUnits + studentArrayList.get(i).totalUnits();
                completedUnits = completedUnits + studentArrayList.get(i).completeUnits();
            }

            System.out.println("");
            System.out.println("Total number of Students: " + studentArrayList.size());
            System.out.println("");
            System.out.println("Total Units completed by all students: " + completedUnits);
            System.out.println("Total Units taken by all students: " + totalUnits);
        } catch (Exception e) {
            System.out.println("Bad file name or location, can't open file.");
        }
    }
}

