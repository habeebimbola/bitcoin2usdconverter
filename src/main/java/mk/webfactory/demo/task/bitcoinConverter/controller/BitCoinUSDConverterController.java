package mk.webfactory.demo.task.bitcoinConverter.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mk.webfactory.demo.task.bitcoinConverter.domain.ExchangeRateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@RestController
public class BitCoinUSDConverterController {

    private final Logger logger = LoggerFactory.getLogger(BitCoinUSDConverterController.class);
    private final RestTemplate restTemplate;

    private double currentExchangeRate = 8200d;

    @Value("${exchangeRateURL}")
    private String rateURL;

    public BitCoinUSDConverterController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/rate")
    public ResponseEntity<Float> getRate(){
        logger.info("Rate Received : {}");
        return new ResponseEntity(currentExchangeRate, HttpStatus.OK);
    }

    @RequestMapping(value="/rateBetween", method = RequestMethod.POST)
    public ResponseEntity getRateBetweenRange( @RequestBody() DateRate fromDate){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        LocalDate fromDateStr = LocalDate.parse(fromDate.fromDate,dateTimeFormatter );
        return ResponseEntity.ok(null);
    }


    @Scheduled( cron = "${exchangeRateRefresh}" )
    public void getLatestRate( )
    {
        logger.info("Refreshing latest exchange Rate!");
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
        String toDate;

        public String getFromDate() {
            return fromDate;
        }

        public void setFromDate(String fromDate) {
            this.fromDate = fromDate;
        }

        public String getToDate() {
            return toDate;
        }

        public void setToDate(String toDate) {
            this.toDate = toDate;
        }
    }
}
