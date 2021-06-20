package mk.webfactory.demo.task.bitcoinConverter.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"USD"})
public class Bpi {
    @JsonProperty("USD")
    private Usd usd;

    @JsonProperty("USD")
    public Usd getUsd() {
        return usd;
    }
    @JsonProperty("USD")
    public void setUsd(Usd usd) {
        this.usd = usd;
    }
}
