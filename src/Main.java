import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeDataToFile(String path, List<Student> students){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1, "Phong", "Ha Noi"));
        writeDataToFile("D:\\CodeGym\\Module2\\write-bin-file\\src\\students.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("D:\\CodeGym\\Module2\\write-bin-file\\src\\students.txt");
        for(Student student:studentDataFromFile){
            System.out.println(student);
        }
    }
}