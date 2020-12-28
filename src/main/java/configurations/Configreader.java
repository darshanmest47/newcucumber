package configurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {

public Properties prop;
public Properties browseProp;
	
	public Properties initialize() {
		
		prop= new Properties();
		try {
			FileInputStream fis = new FileInputStream("E:\\eclipse2\\NewBDD\\src\\main\\java\\configurations\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	public Properties browserInitialize() {
		
		browseProp= new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("E:\\ec5\\newcucu\\src\\main\\java\\configurations\\browser.properties");
			try {
				browseProp.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return browseProp;
		
	}
}
