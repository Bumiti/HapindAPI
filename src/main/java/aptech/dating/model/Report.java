package aptech.dating.model;
// Generated Oct 30, 2023, 4:19:04 PM by Hibernate Tools 4.3.6.Final

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Report generated by hbm2java
 */
@Entity
@Table(name = "report")
public class Report implements java.io.Serializable {

	private Integer id;
	private Reason reason;
	private User userByReportedId;
	private User userByReporterId;
	private String description;
	private Date createdAt;
	private String status;
	private Set<Evidence> evidences = new HashSet<Evidence>(0);

	public Report() {
	}

	public Report(String status, Reason reason, User userByReportedId, User userByReporterId, String description, Date createdAt) {
		this.status = status;
		this.reason = reason;
		this.userByReportedId = userByReportedId;
		this.userByReporterId = userByReporterId;
		this.description = description;
		this.createdAt = createdAt;
	}

	public Report(String status,Reason reason, User userByReportedId, User userByReporterId, String description, Date createdAt,
			Set<Evidence> evidences) {
		this.status = status;
		this.reason = reason;
		this.userByReportedId = userByReportedId;
		this.userByReporterId = userByReporterId;
		this.description = description;
		this.createdAt = createdAt;
		this.evidences = evidences;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	 @JsonIgnore @JoinColumn(name = "reason_id", nullable = false)
	public Reason getReason() {
		return this.reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	 @JsonIgnore @JoinColumn(name = "reported_id", nullable = false)
	public User getUserByReportedId() {
		return this.userByReportedId;
	}

	public void setUserByReportedId(User userByReportedId) {
		this.userByReportedId = userByReportedId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	 @JsonIgnore @JoinColumn(name = "reporter_id", nullable = false)
	public User getUserByReporterId() {
		return this.userByReporterId;
	}

	public void setUserByReporterId(User userByReporterId) {
		this.userByReporterId = userByReporterId;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 23)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report")
	public Set<Evidence> getEvidences() {
		return this.evidences;
	}

	public void setEvidences(Set<Evidence> evidences) {
		this.evidences = evidences;
	}

}
