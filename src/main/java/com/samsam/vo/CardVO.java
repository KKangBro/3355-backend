package com.samsam.vo;
//택주와 경윤

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardVO {
	@Id
	@SequenceGenerator(name="CARDS_SEQUENCE_GENERATOR", sequenceName = "CARDS_SEQUENCE", initialValue = 1853, allocationSize = 2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CARDS_SEQUENCE_GENERATOR")
	private Integer cardSeq;
	
	@Column(nullable = true)
	private String cardCode;
	
	@Column(nullable = false)
	private Integer cardPass;
	
	@Column(nullable = false)
	private Integer accountBalance;
	
	@Column(nullable = false)
	private Integer pointBalance;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp cardDate;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="user_no")
	private UserVO user;
}
