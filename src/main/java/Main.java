/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.print("imie: ");
        String imie = scanner.nextLine();
        if (imie.isEmpty())
          break;

        System.out.print("wiek: ");
        int wiek = Integer.parseInt(scanner.nextLine());

        Student student = new Student(imie, wiek);
        s.addStudent(student);
        System.out.println("dodano studenta: " + student.ToString());
      }

      var students = s.getStudents();
      System.out.println("\nLista wszystkich studentów:");
      for (Student current : students) {
        System.out.println(current.ToString());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
