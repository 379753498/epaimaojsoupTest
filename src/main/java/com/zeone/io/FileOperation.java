package com.zeone.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import com.zeone.lifeline.collector.util.DateUtil;

/**
 * 文件写入操作
 */
public class FileOperation {

	private static String PATH;
	static String date;

	/**
	 * 根据路径创建文件
	 * 
	 * @param fileName
	 * 
	 * 
	 * 
	 * @return
	 */

	public FileOperation() {
		date = DateUtil.format(new Date(), "yyyy-MM-dd");
		PATH = "c://bridge_equipment//" + date + "//";// 根路径

	}

	public static File createFile(String fileName) {
		File file = new File(fileName);
		try {
			if (!file.getParentFile().exists()) {
				if (!file.getParentFile().mkdirs()) {
					System.out.println(file.getParentFile() + "创建目录失败！");
					return null;
				}
			}

			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			System.out.println("创建目录失败，目标目录已存在！");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			System.out.println("创建目录成功！" + destDirName);
			return true;
		} else {
			System.out.println("创建目录失败！");
			return false;
		}
	}
	
	
	/**
	 * 将内容写入文件
	 * 
	 * @param content
	 * @return
	 */

	public static boolean writeTxFile(String content, String filename) {



		date = DateUtil.format(new Date(), "yyyy-MM-dd");
		PATH = "C://bridge_equipment//" + date +"易拍网商品数据汇总"+ "//";// 根路径
		File file = createFile(PATH + filename + ".txt");

		if (file == null) {
			System.out.println("写入失败");
			return false;
		}
		
		try {
			FileUtils.write(file, content, "utf-8", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
}
