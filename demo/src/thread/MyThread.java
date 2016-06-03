package thread;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.FileUtil;

public class MyThread extends Thread {

	public void run(){
		String str="{'a':'a','b':'b','c':'c'}";
		FileUtil.WriteToFileExample("src/util/test.txt",str);
		String retString = FileUtil.readTxtFile("src/util/test.txt");
		try {
			JSONObject jsonObject = new JSONObject(retString);
			Iterator it = jsonObject.keys();  
            while (it.hasNext()) {  
                String key = (String) it.next();  
                String value = jsonObject.getString(key);  
                if(key.equals("c")){
                	System.out.println(key+":"+value);
                }
            }  
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return;
	}
}
