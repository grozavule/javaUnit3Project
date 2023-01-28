package com.javaunit3.springmvc;

import javax.persistence.*;

@Entity
@Table(name="votes")
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vote_id")
    private Integer voteId;
    @Column(name="voter_name")
    private String voterName;

    public VoteEntity(){}
    public VoteEntity(String voterName){
        this.voterName = voterName;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }
}
