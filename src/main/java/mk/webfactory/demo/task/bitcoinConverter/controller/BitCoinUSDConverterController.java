package mk.webfactory.demo.task.bitcoinConverter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mk.webfactory.demo.task.bitcoinConverter.domain.ExchangeRateWrapper;
import mk.webfactory.demo.task.bitcoinConverter.domain.RateBetweenWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**@author ANIMASHAUN HABEEB ABIMBOLA
 * This REST Controller retrieves latest BitCoin Rate To USD,
 * And A Historical BitCoin Rates Between Dates.
 * It exposes these Service via it's public APIs
 * */
@RestController
public class BitCoinUSDConverterController {

    private final Logger logger = LoggerFactory.getLogger(BitCoinUSDConverterController.class);
    private final RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();
    private double currentExchangeRate = 8200d;

    @Value("${exchangeRateURL}")
    private String rateURL;

    @Value("${exchangeRateBetweenDateURL}")
    private String rateBetweenDatesURL;

    public BitCoinUSDConverterController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/rate")
    public ResponseEntity<Float> getRate(){
        return new ResponseEntity(currentExchangeRate, HttpStatus.OK);
    }

    @RequestMapping(value="/rateBetween", method = RequestMethod.POST)
    public ResponseEntity<RateBetweenWrapper> getRateBetweenRange( @RequestBody() DateRate dateRate) throws JsonProcessingException {

        Map params = new HashMap<>();
        params.put("startDate", dateRate.fromDate);
        params.put("endDate", dateRate.endDate);

        ResponseEntity<JsonNode> responseEntity = this.restTemplate.getForEntity(this.rateBetweenDatesURL, JsonNode.class, params);

        if( responseEntity.getStatusCode() == HttpStatus.OK)
        {
            RateBetweenWrapper rateBetweenWrapper = this.objectMapper.readValue(responseEntity.getBody().toString(), RateBetweenWrapper.class);
            return new ResponseEntity<>( rateBetweenWrapper, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @Scheduled( cron = "${exchangeRateRefresh}" )
    public void getLatestRate( )
    {
        ResponseEntity<ExchangeRateWrapper> rate =  this.restTemplate.getForEntity(URI.create(rateURL), ExchangeRateWrapper.class);
        this.currentExchangeRate = rate.getBody().getBpi().getUsd().getRate_float();
    }

    @InitBinder
    public void dateFormatter(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter());
    }

    @JsonSerialize
    private static class DateRate{

        String fromDate;
        String endDate;

        public String getFromDate() {
            return fromDate;
        }

        public void setFromDate(String fromDate) {
            this.fromDate = fromDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
    }
}
