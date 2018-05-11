/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutionPackage;

import Entities.Algorithms;
import Entities.Datasets;
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
    static LinkedList<String> taskServiceBus = new LinkedList<>();
    

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
        //get experiments from Repository
        String url = "http://cos.mjshika.xyz/api/repo/Experiment/GetExperiment";
		
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	// optional default is GET
	con.setRequestMethod("GET");

	//add request header
	con.setRequestProperty("User-Agent", USER_AGENT);

	int responseCode = con.getResponseCode();
	
        BufferedReader in = new BufferedReader(
	new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();

	// experiments array from call
        //JSONArray arrayExperiments = new JSONArray(response.toString());
        
                
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
        
        

        //add datasets to datasetsList
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
       
        //add algorithms to algorithmsList
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
    public  String getTasks1() throws JSONException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        
        if(taskServiceBus.isEmpty())
        {
            
            ArrayList<Task> t = getExperiment();
            
            for (int i = 0; i < t.size(); i++) 
            {
                String jsonInString = mapper.writeValueAsString(t.get(i));
                taskServiceBus.add(jsonInString);
            }
        }
        System.out.println("Task Service bus size: "+taskServiceBus.size());
        
        return taskServiceBus.pop();
    }
    
}
