package com.etroya.exception;

import com.etroya.model.ErrorMessage;
import com.sun.xml.internal.ws.api.message.Packet;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Adam on 2015-06-16.
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://etroya.pl");
        return  Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage).build();
    }
}
