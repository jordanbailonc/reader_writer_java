package cat.proven.employeefilepersist.model.persist;

import cat.proven.employeefilepersist.model.Employee;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * File persistence implementationn for lists of employees in binary format
 *
 * @author Jordan Bailon
 */
public class EmployeeBinFilePersist implements PersistInterface {

    /**
     * writes a list of employees to a file in binary format
     */
    @Override
    public int writeList(String filename, List<Employee> data) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            for (Employee emp : data) {
                dos.writeUTF(emp.getPhone());
                dos.flush();
                dos.writeUTF(emp.getName());
                dos.flush();
                dos.writeInt(emp.getAge());
                dos.flush();
                dos.writeBoolean(emp.isSenior());
                dos.flush();
                dos.writeDouble(emp.getSalary());
                dos.flush();
            }
            dos.close();
        } catch (FileNotFoundException ex) {
            return -1;
        } catch (IOException e) {
            return -2;
        }
        return data.size();

    }

    /**
     * reads a list of employees from a file in binary format
     */
    @Override
    public List<Employee> readList (String filename) {
        List<Employee> result = new ArrayList<>();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            while (dis.available() > 0) {
                String phone = dis.readUTF();
                String name = dis.readUTF();
                int age = dis.readInt();
                Boolean senior = dis.readBoolean();
                Double salary = dis.readDouble();
                Employee emp_aux = new Employee(phone, name, age, senior, salary);
                result.add(emp_aux);
            }
        } catch (FileNotFoundException e) {
            result = null;
        } catch (IOException ex) {
            System.out.println(ex.toString());
            result = null;
        } catch (NullPointerException e) {
            System.out.println("Error--------NULL OBJ");
            result = null;
        }
        return result;
    }
}
