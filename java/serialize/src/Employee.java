import java.io.*;

/**
 * Serializeした雇用者クラス
 * Employeeクラスをインスタンスを永続保存する
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 8531245739641223373L;

    protected String name;
    protected String dept;

    /**
     * 雇用者の初期設定
     * @param name  雇用者の名前
     * @param dept 所属部署
     */
    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
        System.out.println("Employee instance is created");
    }

    /**
     * Employeeクラスをインスタンス化し、Serialize化したファイルを出力する
     * @param args コマンドライン引数
     */
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("output.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(new Employee("Yamada Taro", "Devplopment"));
        oos.close();
    }


}
