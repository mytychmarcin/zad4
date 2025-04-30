import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Service {
  private static final String FILE_PATH = "db.txt";

  public void addStudent(Student student) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
      writer.write(
          student.getImie() + "," + student.getNazwisko() + "," + student.getWiek() + "," + student.getDataUrodzenia());
      writer.newLine();
    }
  }

  public List<Student> getStudents() throws IOException {
    List<Student> students = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
          String imie = parts[0];
          String nazwisko = parts[1];
          int wiek = Integer.parseInt(parts[2]);
          String dataUrodzenia = parts[3];
          students.add(new Student(imie, nazwisko, wiek, dataUrodzenia));
        }
      }
    }
    return students;
  }

  public List<Student> getStudentsByName(String name) throws IOException {
    List<Student> foundStudents = new ArrayList<>();
    List<Student> students = getStudents();

    for (Student student : students) {
      if (student.getImie().equalsIgnoreCase(name)) {
        foundStudents.add(student);
      }
    }

    return foundStudents;
  }

  public boolean removeStudent(String imie, String nazwisko) throws IOException {
    List<Student> students = getStudents();
    List<Student> studentsToKeep = new ArrayList<>();

    boolean studentFound = false;

    for (Student student : students) {
      if (student.getImie().equalsIgnoreCase(imie) && student.getNazwisko().equalsIgnoreCase(nazwisko)) {
        studentFound = true;
      } else {
        studentsToKeep.add(student);
      }
    }

    if (studentFound) {

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
        for (Student student : studentsToKeep) {
          writer.write(student.getImie() + "," + student.getNazwisko() + "," + student.getWiek() + ","
              + student.getDataUrodzenia());
          writer.newLine();
        }
      }
    }

    return studentFound;
  }
}
