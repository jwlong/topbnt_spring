package hibernateTest.serialize;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIO4 {
    public void write() throws Exception {
        Student4 s = new Student4();
        s.studentId = 10;
        s.age = 20;
        s.studentName = "名字name";
        s.marks =80;
        FileOutputStream fos = new FileOutputStream("XXXX");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.close();
    }
    public void read() throws Exception {
        FileInputStream fis = new FileInputStream("XXXX");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        Student4.studentName = "王小二";
        if (o instanceof Student4) {
            Student4 s = (Student4) o;
            System.out.println("学生的学号:" + s.studentId);//0
            System.out.println("学生的姓名:" + s.studentName);//王小二
            System.out.println("学生的成绩:" + s.marks);//80
            System.out.println("学生的年龄:" + s.age);//0
        }
        ois.close();
    }
    public static void main(String[] args) {
        try {
            ObjectIO4 oo = new ObjectIO4();
            oo.write();
            oo.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
