package com.etroya.exception;

import com.etroya.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Adam on 2015-06-16.
 */
    @Provider
    public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

        @Override
        public Response toResponse(Throwable ex) {
            ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://etroya.pl");
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorMessage).build();
        }
}
