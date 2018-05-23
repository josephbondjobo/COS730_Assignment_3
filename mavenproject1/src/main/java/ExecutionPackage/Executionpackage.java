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
import java.util.Random;
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
           
                
//        test experiments        
        JSONObject experiment = new JSONObject();
        JSONObject experiment1 = new JSONObject();
        Random r = new Random();
        JSONArray algo = new JSONArray();
        algo.put(1);
        algo.put(2);

        
        JSONArray data = new JSONArray();
        data.put(1);
        data.put(2);

        
        JSONArray meas = new JSONArray();
        meas.put("cpuUsage");
        meas.put("ramUsage");
        meas.put("heatGenerated");
        
        experiment.put("ID", r.nextInt(1000000));
        experiment.put("Name", "k");
        experiment.put("UserId", 1);
        experiment.put("NumberOfIterations", 5);
        experiment.put("Timeout", 3);
        experiment.put("AlgorithmId", algo);
        experiment.put("DatasetId", data);
        experiment.put("Measurements", meas);
        
        experiment1.put("ID", r.nextInt(1000000));
        experiment1.put("Name", "k");
        experiment1.put("UserId", 2);
        experiment1.put("NumberOfIterations", 5);
        experiment1.put("Timeout", 3);
        experiment1.put("AlgorithmId", algo);
        experiment1.put("DatasetId", data);
        experiment1.put("Measurements", meas);
//        System.out.println(experiment);
        //Algorithms
        JSONObject algorithms = new JSONObject();
        algorithms.put("ID", 1);
        algorithms.put("UserId", 1);
        algorithms.put("Name", "K");
        algorithms.put("Language", "Java");
        algorithms.put("FilePath", "asdf");
        algorithms.put("CompileCommand", "compile");
        algorithms.put("RunCommand", "run");
           
        JSONObject algorithms1 = new JSONObject();
    //
        algorithms1.put("ID", 2);
        algorithms1.put("UserId", 2);
        algorithms1.put("Name", "Kudzai");
        algorithms1.put("Language", "C");
        algorithms1.put("FilePath", "asdf");
        algorithms1.put("CompileCommand", "compile");
        algorithms1.put("RunCommand", "run");
        ////dataset
        JSONObject Dataset = new JSONObject();
        
        Dataset.put("ID", 1);
        Dataset.put("UserId", 1);
        Dataset.put("Name", "Kudzai");
        Dataset.put("FilePath", "Kudzai");
        
                JSONObject Dataset1 = new JSONObject();
    
        Dataset1.put("ID", 2);
        Dataset1.put("UserId", 2);
        Dataset1.put("Name", "Kudzai");
        Dataset1.put("FilePath", "Kudzai");
        
        //Measurements
//        JSONObject Measurement = new JSONObject();
//        
//        Measurement.put("ID", 1);
//        Measurement.put("ExperimentId", 1);
//        Measurement.put("Name", "Kudzai");
//        Measurement.put("CpuTime", 0.0);
//        Measurement.put("CpuUsage", 0.0);
//        Measurement.put("ElapsedTime", 0.0);
//        Measurement.put("EnergyGenerated", 0.0);
//        Measurement.put("HeatGenerated", 0.0);
//        Measurement.put("MemoryUsage", 0.0);
//        
//        JSONObject Measurement1 = new JSONObject();
//    
//        Measurement1.put("ID", 1);
//        Measurement1.put("ExperimentId", 2);
//        Measurement1.put("Name", "Kudzai");
//        Measurement1.put("CpuTime", 0.0);
//        Measurement1.put("CpuUsage", 0.0);
//        Measurement1.put("ElapsedTime", 0.0);
//        Measurement1.put("EnergyGenerated", 0.0);
//        Measurement1.put("HeatGenerated", 0.0);
//        Measurement1.put("MemoryUsage", 0.0);
        
        JSONArray array = new JSONArray();
        
        JSONArray array1 = new JSONArray();
        JSONArray array2 = new JSONArray();
        JSONArray array3 = new JSONArray();
        
//        JSONObject item = new JSONObject();
//        item.put("ID", 2);
//        item.put("Name", "g");
//        item.put("User", "course1");
        array.put(experiment1);
        array.put(experiment);
        
        array1.put(Dataset);
        array1.put(Dataset1);
        
        array2.put(algorithms);
        array2.put(algorithms1);
        
//        array3.put(Measurement);
//        array3.put(Measurement1);

        //add datasets to datasetsList
        for(int i = 0; i< array1.length(); i++)
        {
            JSONObject j = (JSONObject) array1.get(i);
            
            
            Datasets e = new Datasets();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setFilePath(j.getString("FilePath"));
            e.setUserId(j.getInt("UserId"));
            
            datasetList.add(e);
        }
       
        //add algorithms to algorithmsList
       for(int i = 0; i< array2.length(); i++)
        {
            JSONObject j = (JSONObject) array2.get(i);
            
            
            Algorithms e = new Algorithms();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setFilePath(j.getString("FilePath"));
            e.setLanguage(j.getString("Language"));
            e.setCompileCommand(j.getString("CompileCommand"));
            e.setRunCommand(j.getString("RunCommand"));
            e.setUserId(j.getInt("UserId"));
            
            algorithmList.add(e);
        }
        //add measurement to measurementsList
//       for(int i = 0; i< array3.length(); i++)
//        {
//            JSONObject j = (JSONObject) array3.get(i);
//            
//            
//            Measurements e = new Measurements();
//            e.setID(j.getInt("ID"));
//            e.setName(j.getString("Name"));
//            e.setCpuTime(j.getInt("CpuTime"));
//            e.setExperimentId(j.getInt("ExperimentId"));
//            e.setCpuUsage(j.getInt("CpuUsage"));
//            e.setElapsedTime(j.getInt("ElapsedTime"));
//            e.setEnergyGenerated(j.getInt("ElapsedTime"));
//            e.setHeatGenerated(j.getInt("HeatGenerated"));
//            
//            
//            measurementsList.add(e);
//        }
       //add experiments to experimentsList
       for(int i = 0; i< array.length(); i++)
        {
            JSONObject j = (JSONObject) array.get(i);
            
            System.out.println("UserId: "+ j.getInt("UserId"));
            Experiments e = new Experiments();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setUserId(j.getInt("UserId"));
            e.setNumberOfIterations(j.getInt("NumberOfIterations"));
            e.setTimeout(j.getInt("Timeout"));
            
            JSONArray a = j.getJSONArray("AlgorithmId");
            for (int k = 0; k < a.length(); k++) {
                e.getAlgorithmId().add((Integer)a.getInt(k));
            }
            
            JSONArray d = j.getJSONArray("DatasetId");
            for (int k = 0; k < d.length(); k++) {
                e.getDatasetId().add((Integer)d.getInt(k));
            }
            
            JSONArray m = j.getJSONArray("Measurements");
            for (int k = 0; k < m.length(); k++) {
                e.getMeasurements().add(m.getString(k));
            }
            
            experimentList.add(e);
        }
       //
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

                if(experimentList.get(i).getUserId()== datasetList.get(j).getUserId())
                {
                    
                    t.getDataset().add(datasetList.get(j));
                }
            }
            
            for(int j = 0; j<algorithmList.size(); j++)
            {
                if(experimentList.get(i).getUserId() == algorithmList.get(j).getUserId())
                {
                    
                    t.getAlgorithm().add(algorithmList.get(j));
                }
            }
//            for(int j = 0; j<measurementsList.size(); j++)
//            {
////                System.out.println(measurementsList.size());
//                
//                if(experimentList.get(i).getID() == measurementsList.get(j).getExperimentId())
//                {
//                    t.getMeasurement().add(measurementsList.get(j));
//                }
//            }
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
                int runs = t.get(i).getExperiment().getNumberOfIterations();
                for(; runs>0; runs--)
                {
                    String jsonInString = mapper.writeValueAsString(t.get(i));
                    taskServiceBus.add(jsonInString);
                }
            }
        }
        Collections.shuffle(taskServiceBus);
        System.out.println("Task Service bus size: "+taskServiceBus.size());
        setStatus("ready");
        startTime = Calendar.getInstance();
        System.out.println("here: "+ taskServiceBus.getFirst());
        result = taskServiceBus.pop();
        resultsServiceBus.add(result);

        JSONObject j = new JSONObject(result);
        JSONObject t = (JSONObject) j.get("experiment");
        System.out.println("creating");
        createExperimentInDB(t.getInt("id"));
        System.out.println("created");
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
    String url = "jdbc:sqlserver://execution-db:1432;databaseName=ExecutionResults";
    //String url = "jdbc:sqlserver://206.189.16.193:1432;databaseName=ExecutionResults";
    String user = "sa";
    String pass = "Long_Secret";
    
    
    /* API call that the node team should call to send the result back to us
    once we receive it, store it in the database and call report team's API 
    to give them the result*/
    @Path("postResult")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void postResult(String result)
    {

        try 
        {
            
            uploadResultToDB(result);
            
            setStatus("Succeed");
            
        }   
        catch (Exception e) 
        {
            System.out.println("catch " + e.getMessage());   
  
        }
        
        
    }

    void uploadResultToDB(String result)
    {
        JSONObject resultJSON = new JSONObject(result);
        JSONArray resultArray = resultJSON.getJSONArray("result");
        System.out.println(resultJSON);
        System.out.println(resultArray.getJSONObject(0).getJSONArray("result"));
        
        try
        {
            Class.forName(driver);

            
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE tblResult SET result='" + resultArray.getJSONObject(0).toString() + "' WHERE taskID=" + resultArray.getJSONObject(0).get("taskID");
            
            System.out.println(sql);
            PreparedStatement pst = con.prepareStatement(sql);
        
            //pst.setInt(2, (int)resultArray.getJSONObject(0).get("taskID"));
            //pst.setString(1, resultArray.getJSONObject(0).toString());

            pst.executeUpdate();
            System.out.println("record updated");
            
            /* Send the result to the report team */
            //sendResult(result); //Should change to report's API call
        }
        catch(Exception e)
        {
            System.out.println("catch" + e.getMessage());
        }

    }

    void createExperimentInDB(int id)
    {

        try
        {
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO tblResult"
                + "(taskID)"
                + "VALUES (?)";

            PreparedStatement pst = con.prepareStatement(sql);
        
            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("record created");
        }
        catch(Exception e)
        {
            System.out.println("catch" + e.getMessage());
        }
    }
    
} 
