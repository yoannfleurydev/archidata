package org.kar.archidata.catcher;

import org.kar.archidata.exception.FailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class FailExceptionCatcher implements ExceptionMapper<FailException> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FailExceptionCatcher.class);
	
	@Override
	public Response toResponse(FailException exception) {
		RestErrorResponse ret = build(exception);
		LOGGER.error("Error UUID={}", ret.uuid);
		// Not display backtrace ==> this may be a normal case ...
		//exception.printStackTrace();
		return Response.status(exception.status).entity(ret).type(MediaType.APPLICATION_JSON).build();
	}
	
	private RestErrorResponse build(FailException exception) {
		return new RestErrorResponse(exception.status, "Request Fail", exception.getMessage());
	}
	
}
