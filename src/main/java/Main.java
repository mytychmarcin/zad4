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
        System.out.println("3.wyszukaj studenta po imieniu");
        System.out.println("4.usun studenta po imieniu i nazwisku");
        System.out.println("5.wyjście");
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

            System.out.print("data urodzenia rok-miesiac-dzien: ");
            String dataUrodzenia = scanner.nextLine();

            if (!dataUrodzenia.matches("\\d{4}-\\d{2}-\\d{2}")) {
              System.out.println("musi byc rok-miesiac-dzien");
              break;
            }

            String[] parts = dataUrodzenia.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            if (year < 1900 || month < 1 || month > 12 || day < 1 || day > 31) {
              System.out.println("niepoprawna data");
              break;
            }

            Student student = new Student(imie, nazwisko, wiek, dataUrodzenia);
            s.addStudent(student);
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
            System.out.print("podaj imie studenta do wyszukania ");
            String szukaneImie = scanner.nextLine();
            var foundStudents = s.getStudentsByName(szukaneImie);
            if (foundStudents.isEmpty()) {
              System.out.println("ni ma  " + szukaneImie);
            } else {
              System.out.println("znaleziono:");
              for (Student current : foundStudents) {
                System.out.println(current.toString());
              }
            }
            break;

          case "4":
            System.out.print("podaj imie studenta ktorego chcesz usunac ");
            String imieDoUsuniecia = scanner.nextLine();

            System.out.print("podaj nazwisko studenta ktorego chcesz usunac: ");
            String nazwiskoDoUsuniecia = scanner.nextLine();

            boolean removed = s.removeStudent(imieDoUsuniecia, nazwiskoDoUsuniecia);
            if (removed) {
              System.out.println("Student " + imieDoUsuniecia + " " + nazwiskoDoUsuniecia + " został usunięty.");
            } else {
              System.out.println("ni ma");
            }
            break;

          case "5":
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
