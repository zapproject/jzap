package io.github.zapproject.jzap.artifacts.src;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.LinkedHashMap;


public class Artifacts {
    
    public String getAddress(String name, int networkID) throws Exception {
        ObjectMapper om = new ObjectMapper();
        String path;
        boolean dir = false;
        String networks;
        String address;
        LinkedHashMap map;

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
            map = om.readValue(new File(path), LinkedHashMap.class);
        else{
            map = om.readValue(this.getClass().getClassLoader().getResourceAsStream("contracts/" + path + ".json"),
                    LinkedHashMap.class);
        }
        /*
            ObjectMapper is having issues with type reference as it expects Objects that are of same data type
            but abi is an array and the rest of the objects are mappings.@interface

            Manually converted networks object to string and parsed for address.
        */
        networks = map.get("networks").toString();
        address = networks.substring(networks.indexOf(String.valueOf(networkID)), networks.length());
        address = address.split("address")[1].split("=")[1];
        
        if (address.contains(","))
            address = address.substring(0, address.indexOf(","));
        else
            address = address.substring(0, address.indexOf("}"));

        return address;
    }
}
