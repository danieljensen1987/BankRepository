package dk.cphbusiness.bank;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

@Path("bank")
public class BankResource
{
    private static final Map<String, Bank> banks = new ConcurrentHashMap<>();
    
    {
        banks.put("007", new Bank("007", "James Bond", "http://bondagebanking.uk/Bond"));
        banks.put("4711", new Bank("4711", "Kurt Sonja", "http://bondagebanking.uk/Bond"));
    }

    @Context
    private UriInfo context;
    
    public BankResource(){
    }
    

    @GET
    @Produces({"application/json", "application/xml"})
    public Collection<Bank> findAll(){
        return banks.values();
    }
    
    @GET
    @Path("{reg}")
    @Produces({"application/json", "application/xml"})
    public Bank find(@PathParam("reg") String reg){
        return banks.get(reg);
    }
    
    @POST
    @Consumes({"application/json", "application/xml"})
    public void create (Bank bank){
        banks.put(bank.getReg(), bank);
    }
    
    @DELETE
    @Path("{reg}")
    public void remove(@PathParam("reg") String reg){
        banks.remove(reg);
    }
}
