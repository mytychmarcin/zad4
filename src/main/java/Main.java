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
              System.out.println("musi być imię");
              break;
            }

            System.out.print("nazwisko: ");
            String nazwisko = scanner.nextLine();
            if (nazwisko.isEmpty()) {
              System.out.println("musi być nazwisko");
              break;
            }

            System.out.print("wiek: ");
            int wiek;
            try {
              wiek = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
              System.out.println("musi być liczba");
              break;
            }

            System.out.print("data urodzenia (RRRR-MM-DD): ");
            String dataUrodzenia = scanner.nextLine();

            if (!dataUrodzenia.matches("\\d{4}-\\d{2}-\\d{2}")) {
              System.out.println("Data urodzenia musi być w formacie RRRR-MM-DD");
              break;
            }

            String[] parts = dataUrodzenia.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            if (year < 1900 || month < 1 || month > 12 || day < 1 || day > 31) {
              System.out.println("Niepoprawna wartość daty (rok, miesiąc lub dzień poza zakresem).");
              break;
            }

            // Tworzymy obiekt studenta z datą urodzenia
            Student student = new Student(imie, nazwisko, wiek, dataUrodzenia);
            s.addStudent(student); // Dodajemy studenta do bazy danych
            System.out.println("dodano studenta: " + student.toString());
            break;

          case "2":
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("pusto");
            } else {
              System.out.println("\nlista studentów:");
              for (Student current : students) {
                System.out.println(current.toString());
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
