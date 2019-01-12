package com.singleton.test;


import java.net.InetAddress;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;

public class ElasticSearch {


	
	
	public static void main(String[] args) {
		
		
//		select dttime, avg(cpu) from table cpustats where server="X" and dttime="Y" group by dttime,cpu;
		System.out.println();
		Client client;
//		Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "elasticsearch").put("network.host","localhost").build();
		client = new TransportClient().addTransportAddress(new InetSocketTransportAddress("http://localhost", 9300));
		
		SearchResponse response= client.prepareSearch("******").setQuery(QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(),
                FilterBuilders.andFilter(
                        FilterBuilders.termFilter("tablename","7501614")
                )))/*.addAggregation(
                AggregationBuilders.terms("dt_timeaggs").field("dt_time").size(100).subAggregation(
                        AggregationBuilders.terms("cpu_aggs").field("cpu").size(100)
                )*/
        .setSize(0).get();
	}
}
