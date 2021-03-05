package io.github.zapproject.jzap;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class Artifacts {
    public Map<String, String> map = new HashMap<String, String>();

    public Artifacts(String name) throws Exception {
        ObjectMapper om = new ObjectMapper();
        String path;
        boolean dir = false;
        

        switch (name) {
            case "ARBITER" : path = "Arbiter"; break;
            case "BONDAGE" : path = "Bondage"; break;
            case "CLIENT1": path = "Client1"; break;
            case "CLIENT2": path = "Client2"; break;
            case "CLIENT3": path = "Client3"; break;
            case "CLIENT4": path = "Client4"; break;
            case "CLIENTBYTES32ARRAY": path = "ClientBytes32Array"; break;
            case "CLIENTINTARRAY": path = "ClientIntArray"; break;
            case "CURRENTCOST": path = "CurrentCost"; break;
            case "DISPATCH": path = "Dispatch"; break;
            case "PIECEWISELOGIC": path = "PiecewiseLogic"; break;
            case "REGISTRY": path = "Registry"; break;
            case "REGISTRYINTERFACE": path = "RegistryInterface"; break;
            case "TOKENDOTFACTORY": path = "TokenDotFactory"; break;
            case "TOKENFACTORY": path = "TokenFactory"; break;
            case "ZAPCOORDINATOR": path = "ZapCoordinator"; break;
            case "ZAPCOORDINATORINTERFACE": path = "ZapCoordinatorInterface"; break;
            case "ZAPTOKEN": path = "ZapToken"; break;
            default: path = name; dir = true;
        }
        if (dir)
            map = om.readValue(new FileInputStream(path), HashMap.class);
        else{
            byte[] mapData = Files.readAllBytes(Paths.get("src/main/java/io/github/zapproject/jzap/artifacts/contracts/" + path + ".json"));
            map = om.readValue(mapData, HashMap.class);
        
        }
    }
}
