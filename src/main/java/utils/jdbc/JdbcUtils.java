package utils.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * jdbc工具类
 * 
 * @author http://blog.csdn.net/yanzi1225627/article/details/26950615
 * 
 */
public class JdbcUtils {
	// 必要的配置字段
	private static String jdbc_driverClassName = null;
	private static String jdbc_url = null;
	private static String jdbc_username = null;
	private static String jdbc_password = null;

	/**
	 * 私有构造
	 */
	private JdbcUtils() {
	}

	/**
	 * 加载数据库驱动和配置
	 */
	static {
		InputStream fis = null;
		try {
			// 以/开头表示基于classpath
			fis = JdbcUtils.class.getResourceAsStream("jdbc.properties"); // 加载数据库配置文件到内存中
			Properties p = new Properties();
			p.load(fis);
			jdbc_driverClassName = p.getProperty("jdbc.driverClassName");// 获取数据库配置文件
			jdbc_url = p.getProperty("jdbc.url");
			jdbc_username = p.getProperty("jdbc.username");
			jdbc_password = p.getProperty("jdbc.password");

			Class.forName(jdbc_driverClassName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("加载驱动失败！");
		} catch (IOException e) {
			throw new RuntimeException("读取数据库配置文件失败！");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 创建数据库连接
	 * 
	 * @return
	 */
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
	}

	/**
	 * 释放数据库连接
	 */
	private static void closeAll(Connection con, PreparedStatement pst, ResultSet rst) {
		if (rst != null) {
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 增加、删除、改
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static boolean updateByPreparedStatement(String sql, List<Object> params) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		int result = -1;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			int index = 1;
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			result = pstmt.executeUpdate();
			flag = result > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, pstmt, null);
		}
		return flag;
	}

	/**
	 * 查询单条记录
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static Map<String, Object> findSimpleResult(String sql, List<Object> params) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Map<String, Object> map = new HashMap<String, Object>();
		int index = 1;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			resultSet = pstmt.executeQuery();// 返回查询结果
			ResultSetMetaData metaData = resultSet.getMetaData();
			int col_len = metaData.getColumnCount();
			while (resultSet.next()) {
				for (int i = 0; i < col_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Object cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					map.put(cols_name, cols_value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, pstmt, resultSet);
		}
		return map;
	}

	/**
	 * 查询多条记录
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> findModeResult(String sql, List<Object> params) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			resultSet = pstmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (resultSet.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Object cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					map.put(cols_name, cols_value);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, pstmt, resultSet);
		}
		return list;
	}

	/**
	 * 通过反射机制查询单条记录
	 * 
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static <T> T findSimpleRefResult(String sql, List<Object> params, Class<T> cls) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		T resultObject = null;
		int index = 1;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			resultSet = pstmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (resultSet.next()) {
				// 通过反射机制创建一个实例
				resultObject = cls.newInstance();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Object cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					Field field = cls.getDeclaredField(cols_name);
					field.setAccessible(true); // 打开javabean的访问权限
					field.set(resultObject, cols_value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, pstmt, resultSet);
		}
		return resultObject;

	}

	/**
	 * 通过反射机制查询多条记录
	 * 
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> findMoreRefResult(String sql, List<Object> params, Class<T> cls) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		List<T> list = new ArrayList<T>();
		int index = 1;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			resultSet = pstmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (resultSet.next()) {
				// 通过反射机制创建一个实例
				T resultObject = cls.newInstance();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Object cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					Field field = cls.getDeclaredField(cols_name);
					field.setAccessible(true); // 打开javabean的访问权限
					field.set(resultObject, cols_value);
				}
				list.add(resultObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, pstmt, resultSet);
		}
		return list;
	}

}
