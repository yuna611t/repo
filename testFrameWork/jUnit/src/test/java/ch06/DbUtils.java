package ch06;

import java.net.URL;
import java.sql.SQLException;

/**
 * データベースを操作するユーティリティクラスのダミー
 */
public class DbUtils {

	/**
	 * テーブル名を指定してデータベースからDROPする。
	 * @param tableName DROPするテーブルの名前
	 * @throws SQLException
	 */
	public static void drop(String tableName) throws SQLException {
		// TODO
	}

	/**
	 * テーブルとデータを示すリソースをURLを指定して、テーブルにINSERTする。
	 * @param tableName テーブル名
	 * @param resources データソース
	 * @throws SQLException
	 */
	public static void insert(String tableName, URL resources) throws SQLException {
		// TODO
	}
}
