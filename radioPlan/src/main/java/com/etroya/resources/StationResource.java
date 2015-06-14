package com.etroya.resources;

import com.etroya.model.Program;
import com.etroya.model.Station;
import com.etroya.service.StationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Adam on 2015-06-14.
 */

@Path("/stations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StationResource {
    StationService stationService = new StationService();

    @GET
    public List<Station> getStations(@QueryParam("start") int start,
                                     @QueryParam("size") int size){
        if(start >= 0 && size >= 0){
            return stationService.getAllStationsPaginated(start, size);
        }
        return stationService.getAllStations();
    }

    @POST
    public Station addStation(Station station){
        stationService.addStation(station);
        return station;
    }

    @DELETE
    @Path(("/{stationId}"))
    public Station deleteStation(@PathParam("stationId") long id){
        return stationService.removeStation(id);
    }

    @GET
    @Path("/{stationId}")
    public Station getStation(@PathParam("stationId") long id){
        return stationService.getStation(id);
    }

    @PUT
    @Path("/{stationId}")
    public Station updateProgram(@PathParam("stationId") long id, Station station){
        station.setId(id);
        stationService.updateStation(station);
        return station;
    }

    @Path("/{stationId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }

    @Path("/{stationId}/programs")
    public ProgramResource getProgramResource(){
        return new ProgramResource();
    }

}
