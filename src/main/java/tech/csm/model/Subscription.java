package tech.csm.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "subscription_master")
@Getter @Setter @ToString
public class Subscription implements Serializable {

	@Id
	@Column(name = "subscription_id")
	private Integer subscriptionId;
	
	@Column(name = "subscription_type")
	private String subscriptionType;
	
	private Double fees;
	
}
