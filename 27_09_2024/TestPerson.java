// TestPerson.java
public class TestPerson {
    public static void main(String[] args) {
        // Testar a classe Student
        Student student = new Student("Carlos", "Rua A, 123", "Engenharia", 2023, 15000.50);
        System.out.println(student);  // Esperado: Student[Person[name=Carlos,address=Rua A, 123],program=Engenharia,year=2023,fee=15000.50]
        student.setFee(16000);
        System.out.println("Nova taxa: " + student.getFee());  // Esperado: 16000.0

        // Testar a classe Staff
        Staff staff = new Staff("Mariana", "Rua B, 456", "IFSP", 5000.75);
        System.out.println(staff);  // Esperado: Staff[Person[name=Mariana,address=Rua B, 456],school=IFSP,pay=5000.75]
        staff.setPay(5500);
        System.out.println("Novo pagamento: " + staff.getPay());  // Esperado: 5500.0
    }
}
