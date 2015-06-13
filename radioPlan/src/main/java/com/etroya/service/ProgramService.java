package com.etroya.service;

import com.etroya.database.DatabaseClass;
import com.etroya.model.Message;
import com.etroya.model.Program;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2015-06-01.
 */
public class ProgramService {
    private Map<Long, Program> programs = DatabaseClass.getPrograms();

    public ProgramService(){
        programs.put(1L, new Program(1, "Informacje dnia",new Date(), new Date(), "TRWAM TV"));
        programs.put(2L, new Program(2, "Fakty",new Date(), new Date(), "TVN"));
        programs.put(3L, new Program(3, "Wiadomości",new Date(), new Date(), "TVP"));
    }

    public List<Program> getAllPrograms(){
       return new ArrayList<Program>(programs.values());
    }

    public List<Program> getAllProgramsPaginated(int start, int size){
        List<Program> list = new ArrayList<>(programs.values());
        return list.subList(start, start+size);
    }

    public Program getProgram(long id) {
        return programs.get(id);
    }

    public Program addProgram(Program program){
        program.setId(programs.size()+1);
        programs.put(program.getId(), program);
        return program;
    }

    public Program updateProgram(Program program){
        if(program.getId() <= 0){
            return null;
        }else{
            programs.put(program.getId(), program);
            return program;
        }
    }

    public Program removeProgram(long id){
        return programs.remove(id);
    }
}
