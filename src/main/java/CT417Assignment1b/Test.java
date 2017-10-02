package CT417Assignment1b;

import StudentReg.*;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args){
        Student s1 = new Student("SeanORiordan", "06/11/1996","A1");
        Student s2 = new Student("JaneDoe", "11/12/1996", "A2");
        Student s3 = new Student("JohnSmith", "1/1/2000", "00");

        Module mod1 = new Module("Software Engineering III", "CT417");
        Module mod2 = new Module("Telecommunications Software Applications", "EE453");

        CourseProgramme ECE = new CourseProgramme("Electronic and Computer Engineering", "01/09/2017", "31/08/2018");

        ECE.addModule(mod1);
        ECE.addModule(mod2);
        mod1.addStudent(s1);
        mod1.addStudent(s2);
        mod2.addStudent(s1);
        mod2.addStudent(s3);

        printCourseDetails(ECE);

    }

    public static void printCourseDetails(CourseProgramme c){
        ArrayList<Student> allStudents = new ArrayList<Student>();
        ArrayList<Module> modules = c.getModList();

        for (Module m: modules){
            ArrayList<Student> students =  m.getStudentList();
            for (Student s: students){
                if (allStudents.contains(s)){

                }
                else {
                    allStudents.add(s);
                }
            }
        }

        String toPrint = "";

        for (Student s: allStudents){
            toPrint += ("Student " + s.getsID() + "is registered for: ");
            for (Module m: modules){
                if (m.getStudentList().contains(s)){
                    toPrint += (m.getModName() + ", ");
                }
            }
            toPrint += "in module "+c.getCourseName()+".\r\n";
        }

        System.out.println(toPrint);
    }

}
