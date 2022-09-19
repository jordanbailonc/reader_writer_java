
package cat.proven.employeefilepersist;

import cat.proven.employeefilepersist.model.Employee;
import cat.proven.employeefilepersist.model.Staff;
import cat.proven.employeefilepersist.model.persist.EmployeeBinFilePersist;
import cat.proven.employeefilepersist.model.persist.PersistInterface;
import java.util.List;

/**
 *
 * @author ProvenSoft
 */
public class WriteBin {

    public static void main(String[] args) {
        String filename = "mystaff.txt"; //TODO read this from arguments
        Staff model = new Staff();
        List<Employee> data = model.generateTestData();
        //TODO treat all errors.
        PersistInterface persister = new EmployeeBinFilePersist();
        int written = persister.writeList(filename, data);
        if(written>=0){
            System.out.println("File loaded correctly.");
        }else if(written==-1){
            System.out.println("File not found on the directory.");
        }else if(written==-2){
            System.out.println("Error during the input/output on the file.");
        }
        System.out.format("%d employees written\n", written);
    }
    
}
