import java.sql.*;
import java.util.Scanner;

public class Hospital {
    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_db",
                    "root",
                    "Aadarsh45@"
            );
            System.out.println("Database Connected Successfully!");
            menu();
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }

    static void menu() throws SQLException {
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> updatePatient();
                case 4 -> deletePatient();
                case 5 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addPatient() throws SQLException {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Disease: ");
        String disease = sc.nextLine();

        System.out.print("Doctor: ");
        String doctor = sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO patients(name,age,disease,doctor) VALUES(?,?,?,?)"
        );
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, disease);
        ps.setString(4, doctor);
        ps.executeUpdate();
        System.out.println("Patient Added Successfully!");
    }

    static void viewPatients() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patients");
        System.out.println("\nID | Name | Age | Disease | Doctor");
        System.out.println("------------------------------------");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getInt("age") + " | " +
                            rs.getString("disease") + " | " +
                            rs.getString("doctor")
            );
        }
    }

    static void updatePatient() throws SQLException {
        System.out.print("Enter Patient ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("New Disease: ");
        String disease = sc.nextLine();

        System.out.print("New Doctor: ");
        String doctor = sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE patients SET disease=?, doctor=? WHERE id=?"
        );
        ps.setString(1, disease);
        ps.setString(2, doctor);
        ps.setInt(3, id);
        ps.executeUpdate();
        System.out.println("Patient Updated Successfully!");
    }

    static void deletePatient() throws SQLException {
        System.out.print("Enter Patient ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM patients WHERE id=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Patient Deleted Successfully!");
    }
}