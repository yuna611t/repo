import java.io.*;

/**
 * Serialize化したEmployeeインスタンスを読み込み、
 * Employeeインスタンスの情報を表示する
 */
public class ReadEmployee {

    /**
     * Serialize化したEmployeeインスタンスを読み込み、
     * Employeeインスタンスの情報を表示する
     * @param args コマンドライン引数
     */
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("output.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee emp = (Employee)(ois.readObject());

        System.out.println(emp.name);
        System.out.println(emp.dept);
    }
}
