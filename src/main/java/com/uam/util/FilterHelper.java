package com.uam.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FilterHelper 
{
	
	public static List<Filter> convertPrimeFilter(Map<String, String> primeFilters)
	{
	
		List<Filter> filters = new ArrayList<Filter>(primeFilters.size());	
		for(Entry<String, String> entry: primeFilters.entrySet())
		{
			String value = entry.getValue();
			if(value != null)
			{
				value = value.trim();
			}
			
			filters.add(new Filter(entry.getKey(), value));
		}		
		return filters;
	}
}
