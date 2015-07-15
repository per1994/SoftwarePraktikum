package org.plp.gamification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.plp.benutzer.Benutzer;

@Entity
@Table(name = "TEAM")
public class Team {

	@Id
	@Column(name = "team_id")
	@GeneratedValue
	private int team_id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "TEAM_MITGLIED", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> teamMitglieder;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "teamcombat_id")
	private Teamcombat teamCombat;
	
	public Team(){
		teamMitglieder= new HashSet<Benutzer>();
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public Set<Benutzer> getTeamMitglieder() {
		return teamMitglieder;
	}

	public void setTeamMitglieder(Set<Benutzer> teamMitglieder) {
		this.teamMitglieder = teamMitglieder;
	}

	public Teamcombat getTeamCombat() {
		return teamCombat;
	}

	public void setTeamCombat(Teamcombat teamCombat) {
		this.teamCombat = teamCombat;
	}
}
