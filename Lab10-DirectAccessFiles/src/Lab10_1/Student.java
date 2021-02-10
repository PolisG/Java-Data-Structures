package Lab10_1;

/**
 *
 * @author Polis
 */
public class Student {
    private int AM;
    private String name;
    private String surname;
    private double age;
    private char sex;
    private int ar_apousiwn;
    private double vathmos;

    public Student() {}

    public Student(int AM, String name, String surname) {
        this.AM = AM;
        this.name = name;
        this.surname = surname;
    }

    public Student(int AM, String name, String surname, double age, char sex, int ar_apousiwn, double vathmos) {
        this.AM = AM;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.ar_apousiwn = ar_apousiwn;
        this.vathmos = vathmos;
    }

    public int getAM() {
        return AM;
    }

    public void setAM(int AM) {
        this.AM = AM;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getAr_apousiwn() {
        return ar_apousiwn;
    }

    public void setAr_apousiwn(int ar_apousiwn) {
        this.ar_apousiwn = ar_apousiwn;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getVathmos() {
        return vathmos;
    }

    public void setVathmos(double vathmos) {
        this.vathmos = vathmos;
    }

    @Override
    public String toString() {
        return "Student{" + "AM=" + AM + ", name=" + name + ", surname=" + surname + ", age=" + age + ", sex=" + sex + ", arithmos apousiwn=" + ar_apousiwn + ", vathmos=" + vathmos + '}';
    }   
}