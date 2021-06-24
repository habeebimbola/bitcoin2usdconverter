package mk.webfactory.demo.task.bitcoinConverter.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mk.webfactory.demo.task.bitcoinConverter.domain.base.BaseEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateBetweenWrapper extends BaseEntity {

    @JsonProperty("bpi")
    private Map<String, Object> bpi = new LinkedHashMap<>();

    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("time")
    private Map<String, Object> time = new LinkedHashMap();

    @JsonProperty("bpi")
    public Map<String, Object> getBpi() {
        return bpi;
    }

    @JsonProperty("bpi")
    public void setBpi(String key , Object value) {
        this.bpi.put(key, value);
    }

    @JsonProperty("disclaimer")
    public String getDisclaimer() {
        return disclaimer;
    }
    @JsonProperty("disclaimer")
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    @JsonProperty("time")
    public void setTime(String key, Object value){
        this.time.put(key,value);
    }
    @JsonProperty("time")
    public Map getTime() {
        return time;
    }
}
