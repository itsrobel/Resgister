package API.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table
public class MClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID teacherId;
    private String teacherName;
    public String className;
    private ArrayList<UUID> studentList = new ArrayList<UUID>();

    public UUID getId()  { return  id;}
    public void setId(UUID id) {this.id = id;}

    public UUID getTeacherId() {return teacherId;}
    public void setTeacherId(UUID teacherId) {this.teacherId = teacherId;}

    public String getTeacherName() {return teacherName;}
    public void setTeacherName(String teacherName) {this.teacherName =teacherName;}

    public String getClassName() {return className;}
    public void  setClassName(String className) {this.className = className;}

    public int getStudentIndex(UUID studentID) {
        for ( int num = 0; num < studentList.size() ; num++ ) {
            if (studentList.get(num) == studentID ) {
                return num;
            }
        }
        return -1;
    }
    public  void addStudent(UUID studentID) {
        studentList.add(studentID);
    }
    public void removeStudent(UUID studentID) {
        int index = getStudentIndex(studentID);
        if (index > -1) {
            studentList.remove(index);
        }
    }
    public void changeStudent(UUID oldStudentID , UUID newStudentID) {
        int index = getStudentIndex(oldStudentID);
        if (index > -1) {
            studentList.set(index, newStudentID);
        }
    }
    public static boolean choicefields(MClass mclass){
        if (mclass.getTeacherId() == null|| mclass.getClassName().isBlank()|| mclass.getTeacherName().isBlank() ) {
            return false;
        }
        return true;
    }

}