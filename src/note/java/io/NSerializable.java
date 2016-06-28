package note.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化对象Demo
 *
 */
public class NSerializable {
	static String path = "D:/demotest/SerializableObj.txt";

	public static void main(String[] args) {
		File serFile = new File(path);
		if (serFile.exists()) {
			serFile.delete();
		}

		ser();
		dser();
	}

	/**
	 * 序列化
	 */
	public static void ser() {
		Person p = new Person("张三", 18);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);

			// 这里可以写入对象，也可以是其他类型数据
			oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 反序列化
	 */
	public static void dser() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);

			// 这里返回一个Object类对象
			Person p = (Person) ois.readObject();
			System.out.println(p);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8214582878464276031L;
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}