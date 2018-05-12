/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;

/**
 *
 * @author i
 */
public class Task {
    private Experiments experiment;
    private ArrayList<Datasets> dataset;
    private ArrayList<Algorithms> algorithm;
    private ArrayList<Measurements> measurement;

   

    public Task()
    {
        experiment = new Experiments();
        dataset = new ArrayList<>();
        algorithm = new ArrayList<>();
        measurement = new ArrayList<>();
    }

    public Experiments getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiments experiment) {
        this.experiment = experiment;
    }

    public ArrayList<Datasets> getDataset() {
        return dataset;
    }

    public void setDataset(ArrayList<Datasets> dataset) {
        this.dataset = dataset;
    }

    public ArrayList<Algorithms> getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(ArrayList<Algorithms> algorithm) {
        this.algorithm = algorithm;
    }
    
     public ArrayList<Measurements> getMeasurement() {
        return measurement;
    }

    public void setMeasurement(ArrayList<Measurements> measurement) {
        this.measurement = measurement;
    }
    
    
}
