package mk.webfactory.demo.task.bitcoinConverter.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mk.webfactory.demo.task.bitcoinConverter.domain.base.BaseEntity;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bpi","time","disclaimer"})
public class ExchangeRateWrapper extends BaseEntity {

    @JsonProperty("bpi")
    private Bpi bpi;
    @JsonProperty("time")
    private Time time;
    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("bpi")
    public Bpi getBpi() {
        return bpi;
    }
    @JsonProperty("bpi")
    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }
    @JsonProperty("time")
    public Time getTime() {
        return time;
    }
    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
    }
    @JsonProperty("disclaimer")
    public String getDisclaimer() {
        return disclaimer;
    }
    @JsonProperty("disclaimer")
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }
}
