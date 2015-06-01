package com.etroya.service;

import com.etroya.model.Program;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Adam on 2015-06-01.
 */
public class ProgramService {

    public List<Program> getAllPrograms(){
        Program p1 = new Program(1, "Informacje dnia",new Date(), new Date(), "TRWAM TV");
        Program p2 = new Program(1, "Fakty",new Date(), new Date(), "TVN");
        Program p3 = new Program(1, "Wiadomości",new Date(), new Date(), "TVP");
        ArrayList<Program> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }
}
