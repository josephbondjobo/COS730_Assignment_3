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
public class Algorithms {
    private int ID;
    private int UserId;
    private String Name;
    private String Language;
    private String FilePath;
    private String CompileCommand;
    private String RunCommand;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }

    public String getCompileCommand() {
        return CompileCommand;
    }

    public void setCompileCommand(String CompileCommand) {
        this.CompileCommand = CompileCommand;
    }

    public String getRunCommand() {
        return RunCommand;
    }

    public void setRunCommand(String RunCommand) {
        this.RunCommand = RunCommand;
    }

    
    
    
}
