package cat.proven.employeefilepersist;

import cat.proven.employeefilepersist.model.Employee;
import cat.proven.employeefilepersist.model.persist.EmployeeBinFilePersist;
import cat.proven.employeefilepersist.model.persist.PersistInterface;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author ProvenSoft
 */
public class ReadBin {

    public static void main(String[] args) {
        String filename = "mystaff.txt"; //TODO read this from arguments

        if (args.length == 0) {	 //check parameter length 

            PersistInterface persister = new EmployeeBinFilePersist();
            List<Employee> data = persister.readList(filename);
            for(Employee emp: data){
                System.out.println(emp.toString());
            }
            System.out.println(data.size());
        }else{
            System.out.println("Usage: program + filename");
        }

    }
}
