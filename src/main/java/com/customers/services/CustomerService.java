package com.customers.services;

import com.google.cloud.bigquery.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerService {


    public List<Object>findAll() throws Exception {
        List<Object> objectList = new LinkedList<>();
        BigQuery bigQuery = BigQueryOptions.newBuilder().setProjectId("testing-359803").build().getService();
        String FIND_ALL = "SELECT * FROM testing-359803.customer_ds.transactions";
        QueryJobConfiguration queryJobConfiguration = QueryJobConfiguration.newBuilder(FIND_ALL).build();
        Job job = bigQuery.create(JobInfo.newBuilder(queryJobConfiguration).build());
        if(job==null){
            throw new Exception("Job no longer exists");
        }
        if(job.getStatus().getError()!=null){
            throw new Exception(job.getStatus().getError().toString());
        }
        TableResult tableResult = job.getQueryResults();
        for(FieldValueList row : tableResult.iterateAll()){

        }
        return objectList;
    }


}
