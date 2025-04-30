class Student {
  private String imie;
  private String nazwisko;
  private int wiek;
  private String dataUrodzenia;

  public Student(String imie, String nazwisko, int wiek, String dataUrodzenia) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.wiek = wiek;
    this.dataUrodzenia = dataUrodzenia;
  }

  public String getImie() {
    return imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public int getWiek() {
    return wiek;
  }

  public String getDataUrodzenia() {
    return dataUrodzenia;
  }

  @Override
  public String toString() {
    return imie + " " + nazwisko + " " + wiek + " " + dataUrodzenia;
  }
}
