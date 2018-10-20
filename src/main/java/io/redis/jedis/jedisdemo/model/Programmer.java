package io.redis.jedis.jedisdemo.model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString
@EqualsAndHashCode
public class Programmer implements Serializable{

	private static final long serialVersionUID = 6948899484429625250L;
	
	private int id;
	private String name;
	private String company;
	
}
