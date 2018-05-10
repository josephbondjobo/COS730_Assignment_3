package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i
 */
public class Measurements {
    private int ID;
    private int ExperimentId;
    private String Name;
    private int CpuTime;
    private int CpuUsage;
    private int ElapsedTime;
    private int EnergyGenerated;
    private int HeatGenerated;
    private int MemoryUsage;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getExperimentId() {
        return ExperimentId;
    }

    public void setExperimentId(int ExperimentId) {
        this.ExperimentId = ExperimentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCpuTime() {
        return CpuTime;
    }

    public void setCpuTime(int CpuTime) {
        this.CpuTime = CpuTime;
    }

    public int getCpuUsage() {
        return CpuUsage;
    }

    public void setCpuUsage(int CpuUsage) {
        this.CpuUsage = CpuUsage;
    }

    public int getElapsedTime() {
        return ElapsedTime;
    }

    public void setElapsedTime(int ElapsedTime) {
        this.ElapsedTime = ElapsedTime;
    }

    public int getEnergyGenerated() {
        return EnergyGenerated;
    }

    public void setEnergyGenerated(int EnergyGenerated) {
        this.EnergyGenerated = EnergyGenerated;
    }

    public int getHeatGenerated() {
        return HeatGenerated;
    }

    public void setHeatGenerated(int HeatGenerated) {
        this.HeatGenerated = HeatGenerated;
    }

    public int getMemoryUsage() {
        return MemoryUsage;
    }

    public void setMemoryUsage(int MemoryUsage) {
        this.MemoryUsage = MemoryUsage;
    }
    
    
}
