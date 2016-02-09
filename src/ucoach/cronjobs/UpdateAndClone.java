package ucoach.cronjobs;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

import org.json.JSONArray;

import ucoach.business.client.GoalClient;
import ucoach.util.DatePatterns;

public class UpdateAndClone {
	
	public static void main(String args[]) throws Exception{
		

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("CET"));
		
		//Local time zone   
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		
		Date g = dateFormatLocal.parse( dateFormatGmt.format(new Date()) );
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
		
		System.out.println(dateFormat.format(g));
		
		System.out.println("Cron Job has being called");
		ArrayList<String> users = new ArrayList<String>();
		GoalClient goalsClient = new GoalClient();
		
		//users.add("59d4acc18ccb00a4f89e39079850525a61e742f871273e59fe3239014e404eb8");
		
		for(String userToken : users){
			//Take the goals for each user from Yesterday
			JSONArray goals = goalsClient.checkGoals(userToken, DatePatterns.getYesterdayDate());			
		}
		//Thread.sleep(10000); 
		for(String userToken : users){
			//Take the goals for each user from Yesterday
			JSONArray goals = goalsClient.cloneGoals(userToken);
		}
		
	}
	
	
}
