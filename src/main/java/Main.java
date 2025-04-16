/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Nazwisko, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("1.dodaj");
        System.out.println("2.wypisz wszystkich studentów");
        System.out.println("3.wyjście");
        String wybor = scanner.nextLine();

        switch (wybor) {
          case "1":
            System.out.print("imię: ");
            String imie = scanner.nextLine();
            if (imie.isEmpty()) {
              System.out.println("musi byc imie");
              break;
            }

            System.out.print("nazwisko: ");
            String nazwisko = scanner.nextLine();
            if (nazwisko.isEmpty()) {
              System.out.println("musi byc nazwisko");
              break;
            }

            System.out.print("wiek: ");
            int wiek;
            try {
              wiek = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
              System.out.println("musi byc liczba");
              break;
            }

            Student student = new Student(imie, nazwisko, wiek);
            s.addStudent(student);
            System.out.println("dodano studenta: " + student.ToString());
            break;

          case "2":
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("pusto");
            } else {
              System.out.println("\nlista studentów:");
              for (Student current : students) {
                System.out.println(current.ToString());
              }
            }
            break;

          case "3":
            System.out.println("koniec");
            return;

          default:
            System.out.println("błąd");
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
