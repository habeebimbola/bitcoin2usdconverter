package mk.webfactory.demo.task.bitcoinConverter.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code","rate","description","rate_float"})
public class Usd {
    @JsonProperty("code")
    private String code;
    @JsonProperty("rate")
    private String rate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("rate_float")
    private float rate_float;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }
    @JsonProperty("rate")
    public String getRate() {
        return rate;
    }
    @JsonProperty("rate")
    public void setRate(String rate) {
        this.rate = rate;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty("rate_float")
    public float getRate_float() {
        return rate_float;
    }
    @JsonProperty("rate_float")
    public void setRate_float(float rate_float) {
        this.rate_float = rate_float;
    }
}
