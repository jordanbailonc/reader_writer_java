package cat.proven.employeefilepersist;

import cat.proven.employeefilepersist.model.Employee;
import cat.proven.employeefilepersist.model.Staff;
import cat.proven.employeefilepersist.model.persist.EmployeeCsvFilePersist;
import cat.proven.employeefilepersist.model.persist.PersistInterface;
import java.util.List;

/**
 *
 * @author ProvenSoft
 */
public class WriteCsv {
    public static void main(String[] args) {
        String filename = "mystaff.txt"; //TODO read this from arguments
        String delimiter = ":";
        Staff model = new Staff();
        List<Employee> data = model.generateTestData();
        //TODO treat all errors.
        PersistInterface persister = new EmployeeCsvFilePersist();
        ((EmployeeCsvFilePersist) persister).setDelimiter(delimiter);
        int written = persister.writeList(filename, data);
        System.out.format("%d employees written\n", written);
    }
    
}
