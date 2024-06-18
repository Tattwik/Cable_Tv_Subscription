package tech.csm.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "provider_master")
@Getter @Setter @ToString
public class Provider implements Serializable {
	@Id
	@Column(name = "provider_id")
	private Integer providerId;
	@Column(name = "provider_name")
	private String providerName;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "provider_scbscription", 
	joinColumns = @JoinColumn(name="provider_id"),
	inverseJoinColumns = @JoinColumn(name="subscription_id") )
	private List<Subscription> subscriptions;
	
}
