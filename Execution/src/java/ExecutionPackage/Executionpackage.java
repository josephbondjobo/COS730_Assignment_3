/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutionPackage;

import Entities.Algorithms;
import Entities.Datasets;
import Entities.Experiments;
import Entities.Experiments;
import Entities.Task;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
    ArrayList<Task> taskList = new ArrayList<>();
    public static int gloounter = 0;
    ArrayList<String> taskServiceBus = new ArrayList<>();
    

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
    
    public ArrayList<Task> getExperiment() throws JSONException, MalformedURLException, IOException
    {
        		String url = "http://cos.mjshika.xyz/api/repo/Experiment/GetExperiment";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
                BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		//System.out.println(response.toString());
                JSONObject arrayz = new JSONObject(response.toString());
                //System.out.println("real shit:"+arrayz);
        String message;
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
    
        algorithms1.put("ID", 2);
        algorithms1.put("ExperimentId", 2);
        algorithms1.put("Name", "Kudzai");
        algorithms1.put("Path", "Kudzai");
        //
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
        //
        JSONArray array = new JSONArray();
        
        JSONArray array1 = new JSONArray();
        JSONArray array2 = new JSONArray();
        
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
        
        
//        System.out.println(array);

        for(int i = 0; i< array.length(); i++)
        {
            JSONObject j = (JSONObject) array1.get(i);
            
            
            Datasets e = new Datasets();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setDatapath(j.getString("Datapath"));
            e.setExperimentId(j.getInt("ExperimentId"));
            
            datasetList.add(e);
        }
        
       for(int i = 0; i< array.length(); i++)
        {
            JSONObject j = (JSONObject) array2.get(i);
            
            
            Algorithms e = new Algorithms();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setPath(j.getString("Path"));
            e.setExperimentId(j.getInt("ExperimentId"));
            
            algorithmList.add(e);
        }
       
       for(int i = 0; i< array.length(); i++)
        {
            JSONObject j = (JSONObject) array.get(i);
            
            
            Experiments e = new Experiments();
            e.setID(j.getInt("ID"));
            e.setName(j.getString("Name"));
            e.setUser(j.getString("User"));
            
            experimentList.add(e);
        }
        Collections.shuffle(experimentList);
//        for(int i = 0; i<experimentList.size(); i++)
//        {
//            System.out.println(experimentList.get(i).getID());
//        }

        //put experiments in task objects
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
            taskList.add(t);
        }
        JSONArray o = new JSONArray();
        System.out.println(taskList.size());
        //o.put(taskList);
        
        //System.out.println(o);
        return taskList;
    }
    @Path("getTasks")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  String getTasks() throws JSONException, IOException {
         ArrayList<Task> taskList1 = new ArrayList<>();
         JSONArray o = new JSONArray();
        JSONArray b = new JSONArray();
        String a = new String();
        
       
        //if(b.length()==0){
       if( gloounter == 0){
            taskList1 = getExperiment();
            
//            for(int k = 0; k < taskList1.size(); k++ ){
//                o.put(taskList1.get(k).toString());
//            }
            o.put(taskList);
            System.out.println(o.length());
            System.out.println(taskList1.size());
//            for(int k = 0; k < taskList1.size(); k++ ){
//                b.put(taskList1.get(k).toString());
//            }
            b = o;
            gloounter = b.length();
        }
        //System.out.println(i);
         gloounter = b.length();
        
        
        a =  b.get(0).toString();
        System.out.println(taskList1.remove(0).getExperiment().toString());
        System.out.println(o.length());
       if(b.length()> 0){
        b.remove(0);
        gloounter = 0;
       }
        System.out.println(b.length());

        return a;
    }
    
    @Path("getTasks1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  String getTasks1() throws JSONException, IOException {
        JSONArray o = new JSONArray();
        if(taskServiceBus.isEmpty())
        {
            o.put(getExperiment());
        }
        System.out.println(o);
        for(int i = 0; i<o.length(); i++)
        {
            taskServiceBus.add(o.get(i).toString());
        }
        
        return taskServiceBus.remove(0);
    }
    
}
