package com.clip.gwr.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> additionalInfo;
	private String deptSeq;
    private String deptName;
    private String ranksSeq;
    private String ranksName;
    private String positionsSeq;
    private String positionsName;
    private String userStatus;
    private String userRealname;

    public CustomUserDetails(UserDetails user, Map<String, Object> additionalInfo) {
        super(user.getUsername(), user.getPassword(), user.getAuthorities());
        this.additionalInfo = additionalInfo;
    }

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
            Map<String, Object> additionalInfo) {
        super(username, password, authorities);
        this.additionalInfo = additionalInfo;
    }

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getDeptSeq() {
        return deptSeq;
    }

    public void setDeptSeq(String deptSeq) {
        this.deptSeq = deptSeq;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRanksSeq() {
        return ranksSeq;
    }

    public void setRanksSeq(String ranksSeq) {
        this.ranksSeq = ranksSeq;
    }

    public String getRanksName() {
        return ranksName;
    }

    public void setRanksName(String ranksName) {
        this.ranksName = ranksName;
    }

    public String getPositionsSeq() {
        return positionsSeq;
    }

    public void setPositionsSeq(String positionsSeq) {
        this.positionsSeq = positionsSeq;
    }

    public String getPositionsName() {
        return positionsName;
    }

    public void setPositionsName(String positionsName) {
        this.positionsName = positionsName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }
}


