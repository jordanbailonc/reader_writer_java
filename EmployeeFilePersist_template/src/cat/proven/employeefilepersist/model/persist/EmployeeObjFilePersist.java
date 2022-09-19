
package cat.proven.employeefilepersist.model.persist;

import cat.proven.employeefilepersist.model.Employee;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordan Bailon
 */
public class EmployeeObjFilePersist implements PersistInterface {

    @Override
    public int writeList(String filename, List<Employee> data) {
        System.out.println("TODO: writeList: Object"); //TODO
        return 0;
    }

    @Override
    public List<Employee> readList(String filename) {
        System.out.println("TODO: readList: Object"); //TODO
        return null;
    }

    
}
