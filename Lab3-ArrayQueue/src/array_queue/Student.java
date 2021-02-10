package array_queue;

/**
 *
 * @author Polis
 */
public class Student {
    private int AM;
    private String name;
    private String epitheto;
    private double age;
    private char sex;
    private int ar_parousiwn;
    private double vathmos;

    public Student() {}

    public Student(int AM, String name, String epitheto, double age, char sex, int ar_parousiwn, double vathmos) {
        this.AM = AM;
        this.name = name;
        this.epitheto = epitheto;
        this.age = age;
        this.sex = sex;
        this.ar_parousiwn = ar_parousiwn;
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

    public int getAr_parousiwn() {
        return ar_parousiwn;
    }

    public void setAr_parousiwn(int ar_parousiwn) {
        this.ar_parousiwn = ar_parousiwn;
    }

    public String getEpitheto() {
        return epitheto;
    }

    public void setEpitheto(String epitheto) {
        this.epitheto = epitheto;
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
        return "Student{" + "AM=" + AM + ", name=" + name + ", epitheto=" + epitheto + ", age=" + age + ", sex=" + sex + ", ar_parousiwn=" + ar_parousiwn + ", vathmos=" + vathmos + '}';
    }
    
}