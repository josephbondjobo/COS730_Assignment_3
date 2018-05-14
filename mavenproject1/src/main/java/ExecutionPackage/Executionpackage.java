/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutionPackage;

import java.util.Timer;
import Entities.Algorithms;
import Entities.Datasets;
import Entities.Experiments;
import Entities.Measurements;
import Entities.Task;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
//import net.sf.json.JSONObject;


/**
 * REST Web Service
 *
 * @author i
 */
@Path("executionPackage")
public class Executionpackage {
    ArrayList<Experiments> experimentList = new ArrayList<>();
    ArrayList<Datasets> datasetList = new ArrayList<>();
    ArrayList<Algorithms> algorithmList = new ArrayList<>();
    ArrayList<Measurements> measurementsList = new ArrayList<>();
    ArrayList<Task> taskList = new ArrayList<>();
    public static int gloounter = 0;
    static LinkedList<String> taskServiceBus = new LinkedList<>();
    static LinkedList<String> resultsServiceBus = new LinkedList<>();
    static String status = "";
    Calendar startTime = Calendar.getInstance();
        

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of executionpakcage
     */
    public Executionpackage() {
    }

    /**
     * Retrieves representation of an instance of ExecutionPackage.Executionpackage
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Executionpackage
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    public void setStatus(String str){
        this.status = str;
    }
    
    public ArrayList<Task> getExperiment() throws JSONException, MalformedURLException, IOException
    {
        //get experiments from Repository
//        String url = "http://cos.mjshika.xyz/api/repo/Experiment/GetExperiment";
//		
//	URL obj = new URL(url);
//	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//	// optional default is GET
//	con.setRequestMethod("GET");
//
//	//add request header
//	con.setRequestProperty("User-Agent", USER_AGENT);
//
//	int responseCode = con.getResponseCode();
//	
//        BufferedReader in = new BufferedReader(
//	new InputStreamReader(con.getInputStream()));
//	String inputLine;
//	StringBuffer response = new StringBuffer();
//
//	while ((inputLine = in.readLine()) != null) {
//		response.append(inputLine);
//	}
//	in.close();
//        
//        //check if call was successful
////        if("0".equals(response.toString()))
////        {
////            return null;
////        }
//
//	// experiments array from call
//        JSONArray arrayExperiments = new JSONArray();
//        arrayExperiments.put(response.toString());
//        
//        JSONArray arrayDataset = new JSONArray();
//        
//                //get Dataset from Repository
//        for(int i = 0; i < arrayExperiments.length(); i++)
//        {
//            JSONObject j = new JSONObject((String) arrayExperiments.get(i));
//           // JSONObject j = (JSONObject) arrayExperiments.get(i);
//                    //get Dataset from Repository
//            String url2 = "http://cos.mjshika.xyz/api/repo/Dataset/AddDataSet/?name=newName&datapath=newPath&id=expID\n"+j.getInt("ID");
//
//            URL obj2 = new URL(url2);
//            HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
//
//            // optional default is GET
//            con2.setRequestMethod("GET");
//
//            //add request header
//            con2.setRequestProperty("User-Agent", USER_AGENT);
//
//            int responseCode2 = con2.getResponseCode();
//
//            BufferedReader in2 = new BufferedReader(
//            new InputStreamReader(con2.getInputStream()));
//            String inputLine2;
//            StringBuffer response2 = new StringBuffer();
//
//            while ((inputLine2 = in2.readLine()) != null) {
//                    response2.append(inputLine2);
//            }
//            in2.close();
//            
//            arrayDataset.put(response2.toString());
//        }        
//        
//        
//	// Algorithm array from call
//        JSONArray arrayAlgorithm = new JSONArray();
//        
//        for(int i = 0; i < arrayExperiments.length(); i++)
//        {
//            JSONObject j = new JSONObject((String) arrayExperiments.get(i));
//            //JSONObject j = (JSONObject) arrayExperiments.get(i);
//                    //get Algorithm from Repository
//            String url2 = "http://cos.mjshika.xyz/api/repo/Dataset/AddDataSet/?name=newName&datapath=newPath&id=" +j.getInt("ID");
//
//            URL obj2 = new URL(url2);
//            HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
//
//            // optional default is GET
//            con2.setRequestMethod("GET");
//
//            //add request header
//            con2.setRequestProperty("User-Agent", USER_AGENT);
//
//            int responseCode2 = con2.getResponseCode();
//
//            BufferedReader in2 = new BufferedReader(
//            new InputStreamReader(con2.getInputStream()));
//            String inputLine2;
//            StringBuffer response2 = new StringBuffer();
//
//            while ((inputLine2 = in2.readLine()) != null) {
//                    response2.append(inputLine2);
//            }
//            in2.close();
//            
//            arrayAlgorithm.put(response2.toString()); 
//        }
        
        // measurement array from call
//        JSONArray arrayMeasurement = new JSONArray();
//        
//        for(int i = 0; i < arrayExperiments.length(); i++)
//        {
//            JSONObject j = new JSONObject((String) arrayExperiments.get(i));
//            //JSONObject j = (JSONObject) arrayExperiments.get(i);
//                    //get Algorithm from Repository
//            String url2 = "http://cos.mjshika.xyz/api/repo/Measurement/GetMeasurements/?id=" + +j.getInt("ID");
//
//            URL obj2 = new URL(url2);
//            HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
//
//            // optional default is GET
//            con2.setRequestMethod("GET");
//
//            //add request header
//            con2.setRequestProperty("User-Agent", USER_AGENT);
//
//            int responseCode2 = con2.getResponseCode();
//
//            BufferedReader in2 = new BufferedReader(
//            new InputStreamReader(con2.getInputStream()));
//            String inputLine2;
//            StringBuffer response2 = new StringBuffer();
//
//            while ((inputLine2 = in2.readLine()) != null) {
//                    response2.append(inputLine2);
//            }
//            in2.close();
//            
//            arrayMeasurement.put(response2.toString()); 
//        }
               
                
        //test experiments        
        JSONObject experiment = new JSONObject();
        experiment.put("ID", 1);
        experiment.put("Name", "k");
        experiment.put("User", "Kudzai");
//        System.out.println(experiment);
        //Algorithms
        JSONObject algorithms = new JSONObject();
        algorithms.put("ID", 1);
        algorithms.put("ExperimentId", 1);
        algorithms.put("Name", "Kudzai");
        algorithms.put("Path", "Kudzai");
           
        JSONObject algorithms1 = new JSONObject();
    //
        algorithms1.put("ID", 2);
        algorithms1.put("ExperimentId", 2);
        algorithms1.put("Name", "Kudzai");
        algorithms1.put("Path", "Kudzai");
        ////dataset
        JSONObject Dataset = new JSONObject();
        
        Dataset.put("ID", 1);
        Dataset.put("ExperimentId", 1);
        Dataset.put("Name", "Kudzai");
        Dataset.put("Datapath", "Kudzai");
        
                JSONObject Dataset1 = new JSONObject();
    
        Dataset1.put("ID", 2);
        Dataset1.put("ExperimentId", 2);
        Dataset1.put("Name", "Kudzai");
        Dataset1.put("Datapath", "Kudzai");
        
        //Measurements
        JSONObject Measurement = new JSONObject();
        
        Measurement.put("ID", 1);
        Measurement.put("ExperimentId", 1);
        Measurement.put("Name", "Kudzai");
        Measurement.put("CpuTime", 0.0);
        Measurement.put("CpuUsage", 0.0);
        Measurement.put("ElapsedTime", 0.0);
        Measurement.put("EnergyGenerated", 0.0);
        Measurement.put("HeatGenerated", 0.0);
        Measurement.put("MemoryUsage", 0.0);
        
        JSONObject Measurement1 = new JSONObject();
    
        Measurement1.put("ID", 1);
        Measurement1.put("ExperimentId", 2);
        Measurement1.put("Name", "Kudzai");
        Measurement1.put("CpuTime", 0.0);
        Measurement1.put("CpuUsage", 0.0);
        Measurement1.put("ElapsedTime", 0.0);
        Measurement1.put("EnergyGenerated", 0.0);
        Measurement1.put("HeatGenerated", 0.0);
        Measurement1.put("MemoryUsage", 0.0);
        
        JSONArray array = new JSONArray();
        
        JSONArray array1 = new JSONArray();
        JSONArray array2 = new JSONArray();
        JSONArray array3 = new JSONArray();
        
        JSONObject item = new JSONObject();
        item.put("ID", 2);
        item.put("Name", "g");
        item.put("User", "course1");
        array.put(item);
        array.put(experiment);
        
        array1.put(Dataset);
        array1.put(Dataset1);
        
        array2.put(algorithms);
        array2.put(algorithms1);
        
        array3.put(Measurement);
        array3.put(Measurement1);

        //add datasets to datasetsList
        for(int i = 0; i< array1.length(); i++)
        {
            JSONObject j = (JSONObject) array1.get(i);
            
            
            Datasets e = new Datasets();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setDatapath(j.getString("Datapath"));
            e.setExperimentId(j.getInt("ExperimentId"));
            
            datasetList.add(e);
        }
       
        //add algorithms to algorithmsList
       for(int i = 0; i< array2.length(); i++)
        {
            JSONObject j = (JSONObject) array2.get(i);
            
            
            Algorithms e = new Algorithms();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setPath(j.getString("Path"));
            e.setExperimentId(j.getInt("ExperimentId"));
            
            algorithmList.add(e);
        }
        //add measurement to measurementsList
       for(int i = 0; i< array3.length(); i++)
        {
            JSONObject j = (JSONObject) array3.get(i);
            
            
            Measurements e = new Measurements();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setCpuTime(j.getInt("CpuTime"));
            e.setExperimentId(j.getInt("ExperimentId"));
            e.setCpuUsage(j.getInt("CpuUsage"));
            e.setElapsedTime(j.getInt("ElapsedTime"));
            e.setEnergyGenerated(j.getInt("ElapsedTime"));
            e.setHeatGenerated(j.getInt("HeatGenerated"));
            
            
            measurementsList.add(e);
        }
       //add experiments to experimentsList
       for(int i = 0; i< array.length(); i++)
        {
            JSONObject j = (JSONObject) array.get(i);
            
            
            Experiments e = new Experiments();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setUser(j.getString("User"));
            
            experimentList.add(e);
        }
       
       // Randomise the experiment tasks
        Collections.shuffle(experimentList);
       

        //put experiments and associated datasets and algorithms in task objects and add to the tasks list
        for(int i = 0; i<experimentList.size(); i++)
        {
           //System.out.println(algorithmList.size());
            Task t = new Task();
            t.setExperiment(experimentList.get(i));
            for(int j = 0; j<datasetList.size(); j++)
            {
                            //System.out.println(datasetList.get(j).getExperimentId());

                if(experimentList.get(i).getID() == datasetList.get(j).getExperimentId())
                {
                    
                    t.getDataset().add(datasetList.get(j));
                }
            }
            
            for(int j = 0; j<algorithmList.size(); j++)
            {
                if(experimentList.get(i).getID() == algorithmList.get(j).getExperimentId())
                {
                    
                    t.getAlgorithm().add(algorithmList.get(j));
                }
            }
            for(int j = 0; j<measurementsList.size(); j++)
            {
//                System.out.println(measurementsList.size());
                
                if(experimentList.get(i).getID() == measurementsList.get(j).getExperimentId())
                {
                    t.getMeasurement().add(measurementsList.get(j));
                }
            }
            taskList.add(t);
        }
        //JSONArray o = new JSONArray();
        //System.out.println(taskList.size());
        //o.put(taskList);
        
        //System.out.println(o);
        return taskList;
    }
    
    
    @Path("getTask")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  String getTasks() throws JSONException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        String result;
        
        if(taskServiceBus.isEmpty())
        {
            
            ArrayList<Task> t = getExperiment();
            
            //check if task list is null
            if(t == null)
            {
                return "0";
            }
            
            for (int i = 0; i < t.size(); i++) 
            {
                String jsonInString = mapper.writeValueAsString(t.get(i));
                taskServiceBus.add(jsonInString);
            }
        }
        System.out.println("Task Service bus size: "+taskServiceBus.size());
        setStatus("ready");
        startTime = Calendar.getInstance();

        result = taskServiceBus.pop();
        resultsServiceBus.add(result);
        return result;
    }
    
    @Path("getStatus")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatus() {
        long diff = 0;
       
        Calendar endTime = Calendar.getInstance();
        
        if((startTime.get(Calendar.MINUTE) - endTime.get(Calendar.MINUTE)) > 2) {
            setStatus("failed");
        }else{
            setStatus("busy");
        }
    
        return this.status;
    }  
    
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=ExecutionResults";
    String user = "cos730";
    String pass = "cos730";
    
    
    /* API call that the node team should call to send the result back to us
    once we receive it, store it in the database and call report team's API 
    to give them the result*/
    @Path("postResult")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void postResult(String result)
    {
        JSONObject resultJSON = new JSONObject(result);
        JSONArray resultArray = resultJSON.getJSONArray("result");
        System.out.println(resultJSON);
        System.out.println(resultArray.getJSONObject(0).getJSONArray("result"));

        try 
        {
            
            /*Update the task in the DB*/
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO tblResult"
                    + "(taskID, result)"
                    + "VALUES (?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, (int)resultArray.getJSONObject(0).get("taskID"));
            pst.setString(2, resultArray.getJSONObject(0).toString());

            pst.executeUpdate();

            /* Send the result to the report team */
            //getResults(result); //Should change to report's API call
            
            setStatus("Succeed");
            
        }   
        catch (Exception e) 
        {
            System.out.println("catch " + e.getMessage());   
  
        }
        
        
    }
    
} 
