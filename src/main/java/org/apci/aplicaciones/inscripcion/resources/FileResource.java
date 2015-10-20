package org.apci.aplicaciones.inscripcion.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apci.aplicaciones.inscripcion.models.Usuario;
import org.apci.aplicaciones.util.FileUtil;
import org.apci.aplicaciones.util.auth.Authentication;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/file")
public class FileResource {
	
    @GET
    @Path("/download/{RUC}/{ExperienciaId}/{FileName}")
    @Produces("application/zip")
    public Response downloadZippedFile(	@PathParam("RUC") String pRUC,
    									@PathParam("ExperienciaId") String pExperienciaId,
    									@PathParam("FileName") String pFileName ) 
    {
 
    	String fileName = pRUC + "/" + pExperienciaId +  "/" + pFileName;
    	
        File file = new File(FileUtil.UPLOAD_FILE_SERVER + fileName);
 
        ResponseBuilder responseBuilder = Response.ok((Object) file);
        responseBuilder.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        return responseBuilder.build();
    }
 
    @POST
    @Path("/upload/{ExperienciaId}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadZippedFile(@Context HttpServletRequest pRequest,@PathParam("ExperienciaId") String pExperienciaId,
            @FormDataParam("uploadFile") InputStream fileInputStream,
            @FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition)
    {
    	Usuario user = Authentication.getUser(pRequest);
    	
    	String directory = null;    	
        String fileName = null;
        String uploadFilePath = null;
 
        try {
            
        	directory = user.getUsuario() + "/" + pExperienciaId + "/";
        	fileName = directory + fileFormDataContentDisposition.getFileName();
            
        	if (FileUtil.createDirectory(directory)) {
        		uploadFilePath = FileUtil.writeToFileServer(fileInputStream, fileName);
        	}
            
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally{

        }
        return Response.ok("File uploaded successfully at " + uploadFilePath).build();
    }

}
