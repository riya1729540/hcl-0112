package day5;
import java.util.*;
import java.util.ArrayList;
public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<day5.Employee> employee = new ArrayList<>();

        // ==========================================
        // 1. CREATE (Add Employees)
        // ==========================================
        employees.add(new Employee(103, "Alice", 50000.0));
        employees.add(new Employee(101, "Bob", 60000.0));
        employees.add(new Employee(105, "Charlie", 55000.0));
        employees.add(new day5.Employee(102, "David", 72000.0));

        System.out.println("=== 1. READ (Initial List using standard Iterator) ===");
        printWithIterator(employees);

        // ==========================================
        // 2. UPDATE (Modify Employee with ID 101)
        // ==========================================
        for (Employee e : employees) {
            if (e.getId() == 101) {
                e.setName("Robert");
                e.setSalary(65000.0);
                break;
            }
        }
        System.out.println("\n=== 2. AFTER UPDATE (ID 101 modified) ===");
        printWithIterator(employees);

        // ==========================================
        // 3. DELETE (Remove Employee with ID 105 using Iterator)
        // ==========================================
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getId() == 105) {
                it.remove(); // Safely removes the element during iteration
                break;
            }
        }
        System.out.println("\n=== 3. AFTER DELETE (ID 105 removed) ===");
        printWithIterator(employees);

        // ==========================================
        // 4. SORTING & ORDERED TRAVERSAL (By Employee ID)
        // ==========================================
        // Sort the list in ascending order by ID
        employees.sort(Comparator.comparingInt(Employee::getId));

        // Ascending Order traversal using ListIterator (Forward)
        System.out.println("\n=== 4. ASCENDING ORDER (ListIterator Forward) ===");
        ListIterator<Employee> listIt = employees.listIterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }

        // Descending Order traversal using ListIterator (Backward)
        System.out.println("\n=== 5. DESCENDING ORDER (ListIterator Backward) ===");
        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }
    }

    // Helper method to read the list using a standard Iterator
    public static void printWithIterator(ArrayList<Employee> list) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}