package mk.webfactory.demo.task.bitcoinConverter.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"updated","updatedISO","updateuk"})
public class Time {

    @JsonProperty("updated")
    private String updated;
    @JsonProperty("updatedISO")
    private String updatedISO;
    @JsonProperty("updateuk")
    private String updateduk;

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }
    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }
    @JsonProperty("updatedISO")
    public String getUpdatedISO() {
        return updatedISO;
    }
    @JsonProperty("updatedISO")
    public void setUpdatedISO(String updatedISO) {
        this.updatedISO = updatedISO;
    }
    @JsonProperty("updateuk")
    public String getUpdateduk() {
        return updateduk;
    }
    @JsonProperty("updateuk")
    public void setUpdateduk(String updateduk) {
        this.updateduk = updateduk;
    }
}
