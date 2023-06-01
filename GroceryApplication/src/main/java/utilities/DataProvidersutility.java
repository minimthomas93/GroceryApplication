package utilities;



import java.io.IOException;

import org.testng.annotations.DataProvider;




public class DataProvidersutility {

	//DataProvider 1
	
	@DataProvider(name="LoginDetailsforloginWithInvalidCredentials")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\LoginDetailsforloginWithInvalidCredentials.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String Adduserdata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcols;j++)  
			{
				Adduserdata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  
			}
		}
	return Adduserdata;
				
	}
	
	
}
